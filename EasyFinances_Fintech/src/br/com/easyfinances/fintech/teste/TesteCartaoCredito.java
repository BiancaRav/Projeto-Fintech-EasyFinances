package br.com.easyfinances.fintech.teste;

import java.util.List;

import br.com.easyfinances.fintech.entidade.CartaoCredito;
import br.com.easyfinances.fintech.dao.CartaoCreditoDAO;
import br.com.easyfinances.fintech.dao.CartaoCreditoDAOImpl;
import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.dao.UsuarioDAO;
import br.com.easyfinances.fintech.dao.UsuarioDAOImpl;


public class TesteCartaoCredito {

	public static void main(String[] args) {
		
// CADASTRO DE CARTÃO DE CRÉDITO
		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(1);
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setUsuario(usuario);
		cartaoCredito.setNome("Nubank");
		cartaoCredito.setValorLimite(1000.00);
			
		cartaoCreditoDAO.cadastrar(cartaoCredito);
		
		System.out.println("Cartão Cadastrado!");*/



		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(71);
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setUsuario(usuario);
		cartaoCredito.setNome("Bradesco");
		cartaoCredito.setValorLimite(500.00);
			
		cartaoCreditoDAO.cadastrar(cartaoCredito);
		
		System.out.println("Cartão Cadastrado!");*/



		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(72);
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setUsuario(usuario);
		cartaoCredito.setNome("C6");
		cartaoCredito.setValorLimite(700.00);
			
		cartaoCreditoDAO.cadastrar(cartaoCredito);
		
		System.out.println("Cartão Cadastrado!");*/



		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(71);
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setUsuario(usuario);
		cartaoCredito.setNome("Itau");
		cartaoCredito.setValorLimite(500.00);
			
		cartaoCreditoDAO.cadastrar(cartaoCredito);
		
		System.out.println("Cartão Cadastrado!");*/
		

		
		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(10);
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setUsuario(usuario);
		cartaoCredito.setNome("Inter");
		cartaoCredito.setValorLimite(1200.00);
			
		cartaoCreditoDAO.cadastrar(cartaoCredito);
		
		System.out.println("Cartão Cadastrado!");*/

		

		
// BUSCA DE CARTÃO POR CODIGO E ALTERAÇÃO EM INFORMAÇÕES
		/*CartaoCreditoDAO cartaoCreditoDAO = new CartaoCreditoDAOImpl();
						
		System.out.println("Cartão Selecionado: ");
		CartaoCredito cartaoCredito = cartaoCreditoDAO.buscarPorCodigo(50);
		
		cartaoCredito.setValorLimite(1500.00);
		
		cartaoCreditoDAO.alterar(cartaoCredito);
		
		System.out.println("Alteração realizada");*/
		
		
		
// BUSCA DE TODOS OS CARTÕES 		
		/*CartaoCreditoDAO dao = new CartaoCreditoDAOImpl();
		
		List<CartaoCredito> cartoes = dao.buscarTodos();*/
		
		
		
// EXCLUSÃO DE CARTÃO CREDITO				
		/*CartaoCreditoDAO dao = new CartaoCreditoDAOImpl();
		
		System.out.println("Cartão Selecionado: ");
		CartaoCredito cartaoCredito = dao.buscarPorCodigo(50);
		
		dao.deletar(50);
		
		System.out.println("Cartão excluido!");*/
	}
}
