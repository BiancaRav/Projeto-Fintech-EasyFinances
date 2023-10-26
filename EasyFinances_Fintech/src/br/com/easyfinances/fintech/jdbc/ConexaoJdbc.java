package br.com.easyfinances.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJdbc {

	public static Connection obterConexao () {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao  = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm99164", "141192");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
		
	}
}
