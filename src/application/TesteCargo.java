package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.CargoDao;
import model.dao.DaoFabrica;
import model.entities.Cargo;

public class TesteCargo {

	public static void testarCargo() {

		Integer codCargo;
		Cargo cargo;
		List<Cargo> lista = new ArrayList<Cargo>();
		CargoDao cargoDao = DaoFabrica.criarCargoDao();

		System.out.println("colocar um Breakpoint Aqui");
		
		System.out.println("teste inserir Cargo");
		cargo = new Cargo(9,"teste Cargo");
		cargoDao.inserir(cargo);
		
		System.out.println("teste atualizar Cargo");
		cargo = new Cargo(9,"novo nome");
		cargoDao.atualizar(cargo);
		
		System.out.println("teste deletar Cargo");
		codCargo = 9;
		cargoDao.deletar(codCargo);
		
		System.out.println("teste pesquisar Cargo");
		codCargo = 1;
		cargo = cargoDao.pesquisar(codCargo);
		System.out.println(cargo);
		
		System.out.println("teste listar os Cargo");
		lista = cargoDao.listarTodos();
		for (Cargo x : lista) {
			System.out.println(x);
		}
	}
}
