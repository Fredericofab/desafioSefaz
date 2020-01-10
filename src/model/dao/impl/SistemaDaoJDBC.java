package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SistemaDao;
import model.entities.Sistema;

public class SistemaDaoJDBC implements SistemaDao {

	private Connection conexao;
	
	public SistemaDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Sistema objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("insert into SISTEMA (CD_SISTEMA, DE_SISTEMA) values (?,?) ");
			st.setInt(1, objeto.getCodSistema());
			st.setString(2, objeto.getDescSistema());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Inserir Sistema " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}
	

	@Override
	public void atualizar(Sistema objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("update SISTEMA set DE_SISTEMA = ? where CD_SISTEMA = ? ");
			st.setInt(2, objeto.getCodSistema());
			st.setString(1, objeto.getDescSistema());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Atualizar Sistema " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deletar(Integer codSistema) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("delete from  SISTEMA where CD_SISTEMA = ? ");
			st.setInt(1, codSistema);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Deletar Sistema " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public Sistema pesquisar(Integer codSistema) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("select * from SISTEMA where CD_SISTEMA = ?");
			st.setInt(1, codSistema);
			rs = st.executeQuery();
			if (rs.next()) {
				Sistema cargo = instanciarSistema(rs);
				return cargo;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Pesquisar Sistema " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}


	@Override
	public List<Sistema> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Sistema> lista = new ArrayList<Sistema>();
		try {
			st = conexao.prepareStatement("select * from SISTEMA order by CD_SISTEMA ");
			rs = st.executeQuery();
			while (rs.next()) {
				Sistema cargo = instanciarSistema(rs);
				lista.add(cargo);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Listar os Sistema " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}
	
	private Sistema instanciarSistema(ResultSet rs) throws SQLException {
		Sistema cargo = new Sistema();
		cargo.setCodSistema(rs.getInt("CD_SISTEMA"));
		cargo.setDescSistema(rs.getString("DE_SISTEMA"));
		return cargo;
	}

}
