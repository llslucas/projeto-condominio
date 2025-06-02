package br.llslucas.condominio.controller;

import java.util.Map;

public interface Controller<T> {

  public abstract T getById(Long id) throws Exception;

  public abstract Map<Long, T> list() throws Exception;

  public abstract void create(T object) throws Exception;

  public abstract void update(T object) throws Exception;

  public abstract void delete(T object) throws Exception;
}
