package br.llslucas.condominio.persistence.dao;

import java.util.Map;
import br.llslucas.condominio.model.Residencia;

public interface ResidenciaDAO {
  public Residencia getById(long id) throws Exception;
  public Map<Long, Residencia> list() throws Exception;
  public Map<Long, Residencia> listByCondominio(long condominio_id) throws Exception;
  public void create(Residencia residencia) throws Exception;
  public void save(Residencia residencia) throws Exception;
  public void delete(Residencia residencia) throws Exception;
}
