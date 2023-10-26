package br.com.easyfinances.fintech.entidade;

public enum TipoTransacao {
	RECEITA(1, "Receita"), 
	DESPESA(2, "Despesa"),
	INVESTIMENTO(3, "Investimento");
			
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private TipoTransacao(int id, String descricao) {
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
	
	public static TipoTransacao getTipoTransacao(int id) {
		TipoTransacao result = null;
		for(TipoTransacao tipoTransacao : values()) {
			if (tipoTransacao.id == id) {
				result = tipoTransacao;
				break;
			}
		}
		return result;
		
	}

}
