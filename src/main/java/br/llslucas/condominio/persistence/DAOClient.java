package br.llslucas.condominio.persistence;

import br.llslucas.condominio.persistence.factory.DAOFactory;

public class DAOClient {

  private DAOFactory daoFactory;

  public DAOClient(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  public DAOFactory getDAOFactory() {
    return daoFactory;
  }

  public void setDAOFactory(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

}
