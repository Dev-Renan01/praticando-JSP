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
	
	
	public void gravarusuario(ModelLogin modelLogin) throws Exception {
		
		String sql = "insert into model_login( login, senha, nome, email) values (?, ?, ?, ?);";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		statement.setString(3, modelLogin.getNome());
		statement.setString(4, modelLogin.getEmail());
		
		statement.execute();
		connection.commit();


		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		String sql = "";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getEmail());
		
		 ResultSet resultado = statement.executeQuery();
		   
		 if(resultado.next()) {
			 return true;
		 }
		 
		 return false;
	}

}
