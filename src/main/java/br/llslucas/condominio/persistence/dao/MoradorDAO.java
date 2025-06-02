package br.llslucas.condominio.persistence.dao;

import java.util.Map;

import br.llslucas.condominio.model.Morador;

public interface MoradorDAO {
  public Morador getById(Long id) throws Exception;
  public Map<Long, Morador> list() throws Exception;
  public Map<Long, Morador> listByResidencia(Long residencia_id) throws Exception;
  public void create(Morador morador) throws Exception;
  public void save(Morador morador) throws Exception;
  public void delete(Morador morador) throws Exception;
}
