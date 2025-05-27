package br.llslucas.condominio.persistence.dto;

import java.util.ArrayList;

public class MoradorDTO {

  private long id;
  private String nome;
  private int idade;
  private String rg;
  private String cfp;
  private ArrayList<Long> faturas;

  public MoradorDTO() {
  }

  public MoradorDTO(long id, String nome, int idade, String rg, String cfp, ArrayList<Long> faturas) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.rg = rg;
    this.cfp = cfp;
    this.faturas = faturas;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getCfp() {
    return cfp;
  }

  public void setCfp(String cfp) {
    this.cfp = cfp;
  }

  public ArrayList<Long> getFaturas() {
    return faturas;
  }

  public void setFaturas(ArrayList<Long> faturas) {
    this.faturas = faturas;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final MoradorDTO other = (MoradorDTO) obj;
    return this.id == other.id;
  }

}
