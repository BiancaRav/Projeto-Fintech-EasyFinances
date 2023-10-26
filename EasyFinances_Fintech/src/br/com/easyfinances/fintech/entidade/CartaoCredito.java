package br.com.easyfinances.fintech.entidade;

public class CartaoCredito {

	private int codigo;
	private String nome;
	private double valorLimite;
	private Usuario usuario;
	
	public CartaoCredito () {
	}
	
	
	public CartaoCredito (
			int codigo, 
			String nome, 
			double valorLimite, 
			Usuario usuario
			) {
		this.codigo = codigo;
		this.nome = nome;
		this.valorLimite = valorLimite;
		this.usuario = usuario;
	}

	public CartaoCredito (int codigo) {
		this.codigo = codigo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getValorLimite() {
		return valorLimite;
	}


	public void setValorLimite(double valorLimite) {
		this.valorLimite = valorLimite;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
