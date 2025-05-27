package br.llslucas.condominio.controller;

import java.util.ArrayList;

import br.llslucas.condominio.model.Morador;

public class MoradorController implements Controller<Morador> {

	@Override
	public boolean create() {
		return false;
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public Morador get() {
		return null;
	}

	@Override
	public ArrayList<Morador> list() {
		return null;
	}

	@Override
	public boolean delete(Morador item) {
		return false;
	}
}
