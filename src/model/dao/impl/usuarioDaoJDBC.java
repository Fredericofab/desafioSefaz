package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Cargo;
import model.entities.Orgao;
import model.entities.Usuario;

public class usuarioDaoJDBC implements UsuarioDao {

	private Connection conexao;

	public usuarioDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Usuario objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("insert into USUARIO "
										+ "(CPF, NOME, RAMAL, EMAIL, CD_CARGO, CD_ORGAO) "
										+ "values (?,?,?,?,?,?)");
			st.setLong(1, objeto.getCpf());
			st.setString(2, objeto.getNome());
			st.setInt(3, objeto.getRamal());
			st.setString(4, objeto.getEmail());
			st.setInt(5, objeto.getCargo().getCodCargo());
			st.setInt(6, objeto.getOrgao().getCodOrgao());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Erro ao Inserir Usuario " + e.getMessage());
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void atualizar(Usuario objeto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("update USUARIO "
										+ "set NOME = ?, RAMAL = ?, EMAIL = ?, "
										+ "CD_CARGO = ?, CD_ORGAO = ? "
										+ "where CPF = ? ");
			st.setString(1, objeto.getNome());
			st.setInt(2, objeto.getRamal());
			st.setString(3, objeto.getEmail());
			st.setInt(4, objeto.getCargo().getCodCargo());
			st.setInt(5, objeto.getOrgao().getCodOrgao());
			st.setLong(6, objeto.getCpf());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Atualizar Usuario " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public void deletar(Long codUsuario) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("delete from  USUARIO where CPF = ? ");
			st.setLong(1, codUsuario);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Deletar Usuario " + e.getMessage());		
		}
		finally {
			DB.fecharStatement(st);
		}
	}

	@Override
	public Usuario pesquisar(Long codUsuario) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("select U.*, C.DE_CARGO, O.DE_ORGAO "
										+ "from USUARIO U, CARGO C, ORGAO O "
										+ "where U.CD_CARGO = C.CD_CARGO "
										+ "and   U.CD_ORGAO = O.CD_ORGAO "
										+ "and   CPF = ?");
			st.setLong(1, codUsuario);
			rs = st.executeQuery();
			if (rs.next()) {
				Cargo cargo = instanciarCargo(rs);
				Orgao orgao = instanciarOrgao(rs);
				Usuario usuario = instanciarUsuario(rs, cargo, orgao);
				return usuario;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Pesquisar usuario " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	@Override
	public List<Usuario> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Usuario> lista = new ArrayList<Usuario>();
		Map<Integer, Cargo> mapCargo = new HashMap<>();
		Map<Integer, Orgao> mapOrgao = new HashMap<>();
		try {
			st = conexao.prepareStatement("select U.*, C.DE_CARGO, O.DE_ORGAO "
										+ "from USUARIO U, CARGO C, ORGAO O "
										+ "where U.CD_CARGO = C.CD_CARGO "
										+ "and   U.CD_ORGAO = O.CD_ORGAO "
										+ "order by CPF ");
			rs = st.executeQuery();
			
			while (rs.next()) {
				Cargo cargo = mapCargo.get(rs.getInt("CD_CARGO"));
				if (cargo == null) {
					cargo = instanciarCargo(rs);
					mapCargo.put(rs.getInt("CD_CARGO"), cargo);
				}
				
				Orgao orgao = mapOrgao.get(rs.getInt("CD_ORGAO"));
				if (orgao == null) {
					orgao = instanciarOrgao(rs);
					mapOrgao.put(rs.getInt("CD_ORGAO"), orgao);
				}

				Usuario usuario = instanciarUsuario(rs, cargo, orgao);
				lista.add(usuario);
			}
			return lista;
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Erro ao Listar os usuarios " + e.getMessage());		
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	private Usuario instanciarUsuario(ResultSet rs, Cargo cargo, Orgao orgao) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setCpf(rs.getLong("CPF"));
		usuario.setNome(rs.getString("NOME"));
		usuario.setRamal(rs.getInt("RAMAL"));
		usuario.setEmail(rs.getString("EMAIL"));
		usuario.setCargo(cargo);
		usuario.setOrgao(orgao);
		return usuario;
	}
	
	private Cargo instanciarCargo(ResultSet rs) throws SQLException {
		Cargo cargo = new Cargo();
		cargo.setCodCargo(rs.getInt("CD_CARGO"));
		cargo.setDescCargo(rs.getString("DE_CARGO"));
		return cargo;
	}

	private Orgao instanciarOrgao(ResultSet rs) throws SQLException {
		Orgao orgao = new Orgao();
		orgao.setCodOrgao(rs.getInt("CD_ORGAO"));
		orgao.setDescOrgao(rs.getString("DE_ORGAO"));
		return orgao;
	}
}
