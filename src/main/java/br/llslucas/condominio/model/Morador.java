package br.llslucas.condominio.model;

public class Morador {

  private long id;
  private String nome;
  private int idade;
  private String rg;
  private String cpf;
  private long residenciaId;

  public Morador() {

  }

  public Morador(String nome, int idade, String rg, String cpf, long residenciaId) {
    this.nome = nome;
    this.idade = idade;
    this.rg = rg;
    this.cpf = cpf;
    this.residenciaId = residenciaId;
  }

  public Morador(long id, String nome, int idade, String rg, String cpf, long residenciaId) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.rg = rg;
    this.cpf = cpf;
    this.residenciaId = residenciaId;
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public long getResidenciaId() {
    return residenciaId;
  }

  public void setResidencia(long residenciaId) {
    this.residenciaId = residenciaId;
  }

  @Override
  public int hashCode() {
    int hash = 7;
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
    final Morador other = (Morador) obj;
    return this.id == other.id;
  }
}
