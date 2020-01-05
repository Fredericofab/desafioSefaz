package aplicacao;

import java.util.ArrayList;
import java.util.List;

import dao.FabricaDeDao;
import dao.SistemaDao;
import entidades.Sistema;

public class TesteSistema {

	public static void testarSistema() {

		Integer codSistema;
		Sistema sistema;
		List<Sistema> lista = new ArrayList<Sistema>();
		SistemaDao sistemaDao = FabricaDeDao.criarSistemaDao();

		System.out.println("colocar um Breakpoint Aqui");
		
		System.out.println("teste inserir Sistema");
		sistema = new Sistema(109,"teste Sistema");
		sistemaDao.inserir(sistema);
		
		System.out.println("teste atualizar Sistema");
		sistema = new Sistema(109,"novo nome");
		sistemaDao.atualizar(sistema);
		
		System.out.println("teste deletar Sistema");
		codSistema = 109;
		sistemaDao.deletar(codSistema);
		
		System.out.println("teste pesquisar Sistema");
		codSistema = 101;
		sistema = sistemaDao.pesquisar(codSistema);
		System.out.println(sistema);
		
		System.out.println("teste listar os Sistema");
		lista = sistemaDao.listarTodos();
		for (Sistema x : lista) {
			System.out.println(x);
		}
	}


}
