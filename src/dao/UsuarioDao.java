package dao;

import java.util.List;

import entidades.Usuario;

public interface UsuarioDao {

	void inserir(Usuario objeto);
	void atualizar(Usuario objeto);
	void deletar(Integer codUsuario);
	Usuario pesquisar(Integer codUsuario);
	List<Usuario> listarTodos();

}
