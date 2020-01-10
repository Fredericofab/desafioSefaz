package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	public static Connection conexao = null;
	
	public static Connection getConexao() {
		if (conexao == null) {
			try {
				Properties propriedades = lerPropriedades();
				String url = propriedades.getProperty("url");
				String usuario = propriedades.getProperty("usuario");
				String senha = propriedades.getProperty("senha");
				
				conexao = DriverManager.getConnection(url, usuario, senha);
			}
			catch (SQLException e) {
				throw new DbException("Erro ao se conectar " + e.getMessage());
			}
		}
		return conexao;
	}
	
	
	
	public void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
			}
			catch (SQLException e) {
				throw new DbException("Erro ao Fechar Conexao " + e.getMessage());
			}
		}
	}

	public static void fecharStatement(Statement st){
		try {
			st.close();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Fechar Statement " + e.getMessage());
		}
	}
	
	public static void fecharResultSet(ResultSet rs){
		try {
			rs.close();
		}
		catch (SQLException e) {
			throw new DbException("Erro ao Fechar ResultSet " + e.getMessage());
		}
	}
	
	private static Properties lerPropriedades() {
		
		try (FileInputStream fs = new FileInputStream("db.propriedades")){
			Properties propriedades = new Properties();
			propriedades.load(fs);
			return propriedades;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
