package br.com.easyfinances.fintech.entidade;


public class Usuario {
	
	private int codigo;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario () {
	}
	
	
	public Usuario (
			int codigo, 
			String nome, 
			String email, 
			String senha
			) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario (int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo () {
		return codigo;
	}
		
	public void setCodigoUsuario (int codigo) {
		this.codigo = codigo;
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	}
	
	
