package aplicacao;

import java.util.ArrayList;
import java.util.List;

import dao.OrgaoDao;
import dao.FabricaDeDao;
import entidades.Orgao;

public class TesteOrgao {

	public static void testarOrgao() {

		Integer codOrgao;
		Orgao orgao;
		List<Orgao> lista = new ArrayList<Orgao>();
		OrgaoDao orgaoDao = FabricaDeDao.criarOrgaoDao();

		System.out.println("colocar um Breakpoint Aqui");
		
		System.out.println("teste inserir Orgao");
		orgao = new Orgao(19,"teste Orgao");
		orgaoDao.inserir(orgao);
		
		System.out.println("teste atualizar Orgao");
		orgao = new Orgao(19,"novo nome");
		orgaoDao.atualizar(orgao);
		
		System.out.println("teste deletar Orgao");
		codOrgao = 19;
		orgaoDao.deletar(codOrgao);
		
		System.out.println("teste pesquisar Orgao");
		codOrgao = 11;
		orgao = orgaoDao.pesquisar(codOrgao);
		System.out.println(orgao);
		
		System.out.println("teste listar os Orgao");
		lista = orgaoDao.listarTodos();
		for (Orgao x : lista) {
			System.out.println(x);
		}
	}

}
