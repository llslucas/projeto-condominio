package br.llslucas.condominio.persistence.dao;

import java.util.Map;

import br.llslucas.condominio.model.Fatura;

public interface FaturaDAO {
  public Fatura getById(Long id) throws Exception;
  public Map<Long, Fatura> list() throws Exception;
  public Map<Long, Fatura> listByResidencia(Long residencia_id) throws Exception;
  public Map<Long, Fatura> listByMorador(Long morador_id) throws Exception;
  public void create(Fatura fatura) throws Exception;
  public void save(Fatura fatura) throws Exception;
  public void delete(Fatura fatura) throws Exception;
}
