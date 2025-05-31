package br.llslucas.condominio.controller;

import java.util.Map;

import br.llslucas.condominio.model.Condominio;
import br.llslucas.condominio.persistence.DAOClient;

public class CondominioController implements Controller<Condominio> {
	private DAOClient dao;

	public CondominioController(DAOClient dao) {
		this.dao = dao;
	}

	@Override
	public Condominio getById(long id) throws Exception {
		try {
			return dao.createCondominioDAO().getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Map<Long, Condominio> list() throws Exception {
		try {
			return dao.createCondominioDAO().list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void create(Condominio condominio) throws Exception {
		try {
			dao.createCondominioDAO().create(condominio);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(Condominio condominio) throws Exception {
		try {
			dao.createCondominioDAO().save(condominio);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(Condominio condominio) throws Exception {
		try {
			dao.createCondominioDAO().delete(condominio);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
