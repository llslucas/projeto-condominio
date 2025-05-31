package br.llslucas.condominio.controller;

import java.util.Map;

import br.llslucas.condominio.model.Residencia;
import br.llslucas.condominio.persistence.DAOClient;

public class ResidenciaController implements Controller<Residencia> {
	private DAOClient dao;

	public ResidenciaController(DAOClient dao) {
		this.dao = dao;
	}

	@Override
	public Residencia getById(long id) throws Exception {
		try {
			return dao.createResidenciaDAO().getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Map<Long, Residencia> list() throws Exception {
		try {
			return dao.createResidenciaDAO().list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Map<Long, Residencia> listByCondominio(long condominioId) throws Exception {
		try {
			return dao.createResidenciaDAO().listByCondominio(condominioId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void create(Residencia residencia) throws Exception {
		try {
			dao.createResidenciaDAO().create(residencia);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(Residencia residencia) throws Exception {
		try {
			dao.createResidenciaDAO().save(residencia);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(Residencia residencia) throws Exception {
		try {
			dao.createResidenciaDAO().delete(residencia);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
