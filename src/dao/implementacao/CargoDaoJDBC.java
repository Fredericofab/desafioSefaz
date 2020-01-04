package dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CargoDao;
import db.DB;
import db.DbException;
import entidades.Cargo;

public class CargoDaoJDBC implements CargoDao {

	private Connection conexao;
	
	public CargoDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Cargo objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("insert into CARGO (CD_CARGO, DE_CARGO) values (?,?) ");
			st.setInt(1, objeto.getCodCargo());
			st.setString(2, objeto.getDescCargo());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Inserir Cargo " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}
	

	@Override
	public void atualizar(Cargo objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("update CARGO set DE_CARGO = ? where CD_CARGO = ? ");
			st.setInt(2, objeto.getCodCargo());
			st.setString(1, objeto.getDescCargo());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Atualizar Cargo " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deletar(Integer codCargo) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("delete from  CARGO where CD_CARGO = ? ");
			st.setInt(1, codCargo);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Deletar Cargo " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public Cargo pesquisar(Integer codCargo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("select * from CARGO where CD_CARGO = ?");
			st.setInt(1, codCargo);
			rs = st.executeQuery();
			if (rs.next()) {
				Cargo cargo = instanciarCargo(rs);
				return cargo;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Pesquisar Cargo " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}


	@Override
	public List<Cargo> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Cargo> lista = new ArrayList<Cargo>();
		try {
			st = conexao.prepareStatement("select * from CARGO ");
			rs = st.executeQuery();
			while (rs.next()) {
				Cargo cargo = instanciarCargo(rs);
				lista.add(cargo);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Listar os Cargo " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}
	
	private Cargo instanciarCargo(ResultSet rs) throws SQLException {
		Cargo cargo = new Cargo();
		cargo.setCodCargo(rs.getInt("CD_CARGO"));
		cargo.setDescCargo(rs.getString("DE_CARGO"));
		return cargo;
	}

}
