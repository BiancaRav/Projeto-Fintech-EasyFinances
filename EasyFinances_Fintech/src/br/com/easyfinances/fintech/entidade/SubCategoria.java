package br.com.easyfinances.fintech.entidade;

public enum SubCategoria {
	CONTASCONSUMO(1, "Contas Consumo"), 
	ALUGUELCONDOMINIO(2, "Aluguel/Condominío"),
	SEGURO(3, "Seguro Residencial"),
	COMBUSTIVEL(4, "Combustível"),
	TRANSPORTE(5, "Transporte"),
	MANUTENCAOSERVICOS(6, "Manutenção/Serviços"),
	SEGUROAUTO(7, "Seguro Auto"),
	MERCADO(8, "Mercado"),
	RESTAURANTE(9, "Restaurante"),
	CONVENIO(10, "Convênio"),
	MEDICAMENTOS(11, "Medicamentos"),
	VIAGENS(12, "Viagens"),
	ENTRETENIMENTO(13, "Entretenimento"),
	VESTIMENTA(14, "Vestimenta"),
	CUIDADOSPESSOAIS (15, "Cuidados Pessoais"),
	ESCOLA(16, "Escola"), 
	CURSO(17, "Curso"),
	MATERIAL(18, "Material"),
	OUTROS(19, "Outros"); 
		
	// Atributos da Classe	
	private int id;
	private String descricao;

	// Construtor da Classe	
	private SubCategoria(int id, String descricao) {
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
	
	public static SubCategoria getSubCategoria(int id) {
		SubCategoria result = null;
		for(SubCategoria subCategoria : values()) {
			if (subCategoria.id == id) {
				result = subCategoria;
				break;
			}
		}
		return result;
		
	}
}
