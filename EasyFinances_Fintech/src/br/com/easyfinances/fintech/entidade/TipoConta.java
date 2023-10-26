package br.com.easyfinances.fintech.entidade;

public enum TipoConta {
	CORRENTE(1, "Corrente"), 
	POUPANCA(2, "Poupança"),
	INVESTIMENTO(3, "Investimento"),
	PJ(4, "PJ");
		
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private TipoConta(int id, String descricao) {
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
	
	public static TipoConta getTipoConta(int id) {
		TipoConta result = null;
		for(TipoConta tipoConta : values()) {
			if (tipoConta.id == id) {
				result = tipoConta;
				break;
			}
		}
		return result;
		
	}

}
