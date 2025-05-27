package br.llslucas.condominio.persistence.dto;

import java.util.ArrayList;

public class CondominioDTO {

  private long id;
  private String cnpj;
  private String razao_social;
  private ArrayList<Long> residencias;

  public CondominioDTO() {
  }

  public CondominioDTO(long id, String cnpj, String razao_social, ArrayList<Long> residencias) {
    this.id = id;
    this.cnpj = cnpj;
    this.razao_social = razao_social;
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

  public String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(String razao_social) {
    this.razao_social = razao_social;
  }

  public ArrayList<Long> getResidencias() {
    return residencias;
  }

  public void setResidencias(ArrayList<Long> residencias) {
    this.residencias = residencias;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final CondominioDTO other = (CondominioDTO) obj;
    return this.id == other.id;
  }
}
