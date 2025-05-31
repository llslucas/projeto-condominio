package br.llslucas.condominio.model;

public class Residencia {

  private long id;
  private String rua;
  private long numero;
  private String cep;
  private String tipo;
  private long proprietarioId;
  private long condominioId;

  public Residencia() {

  }

  public Residencia(String rua, long numero, String cep, String tipo, long proprietarioId, long condominioId) {
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.tipo = tipo;
    this.proprietarioId = proprietarioId;
    this.condominioId = condominioId;
  }

  public Residencia(long id, String rua, long numero, String cep, String tipo, long proprietarioId, long condominioId) {
    this.id = id;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.tipo = tipo;
    this.proprietarioId = proprietarioId;
    this.condominioId = condominioId;
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

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public long getProprietarioId() {
    return proprietarioId;
  }

  public void setProprietarioId(long proprietarioId) {
    this.proprietarioId = proprietarioId;
  }

  public long getCondominioId() {
    return condominioId;
  }

  public void setCondominioId(long condominioId) {
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
    return this.id == other.id;
  }
}
