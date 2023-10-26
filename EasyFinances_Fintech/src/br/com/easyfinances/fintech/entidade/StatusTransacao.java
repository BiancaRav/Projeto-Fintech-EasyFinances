package br.com.easyfinances.fintech.entidade;

public enum StatusTransacao {
	
	QUITADA(1, "Quitada"), 
	PENDENTE(2, "Pendente"),
	ATRASADA(3, "Atrasada");
		
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private StatusTransacao(int id, String descricao) {
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
	
	public static StatusTransacao getStatusTransacao(int id) {
		StatusTransacao result = null;
		for(StatusTransacao statusTransacao : values()) {
			if (statusTransacao.id == id) {
				result = statusTransacao;
				break;
			}
		}
		return result;
		
	}
}
