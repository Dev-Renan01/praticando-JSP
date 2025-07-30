package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarusuario(ModelLogin modelLogin) throws Exception {

		if (modelLogin.isNovo()) { /* Grava um novo usuário */

			String sql = "insert into model_login( login, senha, nome, email) values (?, ?, ?, ?);";

			PreparedStatement statementGravar = connection.prepareStatement(sql);
			statementGravar.setString(1, modelLogin.getLogin());
			statementGravar.setString(2, modelLogin.getSenha());
			statementGravar.setString(3, modelLogin.getNome());
			statementGravar.setString(4, modelLogin.getEmail());

			statementGravar.execute();
			connection.commit();

		} else {
			String sql = "update model_login set login=?, senha=?, nome=?, email=? where id = " + modelLogin.getId()
					+ ";";

			PreparedStatement statementAtualizar = connection.prepareStatement(sql);
			statementAtualizar.setString(1, modelLogin.getLogin());
			statementAtualizar.setString(2, modelLogin.getSenha());
			statementAtualizar.setString(3, modelLogin.getNome());
			statementAtualizar.setString(4, modelLogin.getEmail());

			statementAtualizar.executeUpdate();
			connection.commit();

		}

		return this.consultaUsuario(modelLogin.getLogin());

	}

	public ModelLogin consultaUsuario(String login) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "select * from model_login where upper (login) = upper ('" + login + "')";

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

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1) > 0 as existe from model_login where upper(login) = upper('" + login + "')";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		resultado.next();/* entrar nos resultados */
		return resultado.getBoolean("existe");

	}

	public void deletarUser(String idUser) throws Exception {

		String sql = "delete from model_login where id = ?;";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, Long.parseLong(idUser) );

		statement.execute();
		connection.commit();

	}

}
