package br.llslucas.condominio.persistence.dto;

import java.util.ArrayList;

public class ResidenciaDTO {

  private long id;
  private String rua;
  private long numero;
  private String cep;
  private long proprietario;
  private ArrayList<Long> moradores;

  public ResidenciaDTO() {
  }

  public ResidenciaDTO(long id, String rua, long numero, String cep, long proprietario, ArrayList<Long> moradores) {
    this.id = id;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.proprietario = proprietario;
    this.moradores = moradores;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public long getNumero() {
    return numero;
  }

  public void setNumero(long numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public long getProprietario() {
    return proprietario;
  }

  public void setProprietario(long proprietario) {
    this.proprietario = proprietario;
  }

  public ArrayList<Long> getMoradores() {
    return moradores;
  }

  public void setMoradores(ArrayList<Long> moradores) {
    this.moradores = moradores;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final ResidenciaDTO other = (ResidenciaDTO) obj;
    return this.id == other.id;
  }

}
