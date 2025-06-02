package br.llslucas.condominio.persistence.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import br.llslucas.condominio.model.Morador;
import br.llslucas.condominio.persistence.dao.MoradorDAO;
import br.llslucas.condominio.persistence.exceptions.NotFoundException;

public class MySqlMoradorDAO implements MoradorDAO {

  private Connection connection;

  public MySqlMoradorDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public Morador getById(Long id) throws SQLException, NotFoundException {
    String sql = "SELECT id, nome, data_nascimento, rg, cpf, residencia_id FROM morador WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, id);

    ResultSet result = statement.executeQuery();

    if (result.next()) {
      Morador morador = new Morador(
	      result.getLong("id"),
	      result.getString("nome"),
	      result.getDate("data_nascimento"),
	      result.getString("rg"),
	      result.getString("cpf"),
	      result.getLong("residencia_id"));

      return morador;
    } else {
      throw new NotFoundException("Morador id: " + id + " não existe.");
    }
  }

  @Override
  public Map<Long, Morador> list() throws SQLException {
    String sql = "SELECT id, nome, data_nascimento, rg, cpf, residencia_id FROM morador";

    PreparedStatement statement = connection.prepareStatement(sql);

    ResultSet result = statement.executeQuery();
    Map<Long, Morador> moradores = new TreeMap<>();

    while (result.next()) {
      moradores.put(
	      result.getLong("id"),
	      new Morador(
		      result.getLong("id"),
		      result.getString("nome"),
		      result.getDate("data_nascimento"),
		      result.getString("rg"),
		      result.getString("cpf"),
		      result.getLong("residencia_id")));
    }

    return moradores;
  }

  @Override
  public Map<Long, Morador> listByResidencia(Long condominioId) throws SQLException {
    String sql = "SELECT id, nome, data_nascimento, rg, cpf, residencia_id FROM morador WHERE residencia_id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, condominioId);

    ResultSet result = statement.executeQuery();
    Map<Long, Morador> moradores = new TreeMap<>();

    while (result.next()) {
      moradores.put(
	      result.getLong("id"),
	      new Morador(
		      result.getLong("id"),
		      result.getString("nome"),
		      result.getDate("data_nascimento"),
		      result.getString("rg"),
		      result.getString("cpf"),
		      result.getLong("residencia_id")));
    }

    return moradores;
  }

  @Override
  public void create(Morador morador) throws SQLException {
    String sql = "INSERT INTO morador(nome, data_nascimento, rg, cpf, residencia_id) VALUES (?, ? ,? ,?, ?)";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, morador.getNome());
    statement.setDate(2, morador.getDataNascimento());
    statement.setString(3, morador.getRg());
    statement.setString(4, morador.getCpf());
    statement.setLong(5, morador.getResidenciaId());

    statement.executeUpdate();
  }

  @Override
  public void save(Morador morador) throws SQLException {
    String sql = "UPDATE morador SET nome = ?, data_nascimento = ?, rg = ?, cpf = ?, residencia_id = ? WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, morador.getNome());
    statement.setDate(2, morador.getDataNascimento());
    statement.setString(3, morador.getRg());
    statement.setString(4, morador.getCpf());
    statement.setLong(5, morador.getResidenciaId());
    statement.setLong(6, morador.getId());

    statement.executeUpdate();
  }

  @Override
  public void delete(Morador morador) throws SQLException {
    String sql = "DELETE FROM morador WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, morador.getId());

    statement.executeUpdate();
  }
}
