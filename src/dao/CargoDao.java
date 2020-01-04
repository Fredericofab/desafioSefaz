package dao;

import java.util.List;
import entidades.Cargo;

public interface CargoDao {

	void inserir(Cargo objeto);
	void atualizar(Cargo objeto);
	void deletar(Integer codCargo);
	Cargo pesquisar(Integer codCargo);
	List<Cargo> listarTodos();
}
