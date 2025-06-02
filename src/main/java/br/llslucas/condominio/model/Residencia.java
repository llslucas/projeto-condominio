package br.llslucas.condominio.model;

public class Residencia implements Comparable<Residencia> {

  private Long id;
  private String rua;
  private Long numero;
  private String cep;
  private String tipo;
  private String status;
  private Long proprietarioId;
  private Long condominioId;

  public Residencia() {

  }

  public Residencia(String rua, Long numero, String cep, String tipo, Long proprietarioId, Long condominioId) {
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.tipo = tipo;
    this.proprietarioId = proprietarioId;
    this.condominioId = condominioId;
  }

  public Residencia(Long id, String rua, Long numero, String cep, String tipo, Long proprietarioId, Long condominioId) {
    this.id = id;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.tipo = tipo;
    this.proprietarioId = proprietarioId;
    this.condominioId = condominioId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getProprietarioId() {
    return proprietarioId;
  }

  public void setProprietarioId(Long proprietarioId) {
    this.proprietarioId = proprietarioId;
  }

  public Long getCondominioId() {
    return condominioId;
  }

  public void setCondominioId(Long condominioId) {
    this.condominioId = condominioId;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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

    final Residencia other = (Residencia) obj;
    return this.id.equals(other.id);
  }

  @Override
  public String toString() {
    return this.getId() + " - " + this.getRua() + " - " + this.getNumero();
  }

  @Override
  public int compareTo(Residencia o) {
    return (int) (this.id - o.id);
  }
}
