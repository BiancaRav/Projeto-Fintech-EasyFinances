package br.com.easyfinances.fintech.dao;

import java.util.List;

import br.com.easyfinances.fintech.entidade.CartaoCredito;

public interface CartaoCreditoDAO {

void cadastrar (CartaoCredito cartaoCredito);
	
	List<CartaoCredito>buscarTodos();
	
	CartaoCredito buscarPorCodigo (int codigo);
	
	void alterar (CartaoCredito cartaoCredito);
	
	void deletar (int codigo);
}
