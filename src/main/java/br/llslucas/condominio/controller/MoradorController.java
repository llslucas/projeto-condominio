package br.llslucas.condominio.controller;

import java.util.Map;

import br.llslucas.condominio.model.Morador;
import br.llslucas.condominio.persistence.DAOClient;

public class MoradorController implements Controller<Morador> {

  private DAOClient dao;

  public MoradorController(DAOClient dao) {
    this.dao = dao;
  }

  @Override
  public Morador getById(Long id) throws Exception {
    try {
      return dao.createMoradorDAO().getById(id);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public Map<Long, Morador> list() throws Exception {
    try {
      return dao.createMoradorDAO().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public Map<Long, Morador> listByResidencia(Long residenciaId) throws Exception {
    try {
      return dao.createMoradorDAO().listByResidencia(residenciaId);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void create(Morador morador) throws Exception {
    try {
      dao.createMoradorDAO().create(morador);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void update(Morador morador) throws Exception {
    try {
      dao.createMoradorDAO().save(morador);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public void delete(Morador morador) throws Exception {
    try {
      dao.createMoradorDAO().delete(morador);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
