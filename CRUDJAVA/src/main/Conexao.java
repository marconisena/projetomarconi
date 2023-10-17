package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {

	private static final String USERNAME = "marconi";

	private static final String PASSWORD = "root";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";

	public static Connection createConnectionToMySQL() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

	public static void main(String[] args) throws Exception {

		Connection con = createConnectionToMySQL();

		if (con != null) {

			System.out.println("Conexão obtida com sucesso" + con);

		}

	}

	public static PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
