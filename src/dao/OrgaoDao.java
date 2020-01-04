package dao;

import java.util.List;
import entidades.Orgao;

public interface OrgaoDao {

	void inserir(Orgao objeto);
	void atualizar(Orgao objeto);
	void deletar(Integer codOrgao);
	Orgao pesquisar(Integer codOrgao);
	List<Orgao> listarTodos();
}
