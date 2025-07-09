package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

	private static String banco = "jdbc:postgresql://localhost:5432/projeto-jsp";
	private static String user = "postgres";
	private static String senha = "220822";
	private static Connection connection = null;

	static {
		conectar();
	}

	public SingleConnectionBanco() {
		conectar();
	}

	public static void conectar() {

		try {

			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);
				System.out.println("Banco conectado com sucesso!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
