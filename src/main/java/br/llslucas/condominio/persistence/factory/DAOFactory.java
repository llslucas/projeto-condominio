package br.llslucas.condominio.persistence.factory;

import br.llslucas.condominio.persistence.dao.CondominioDAO;
import br.llslucas.condominio.persistence.dao.FaturaDAO;
import br.llslucas.condominio.persistence.dao.MoradorDAO;
import br.llslucas.condominio.persistence.dao.ResidenciaDAO;

public interface DAOFactory {
	public MoradorDAO createMoradorDAO() throws Exception;
	public ResidenciaDAO createResidenciaDAO() throws Exception;
	public CondominioDAO createCondominioDAO() throws Exception;
	public FaturaDAO createFaturaDAO() throws Exception;
}
