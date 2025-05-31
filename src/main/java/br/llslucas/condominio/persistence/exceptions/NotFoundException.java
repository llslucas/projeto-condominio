package br.llslucas.condominio.persistence.exceptions;

public class NotFoundException extends Exception {
  public NotFoundException() {
    super("SQL Data not found.");
  }

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }
}
