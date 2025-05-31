package br.llslucas.condominio.model;

import java.sql.Date;

public class Fatura {

  private long id;
  private double valor;
  private Date dataVencimento;
  private Date dataPagamento;
  private String status;
  private long residenciaId;
  private long moradorId;

  public Fatura() {

  }

  public Fatura(long id, double valor, Date dataVencimento, Date dataPagamento, String status, long residenciaId,
      long moradorId) {
    this.id = id;
    this.valor = valor;
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
    this.status = status;
    this.residenciaId = residenciaId;
    this.moradorId = moradorId;
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

  public Date getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public Date getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getResidenciaId() {
    return residenciaId;
  }

  public void setResidenciaId(long residenciaId) {
    this.residenciaId = residenciaId;
  }

  public long getMoradorId() {
    return moradorId;
  }

  public void setMoradorId(long moradorId) {
    this.moradorId = moradorId;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
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

    final Fatura other = (Fatura) obj;
    return this.id == other.id;
  }

}
