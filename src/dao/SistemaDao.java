package dao;

import java.util.List;

import entidades.Sistema;

public interface SistemaDao {

	void inserir(Sistema objeto);
	void atualizar(Sistema objeto);
	void deletar(Integer codSistema);
	Sistema pesquisar(Integer codSistema);
	List<Sistema> listarTodos();

}
