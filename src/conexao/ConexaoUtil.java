package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

	private static Connection connection;

	static {

		String endereco = "jdbc:mysql://localhost:3306/dbprojeto";
		String usuario = "root";
		String senha = "root";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(endereco, usuario, senha);

		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();

		}
	}

	public static Connection getCon() {
		return connection;

	}

}