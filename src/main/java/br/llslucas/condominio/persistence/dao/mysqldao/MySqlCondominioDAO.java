package br.llslucas.condominio.persistence.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import br.llslucas.condominio.model.Condominio;
import br.llslucas.condominio.persistence.dao.CondominioDAO;
import br.llslucas.condominio.persistence.exceptions.NotFoundException;
import java.util.TreeMap;

public class MySqlCondominioDAO implements CondominioDAO {
  private Connection connection;

  public MySqlCondominioDAO(Connection connection){
    this.connection = connection;
  }

  @Override
  public Condominio getById(Long id) throws SQLException, NotFoundException {
    String sql = "SELECT id, cnpj, razao_social FROM condominio WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, id);

    ResultSet result = statement.executeQuery();

    if (result.next()) {
      Condominio condominio = new Condominio(
          result.getLong("id"),
          result.getString("cnpj"),
          result.getString("razao_social"));

      return condominio;
    } else {
      throw new NotFoundException("Condomínio id: " + id + " não existe.");
    }
  }

  @Override
  public Map<Long, Condominio> list() throws SQLException {
    String sql = "SELECT id, cnpj, razao_social FROM condominio";

    PreparedStatement statement = connection.prepareStatement(sql);

    ResultSet result = statement.executeQuery();
    Map<Long, Condominio> condominios = new TreeMap<>();

    while (result.next()) {
      condominios.put(
          result.getLong("id"),
          new Condominio(
              result.getLong("id"),
              result.getString("cnpj"),
              result.getString("razao_social")));
    }

    return condominios;
  }

  @Override
  public void create(Condominio condominio) throws SQLException {
    String sql = "INSERT INTO condominio(cnpj, razao_social) VALUES (? ,?)";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, condominio.getCnpj());
    statement.setString(2, condominio.getRazaoSocial());

    statement.executeUpdate();
  }

  @Override
  public void save(Condominio condominio) throws SQLException {
    String sql = "UPDATE condominio SET cnpj = ?, razao_social = ? WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, condominio.getCnpj());
    statement.setString(2, condominio.getRazaoSocial());
    statement.setLong(3, condominio.getId());

    statement.executeUpdate();
  }

  @Override
  public void delete(Condominio condominio) throws SQLException {
    String sql = "DELETE FROM condominio WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, condominio.getId());

    statement.executeUpdate();
  }
}
