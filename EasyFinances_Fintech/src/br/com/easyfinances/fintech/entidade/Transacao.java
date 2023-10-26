package br.com.easyfinances.fintech.entidade;

import java.util.Date;

public class Transacao {
	
	private int codigo;
	private String descricao;
	private double valor;
	private Date data;
	private Usuario usuario;
	private Conta conta;
	private TipoTransacao tipoTransacao;
	private Categoria categoria;
	private TipoPagamento tipoPagamento;
	private StatusTransacao statusTransacao;
	private CartaoCredito cartaoCredito;
	
	public Transacao () {
	}
	
	
	public Transacao (
			int codigo, 
			String descricao, 
			double valor, 
			Date data, 
			Usuario usuario, 
			Conta conta, 
			TipoTransacao tipoTransacao, 
			Categoria categoria, 
			TipoPagamento tipoPagamento, 
			StatusTransacao statusTransacao, 
			CartaoCredito cartaoCredito
			) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.usuario = usuario;
		this.conta = conta;
		this.tipoTransacao = tipoTransacao;
		this.categoria = categoria;
		this.tipoPagamento = tipoPagamento;
		this.statusTransacao = statusTransacao;
		this.cartaoCredito = cartaoCredito;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}


	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	public StatusTransacao getStatusTransacao() {
		return statusTransacao;
	}


	public void setStatusTransacao(StatusTransacao statusTransacao) {
		this.statusTransacao = statusTransacao;
	}


	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}


	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

}
