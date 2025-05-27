package br.llslucas.condominio.controller;

import java.util.ArrayList;

import br.llslucas.condominio.Condominio;

public class CondominioController implements Controller<Condominio> {

	@Override
	public boolean create() {
		return false;
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public Condominio get() {
		return null;
	}

	@Override
	public ArrayList<Condominio> list() {
		return null;
	}

	@Override
	public boolean delete(Condominio item) {
		return false;
	}

}
