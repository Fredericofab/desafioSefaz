package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static Connection conexao = null;
	
	public static Connection getConexao() {
		if (conexao == null) {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:dbfred";
			String usuario = "JAVA";
			String senha = "JAVA";

			try {
				Class.forName(driver);
				conexao = DriverManager.getConnection(url, usuario, senha);
			}
			catch (ClassNotFoundException e) {
				throw new DbException("Erro ao carregar driver " + e.getMessage());
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
}
