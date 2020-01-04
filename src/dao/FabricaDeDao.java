package dao;

import dao.implementacao.CargoDaoJDBC;
import db.DB;

public class FabricaDeDao {

	public static CargoDao criarCargoDao() {
		return new CargoDaoJDBC(DB.getConexao());
	}
}
