package dao;

import dao.implementacao.CargoDaoJDBC;
import dao.implementacao.OrgaoDaoJDBC;
import dao.implementacao.SistemaDaoJDBC;
import dao.implementacao.usuarioDaoJDBC;
import db.DB;

public class FabricaDeDao {

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
