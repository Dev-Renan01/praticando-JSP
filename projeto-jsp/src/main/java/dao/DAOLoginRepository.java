package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection connection;

	public DAOLoginRepository() {
		connection = SingleConnectionBanco.getConnection();

	}

	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {

		String sql = "select * from model_login where login = ? and senha = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());

		ResultSet resultado = statement.executeQuery(); // Objeto de resultado

		if (resultado.next()) {
			return true;
		}
		return false;

	}
}
