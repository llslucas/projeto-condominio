package br.llslucas.condominio.controller;

import java.util.ArrayList;

import br.llslucas.condominio.model.Fatura;

public class FaturaController implements Controller<Fatura> {
	@Override
	public boolean create() {
		return false;
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public Fatura get() {
		return null;
	}

	@Override
	public ArrayList<Fatura> list() {
		return null;
	}

	@Override
	public boolean delete(Fatura item) {
		return false;
	}
}
