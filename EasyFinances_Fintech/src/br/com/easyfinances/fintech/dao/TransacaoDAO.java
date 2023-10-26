package br.com.easyfinances.fintech.dao;

import java.util.List;

import br.com.easyfinances.fintech.entidade.Transacao;

public interface TransacaoDAO {

void cadastrar (Transacao transacao);
	
	List<Transacao>buscarTodas();
	
	Transacao buscarPorCodigo (int codigo);
	
	void alterar (Transacao transacao);
	
	void deletar (int codigo);
}
