package model;

import java.io.Serializable;

public class ModelLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	
	public boolean isNovo() {
		if(id == null) {
			return true;
		}else if(id != null && id > 0 ) {
			return false;
		}
		return id == null;
	}
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
