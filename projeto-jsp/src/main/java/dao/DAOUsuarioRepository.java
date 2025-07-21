package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarusuario(ModelLogin modelLogin) throws Exception {

		String sql = "insert into model_login( login, senha, nome, email) values (?, ?, ?, ?);";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		statement.setString(3, modelLogin.getNome());
		statement.setString(4, modelLogin.getEmail());

		statement.execute();
		connection.commit();

		return this.consultaUsuario(modelLogin.getLogin());

	}

	public ModelLogin consultaUsuario(String login) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "select * from model_login where upper (login) = upper ('"+login+"')";

		PreparedStatement statement = connection.prepareStatement(sql);
		 
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {/* Se tem resultado */

			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));

		}
		return modelLogin;
	}

}
