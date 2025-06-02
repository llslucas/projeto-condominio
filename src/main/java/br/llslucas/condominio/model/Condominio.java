package br.llslucas.condominio.model;

public class Condominio implements Comparable<Condominio>{

  private Long id;
  private String cnpj;
  private String razaoSocial;

  public Condominio() {

  }

  public Condominio(Long id, String cnpj, String razaoSocial) {
    this.id = id;
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
  }

  public Condominio(String cnpj, String razaoSocial) {
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
    return this.id.equals(other.id);
  }
  
  @Override
  public String toString() {
    return this.getId() + " - " + this.getRazaoSocial();
  } 

  @Override
  public int compareTo(Condominio o) {
    return (int) (this.id - o.id);
  }
}
