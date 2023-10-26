package br.com.easyfinances.fintech.entidade;

public class Conta {
	
	private int codigoConta;
	private String nome;
	private Usuario usuario;
	private TipoConta tipoConta;
	
	public Conta() {
	}
		
	public Conta(
			int codigoConta, 
			String nome, 
			Usuario usuario, 
			TipoConta tipoConta
			) {
		this.codigoConta = codigoConta;
		this.nome = nome;
		this.usuario = usuario;
		this.tipoConta = tipoConta;
	}
	
	public Conta (int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public int getCodigoConta() {
		return codigoConta;
	}


	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public TipoConta getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}
	
	
