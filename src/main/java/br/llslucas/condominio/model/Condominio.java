package br.llslucas.condominio.model;

import java.util.ArrayList;

public class Condominio {

  private long id;
  private String cnpj;
  private String razaoSocial;
  private ArrayList<Residencia> residencias;

  public Condominio() {

  }

  public Condominio(long id, String cnpj, String razaoSocial, ArrayList<Residencia> residencias) {
    this.id = id;
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
    this.residencias = residencias;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public ArrayList<Residencia> getResidencias() {
    return residencias;
  }

  public void setResidencias(ArrayList<Residencia> residencias) {
    this.residencias = residencias;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    
    if (obj == null) {
      return false;
    }
    
    if (getClass() != obj.getClass()) {
      return false;
    }
    
    final Condominio other = (Condominio) obj;
    return this.id == other.id;
  }

}
