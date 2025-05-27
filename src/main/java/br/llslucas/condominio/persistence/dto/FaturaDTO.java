package br.llslucas.condominio.persistence.dto;

import java.sql.Date;

public class FaturaDTO {

  private long id;
  private double valor;
  private Date vencimento;
  private String status;

  public FaturaDTO() {
  }

  public FaturaDTO(long id, double valor, Date vencimento, String status) {
    this.id = id;
    this.valor = valor;
    this.vencimento = vencimento;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Date getVencimento() {
    return vencimento;
  }

  public void setVencimento(Date vencimento) {
    this.vencimento = vencimento;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final FaturaDTO other = (FaturaDTO) obj;
    return this.id == other.id;
  }
}
