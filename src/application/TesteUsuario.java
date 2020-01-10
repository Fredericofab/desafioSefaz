package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFabrica;
import model.dao.UsuarioDao;
import model.entities.Cargo;
import model.entities.Orgao;
import model.entities.Usuario;

public class TesteUsuario {

	public static void testarUsuario() {
		Long cpf;
		Usuario usuario;
		Cargo cargo;
		Orgao orgao;
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDao usuarioDao = DaoFabrica.criarUsuarioDao();

		System.out.println("colocar um Breakpoint Aqui");
		
		System.out.println("teste inserir Usuario");
		cargo = new Cargo(1,null);
		orgao = new Orgao(11,null);
		usuario = new Usuario(12345678922L,"teste Usuario",1234,"usuario@email.com",cargo,orgao);
		usuarioDao.inserir(usuario);

		System.out.println("teste atualizar Usuario");
		usuario = new Usuario(12345678922L,"novo nome",1234,"usuario@email.com",cargo,orgao);
		usuarioDao.atualizar(usuario);
		
		System.out.println("teste deletar Usuario");
		cpf = 12345678922L;
		usuarioDao.deletar(cpf);
		
		System.out.println("teste pesquisar Usuario");
		cpf =  44087411400L;
		usuario = usuarioDao.pesquisar(cpf);
		System.out.println(usuario);
		
		System.out.println("teste listar os Usuario");
		lista = usuarioDao.listarTodos();
		for (Usuario x : lista) {
			System.out.println(x);
		}
	}
}
