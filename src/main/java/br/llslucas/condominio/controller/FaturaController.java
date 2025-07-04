package br.llslucas.condominio.controller;

import java.util.Map;

import br.llslucas.condominio.model.Fatura;
import br.llslucas.condominio.persistence.DAOClient;
import java.sql.Date;
import java.time.LocalDate;

public class FaturaController implements Controller<Fatura> {

  private DAOClient dao;

  public FaturaController(DAOClient dao) {
    this.dao = dao;
  }

  @Override
  public Fatura getById(Long id) throws Exception {
    try {
      return dao.createFaturaDAO().getById(id);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public Map<Long, Fatura> list() throws Exception {
    try {
      return dao.createFaturaDAO().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public Map<Long, Fatura> listByMorador(Long moradorId) throws Exception {
    try {
      return dao.createFaturaDAO().listByMorador(moradorId);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public Map<Long, Fatura> listByResidencia(Long residenciaId) throws Exception {
    try {
      return dao.createFaturaDAO().listByResidencia(residenciaId);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void create(Fatura fatura) throws Exception {
    try {
      dao.createFaturaDAO().create(fatura);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void update(Fatura fatura) throws Exception {
    try {
      dao.createFaturaDAO().save(fatura);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void delete(Fatura fatura) throws Exception {
    try {
      dao.createFaturaDAO().delete(fatura);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
  
  public void pagarFatura(Fatura fatura) throws Exception{
    fatura.setDataPagamento(Date.valueOf(LocalDate.now()));
    fatura.setStatus("Pago");
    
    try {
      dao.createFaturaDAO().save(fatura);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
