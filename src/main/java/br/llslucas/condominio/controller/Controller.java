package br.llslucas.condominio.controller;

import java.util.ArrayList;

public interface Controller<T> {

	public abstract boolean create();

	public abstract boolean update();

	public abstract T get();

	public abstract ArrayList<T> list();

	public abstract boolean delete(T item);

}
