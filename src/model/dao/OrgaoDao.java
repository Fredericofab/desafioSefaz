package model.dao;

import java.util.List;

import model.entities.Orgao;

public interface OrgaoDao {

	void inserir(Orgao objeto);
	void atualizar(Orgao objeto);
	void deletar(Integer codOrgao);
	Orgao pesquisar(Integer codOrgao);
	List<Orgao> listarTodos();
}
