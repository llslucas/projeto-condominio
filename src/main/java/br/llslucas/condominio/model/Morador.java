package br.llslucas.condominio.model;
import java.sql.Date;

public class Morador implements Comparable<Morador>{

  private Long id;
  private String nome;
  private Date dataNascimento;
  private String rg;
  private String cpf;
  private Long residenciaId;

  public Morador() {

  }

  public Morador(String nome, Date datanascimento, String rg, String cpf, Long residenciaId) {
    this.nome = nome;
    this.dataNascimento = datanascimento;
    this.rg = rg;
    this.cpf = cpf;
    this.residenciaId = residenciaId;
  }

  public Morador(Long id, String nome, Date datanascimento, String rg, String cpf, Long residenciaId) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = datanascimento;
    this.rg = rg;
    this.cpf = cpf;
    this.residenciaId = residenciaId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date datanascimento) {
    this.dataNascimento = datanascimento;
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

  public Long getResidenciaId() {
    return residenciaId;
  }

  public void setResidencia(Long residenciaId) {
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
    return this.id.equals(other.id);
  }
  
  @Override
  public String toString() {
    return this.getId() + " - " + this.getNome();
  } 

  @Override
  public int compareTo(Morador o) {
    return (int) (this.id - o.id);
  }
}
