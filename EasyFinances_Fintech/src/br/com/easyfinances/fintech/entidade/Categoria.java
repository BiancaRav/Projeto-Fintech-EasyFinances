package br.com.easyfinances.fintech.entidade;

public enum Categoria {

	CONTASFIXAS(1, "Contas Fixas"), 
	TRANSPORTE(2, "Transporte"),
	ALIMENTACAO(3, "Alimentação"),
	SAUDE(4, "Saúde"),
	LAZER(5, "Lazer"),
	DESPESASPESSOAIS(6, "Despesas Pessoais"),
	RECEBIVEIS(7, "Recebiveis"),
	INVESTIMENTOS(8, "Investimentos"),
	EDUCACAO(9, "Educação"),
	IMPOSTOS(10, "Impostos"),
	CARTAOCREDITO(11, "Cartao de Crédito"),
	OUTROS(12, "Outros");
		
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private Categoria(int id, String descricao) {
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
	
	public static Categoria getCategoria(int id) {
		Categoria result = null;
		for(Categoria categoria : values()) {
			if (categoria.id == id) {
				result = categoria;
				break;
			}
		}
		return result;
		
	}
}
