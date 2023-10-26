package br.com.easyfinances.fintech.entidade;

public enum TipoPagamento {

	DEBITO(1, "Débito"), 
	CREDITO(2, "Crédito"),
	TRANSFERENCIA(3, "Transferência"),
	PIX(4, "Pix"),
	BOLETO(5, "Boleto"),
	DINHEIRO(6, "Dinheiro");
		
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private TipoPagamento(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	// Métodos da Classe	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPagamento getTipoPagamento(int id) {
		TipoPagamento result = null;
		for(TipoPagamento tipoPagamento : values()) {
			if (tipoPagamento.id == id) {
				result = tipoPagamento;
				break;
			}
		}
		return result;
		
	}
}
