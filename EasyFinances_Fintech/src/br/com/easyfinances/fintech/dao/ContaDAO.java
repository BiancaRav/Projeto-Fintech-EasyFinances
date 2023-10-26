package br.com.easyfinances.fintech.dao;

import java.util.List;

import br.com.easyfinances.fintech.entidade.Conta;

public interface ContaDAO {
	
void cadastrar (Conta conta);
	
	List<Conta>buscarTodas();
	
	Conta buscarPorCodigo (int codigoConta);
	
	void alterar (Conta conta);
	
	void deletar (int codigoConta);

}
