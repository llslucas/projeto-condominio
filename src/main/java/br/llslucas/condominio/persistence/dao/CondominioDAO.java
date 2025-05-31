package br.llslucas.condominio.persistence.dao;

import java.util.Map;

import br.llslucas.condominio.model.Condominio;

public interface CondominioDAO {
  public Condominio getById(long id) throws Exception;
  public Map<Long, Condominio> list() throws Exception;
  public void create(Condominio condominio) throws Exception;
  public void save(Condominio condominio) throws Exception;
  public void delete(Condominio condominio) throws Exception;
}
