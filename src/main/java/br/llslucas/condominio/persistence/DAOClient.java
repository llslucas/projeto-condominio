package br.llslucas.condominio.persistence;

import br.llslucas.condominio.persistence.dao.CondominioDAO;
import br.llslucas.condominio.persistence.dao.FaturaDAO;
import br.llslucas.condominio.persistence.dao.MoradorDAO;
import br.llslucas.condominio.persistence.dao.ResidenciaDAO;
import br.llslucas.condominio.persistence.factory.DAOFactory;

public class DAOClient {

  private DAOFactory daoFactory;

  public DAOClient(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  public CondominioDAO createCondominioDAO() throws Exception{
    return daoFactory.createCondominioDAO();
  }

  public MoradorDAO createMoradorDAO() throws Exception{
    return daoFactory.createMoradorDAO();
  }

  public ResidenciaDAO createResidenciaDAO() throws Exception{
    return daoFactory.createResidenciaDAO();
  }

  public  FaturaDAO createFaturaDAO() throws Exception{
    return daoFactory.createFaturaDAO();
  }
}
