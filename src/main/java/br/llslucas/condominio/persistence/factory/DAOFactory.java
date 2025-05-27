package br.llslucas.condominio.persistence.factory;

import br.llslucas.condominio.persistence.dao.MoradorDAO;
import br.llslucas.condominio.persistence.dao.ResidenciaDAO;

public interface DAOFactory {

	public abstract MoradorDAO createMoradorDAO();

	public abstract ResidenciaDAO createResidenciaDAO();

}
