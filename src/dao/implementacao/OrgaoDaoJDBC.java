package dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrgaoDao;
import db.DB;
import db.DbException;
import entidades.Orgao;

public class OrgaoDaoJDBC implements OrgaoDao {

	private Connection conexao;
	
	public OrgaoDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Orgao objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("insert into ORGAO (CD_ORGAO, DE_ORGAO) values (?,?) ");
			st.setInt(1, objeto.getCodOrgao());
			st.setString(2, objeto.getDescOrgao());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Inserir Orgao " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void atualizar(Orgao objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("update ORGAO set DE_ORGAO = ? where CD_ORGAO = ? ");
			st.setInt(2, objeto.getCodOrgao());
			st.setString(1, objeto.getDescOrgao());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Atualizar Orgao " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deletar(Integer codOrgao) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("delete from  ORGAO where CD_ORGAO = ? ");
			st.setInt(1, codOrgao);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Deletar Orgao " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public Orgao pesquisar(Integer codOrgao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("select * from ORGAO where CD_ORGAO = ?");
			st.setInt(1, codOrgao);
			rs = st.executeQuery();
			if (rs.next()) {
				Orgao cargo = instanciarOrgao(rs);
				return cargo;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Pesquisar Orgao " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	@Override
	public List<Orgao> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Orgao> lista = new ArrayList<Orgao>();
		try {
			st = conexao.prepareStatement("select * from ORGAO ");
			rs = st.executeQuery();
			while (rs.next()) {
				Orgao cargo = instanciarOrgao(rs);
				lista.add(cargo);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Listar os Orgao " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	private Orgao instanciarOrgao(ResultSet rs) throws SQLException {
		Orgao cargo = new Orgao();
		cargo.setCodOrgao(rs.getInt("CD_ORGAO"));
		cargo.setDescOrgao(rs.getString("DE_ORGAO"));
		return cargo;
	}

}
