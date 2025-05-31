package br.llslucas.condominio.persistence.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.llslucas.condominio.model.Residencia;
import br.llslucas.condominio.persistence.dao.ResidenciaDAO;
import br.llslucas.condominio.persistence.exceptions.NotFoundException;

public class MySqlResidenciaDAO implements ResidenciaDAO {
  private Connection connection;

  public MySqlResidenciaDAO(Connection connection){
    this.connection = connection;
  }

  @Override
  public Residencia getById(long id) throws SQLException, NotFoundException {
    String sql = "SELECT id, rua, numero, cep, tipo, proprietario_id, condominio_id FROM residencia WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, id);

    ResultSet result = statement.executeQuery();

    if (result.next()) {
      Residencia residencia = new Residencia(
          result.getLong("id"),
          result.getString("rua"),
          result.getLong("numero"),
          result.getString("cep"),
          result.getString("tipo"),
          result.getLong("proprietario_id"),
          result.getLong("condominio_id"));

      return residencia;
    } else {
      throw new NotFoundException("Residência id: " + id + " não existe.");
    }
  }

  @Override
  public Map<Long, Residencia> list() throws SQLException {
    String sql = "SELECT rua, numero, cep, tipo, proprietario_id, condominio_id FROM residencia";

    PreparedStatement statement = connection.prepareStatement(sql);

    ResultSet result = statement.executeQuery();
    Map<Long, Residencia> residencias = new HashMap<>();

    while (result.next()) {
      residencias.put(
          result.getLong("id"),
          new Residencia(
              result.getLong("id"),
              result.getString("rua"),
              result.getLong("numero"),
              result.getString("cep"),
              result.getString("tipo"),
              result.getLong("proprietario_id"),
              result.getLong("condominio_id")));
    }

    return residencias;
  }

  @Override
  public Map<Long, Residencia> listByCondominio(long condominioId) throws SQLException {
    String sql = "SELECT rua, numero, cep, tipo, proprietario_id, condominio_id FROM residencia WHERE condominio_id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, condominioId);

    ResultSet result = statement.executeQuery();
    Map<Long, Residencia> residencias = new HashMap<>();

    while (result.next()) {
      residencias.put(
          result.getLong("id"),
          new Residencia(
              result.getLong("id"),
              result.getString("rua"),
              result.getLong("numero"),
              result.getString("cep"),
              result.getString("tipo"),
              result.getLong("proprietario_id"),
              result.getLong("condominio_id")));
    }

    return residencias;
  }

  @Override
  public void create(Residencia residencia) throws SQLException {
    String sql = "INSERT INTO residencia(rua, numero, cep, tipo, proprietario_id, condominio_id) VALUES (?, ? ,? ,?, ?, ?)";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, residencia.getRua());
    statement.setLong(2, residencia.getNumero());
    statement.setString(3, residencia.getCep());
    statement.setString(4, residencia.getTipo());
    statement.setLong(5, residencia.getProprietarioId());
    statement.setLong(6, residencia.getCondominioId());

    statement.executeUpdate();
  }

  @Override
  public void save(Residencia residencia) throws SQLException {
    String sql = "UPDATE residencia SET rua = ?, numero = ?, cep = ?, tipo = ?, proprietario_id =?, condominio_id = ? WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, residencia.getRua());
    statement.setLong(2, residencia.getNumero());
    statement.setString(3, residencia.getCep());
    statement.setString(4, residencia.getTipo());
    statement.setLong(5, residencia.getProprietarioId());
    statement.setLong(6, residencia.getCondominioId());
    statement.setLong(7, residencia.getId());

    statement.executeUpdate();
  }

  @Override
  public void delete(Residencia residencia) throws SQLException {
    String sql = "DELETE FROM residencia WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, residencia.getId());

    statement.executeUpdate();
  }
}
