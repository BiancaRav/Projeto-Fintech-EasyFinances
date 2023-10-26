package br.com.easyfinances.fintech.dao;

import java.util.List;

import br.com.easyfinances.fintech.entidade.Usuario;

public interface UsuarioDAO {
	
	void cadastrar (Usuario usuario);
	
	List<Usuario>buscarTodos();
	
	Usuario buscarPorCodigo (int codigo);
	
	void alterar (Usuario usuario);
	
	void deletar (int codigo);

}
