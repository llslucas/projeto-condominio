package br.llslucas.condominio.persistence;

import br.llslucas.condominio.persistence.factory.DAOFactory;

public class DAOClient {

  private DAOFactory dAOFactory;

  public DAOClient(DAOFactory dAOFactory) {
    this.dAOFactory = dAOFactory;
  }

  public DAOFactory getdAOFactory() {
    return dAOFactory;
  }

  public void setdAOFactory(DAOFactory dAOFactory) {
    this.dAOFactory = dAOFactory;
  }

}
