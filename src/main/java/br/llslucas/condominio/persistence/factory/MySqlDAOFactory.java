package br.llslucas.condominio.persistence.factory;

import java.sql.SQLException;

import br.llslucas.condominio.persistence.dao.CondominioDAO;
import br.llslucas.condominio.persistence.dao.FaturaDAO;
import br.llslucas.condominio.persistence.dao.MoradorDAO;
import br.llslucas.condominio.persistence.dao.ResidenciaDAO;
import br.llslucas.condominio.persistence.dao.mysqldao.MySqlCondominioDAO;
import br.llslucas.condominio.persistence.dao.mysqldao.MySqlFaturaDAO;
import br.llslucas.condominio.persistence.dao.mysqldao.MySqlMoradorDAO;
import br.llslucas.condominio.persistence.dao.mysqldao.MySqlResidenciaDAO;
import br.llslucas.condominio.persistence.instance.MySQLInstance;

public class MySqlDAOFactory implements DAOFactory {

	@Override
	public MoradorDAO createMoradorDAO() throws SQLException {
		MySQLInstance instance = MySQLInstance.getInstance();
		return new MySqlMoradorDAO(instance.getConnection());
	}

	@Override
	public ResidenciaDAO createResidenciaDAO() throws SQLException {
		MySQLInstance instance = MySQLInstance.getInstance();
		return new MySqlResidenciaDAO(instance.getConnection());
	}

	@Override
	public CondominioDAO createCondominioDAO() throws SQLException {
		MySQLInstance instance = MySQLInstance.getInstance();
		return new MySqlCondominioDAO(instance.getConnection());
	}

	@Override
	public FaturaDAO createFaturaDAO() throws SQLException {
		MySQLInstance instance = MySQLInstance.getInstance();
		return new MySqlFaturaDAO(instance.getConnection());
	}
}
