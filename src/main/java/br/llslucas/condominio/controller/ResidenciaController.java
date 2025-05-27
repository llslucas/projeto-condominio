package br.llslucas.condominio.controller;

import java.util.ArrayList;

import br.llslucas.condominio.model.Residencia;

public class ResidenciaController implements Controller<Residencia> {

	@Override
	public boolean create() {
		return false;
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public Residencia get() {
		return null;
	}

	@Override
	public ArrayList<Residencia> list() {
		return null;
	}

	@Override
	public boolean delete(Residencia item) {
		return false;
	}

}
