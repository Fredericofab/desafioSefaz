package dao.implementacao;

import java.sql.Connection;
import java.util.List;

import dao.UsuarioDao;
import entidades.Usuario;

public class usuarioDaoJDBC implements UsuarioDao {

	public usuarioDaoJDBC(Connection conexao) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Usuario objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Usuario objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(Integer codUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario pesquisar(Integer codUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
