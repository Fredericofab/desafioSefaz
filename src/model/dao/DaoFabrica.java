package model.dao;

import db.DB;
import model.dao.impl.CargoDaoJDBC;
import model.dao.impl.OrgaoDaoJDBC;
import model.dao.impl.SistemaDaoJDBC;
import model.dao.impl.usuarioDaoJDBC;

public class DaoFabrica {

	public static CargoDao criarCargoDao() {
		return new CargoDaoJDBC(DB.getConexao());
	}
	
	public static OrgaoDao criarOrgaoDao() {
		return new OrgaoDaoJDBC(DB.getConexao());
	}
	
	public static SistemaDao criarSistemaDao() {
		return new SistemaDaoJDBC(DB.getConexao());
	}
	
	public static UsuarioDao criarUsuarioDao() {
		return new usuarioDaoJDBC(DB.getConexao());
	}
}
