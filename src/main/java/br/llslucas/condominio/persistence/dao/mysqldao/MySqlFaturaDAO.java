package br.llslucas.condominio.persistence.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.llslucas.condominio.model.Fatura;
import br.llslucas.condominio.persistence.dao.FaturaDAO;
import br.llslucas.condominio.persistence.exceptions.NotFoundException;

public class MySqlFaturaDAO implements FaturaDAO {
  private Connection connection;

  public MySqlFaturaDAO(Connection connection){
    this.connection = connection;
  }

  @Override
  public Fatura getById(long id) throws SQLException, NotFoundException {
    String sql = "SELECT id, valor, data_vencimento, data_pagamento, status, residencia_id, morador_id FROM fatura WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, id);

    ResultSet result = statement.executeQuery();

    if (result.next()) {
      Fatura fatura = new Fatura(
          result.getLong("id"),
          result.getDouble("valor"),
          result.getDate("data_vencimento"),
          result.getDate("data_pagamento"),
          result.getString("status"),
          result.getLong("residencia_id"),
          result.getLong("morador_id"));

      return fatura;
    } else {
      throw new NotFoundException("Fatura id: " + id + " não existe.");
    }
  }

  @Override
  public Map<Long, Fatura> list() throws SQLException {
    String sql = "SELECT id, valor, data_vencimento, data_pagamento, status, residencia_id, morador_id FROM fatura";

    PreparedStatement statement = connection.prepareStatement(sql);

    ResultSet result = statement.executeQuery();
    Map<Long, Fatura> faturas = new HashMap<>();

    while (result.next()) {
      faturas.put(
          result.getLong("id"),
          new Fatura(
              result.getLong("id"),
              result.getDouble("valor"),
              result.getDate("data_vencimento"),
              result.getDate("data_pagamento"),
              result.getString("status"),
              result.getLong("residencia_id"),
              result.getLong("morador_id")));
    }

    return faturas;
  }

  @Override
  public Map<Long, Fatura> listByResidencia(long condominioId) throws SQLException {
    String sql = "SELECT id, valor, data_vencimento, data_pagamento, status, residencia_id, morador_id FROM fatura WHERE residencia_id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, condominioId);

    ResultSet result = statement.executeQuery();
    Map<Long, Fatura> faturas = new HashMap<>();

    while (result.next()) {
      faturas.put(
          result.getLong("id"),
          new Fatura(
              result.getLong("id"),
              result.getDouble("valor"),
              result.getDate("data_vencimento"),
              result.getDate("data_pagamento"),
              result.getString("status"),
              result.getLong("residencia_id"),
              result.getLong("morador_id")));
    }

    return faturas;
  }

  @Override
  public Map<Long, Fatura> listByMorador(long condominioId) throws SQLException {
    String sql = "SELECT id, valor, data_vencimento, data_pagamento, status, residencia_id, morador_id FROM fatura WHERE residencia_id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, condominioId);

    ResultSet result = statement.executeQuery();
    Map<Long, Fatura> faturas = new HashMap<>();

    while (result.next()) {
      faturas.put(
          result.getLong("id"),
          new Fatura(
              result.getLong("id"),
              result.getDouble("valor"),
              result.getDate("data_vencimento"),
              result.getDate("data_pagamento"),
              result.getString("status"),
              result.getLong("residencia_id"),
              result.getLong("morador_id")));
    }

    return faturas;
  }

  @Override
  public void create(Fatura fatura) throws SQLException {
    String sql = "INSERT INTO fatura(valor, data_vencimento, data_pagamento, status, residencia_id, morador_id) VALUES (?, ? ,? ,?, ?, ?)";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setDouble(1, fatura.getValor());
    statement.setDate(2, fatura.getDataVencimento());
    statement.setDate(3, fatura.getDataPagamento());
    statement.setString(4, fatura.getStatus());
    statement.setLong(5, fatura.getResidenciaId());
    statement.setLong(5, fatura.getMoradorId());

    statement.executeUpdate();
  }

  @Override
  public void save(Fatura fatura) throws SQLException {
    String sql = "UPDATE fatura SET nome = ?, idade = ?, rg = ?, cpf = ?, residencia_id = ? WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setDouble(1, fatura.getValor());
    statement.setDate(2, fatura.getDataVencimento());
    statement.setDate(3, fatura.getDataPagamento());
    statement.setString(4, fatura.getStatus());
    statement.setLong(5, fatura.getResidenciaId());
    statement.setLong(5, fatura.getMoradorId());
    statement.setLong(6, fatura.getId());

    statement.executeUpdate();
  }

  @Override
  public void delete(Fatura fatura) throws SQLException {
    String sql = "DELETE FROM fatura WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, fatura.getId());

    statement.executeUpdate();
  }

}
