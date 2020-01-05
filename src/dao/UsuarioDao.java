package dao;

import java.util.List;

import entidades.Usuario;

public interface UsuarioDao {

	void inserir(Usuario objeto);
	void atualizar(Usuario objeto);
	void deletar(Long cpf);
	Usuario pesquisar(Long cpf);
	List<Usuario> listarTodos();

}
