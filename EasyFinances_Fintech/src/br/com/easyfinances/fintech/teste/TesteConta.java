package br.com.easyfinances.fintech.teste;

import java.util.List;

import br.com.easyfinances.fintech.dao.ContaDAO;
import br.com.easyfinances.fintech.dao.ContaDAOImpl;
import br.com.easyfinances.fintech.dao.UsuarioDAO;
import br.com.easyfinances.fintech.entidade.Conta;
import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.dao.UsuarioDAOImpl;
import br.com.easyfinances.fintech.entidade.TipoConta;

public class TesteConta {

	public static void main(String[] args) {
		
// CADASTRO DE CONTA
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
				
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(10);
				
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Itau");
		conta.setTipoConta(TipoConta.CORRENTE);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/

		

		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(70);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Bradesco");
		conta.setTipoConta(TipoConta.POUPANCA);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/
		
		
		
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(71);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Nubank");
		conta.setTipoConta(TipoConta.INVESTIMENTO);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/



		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(70);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Bradesco");
		conta.setTipoConta(TipoConta.CORRENTE);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/
		
		
		
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(72);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Inter");
		conta.setTipoConta(TipoConta.CORRENTE);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/



		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(73);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Nubank");
		conta.setTipoConta(TipoConta.INVESTIMENTO);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/
		
		
		
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(73);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Nubank");
		conta.setTipoConta(TipoConta.CORRENTE);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/


		
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(73);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Inter");
		conta.setTipoConta(TipoConta.PJ);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/
		
		
	
		/*ContaDAO contaDAO = new ContaDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(71);
		
		Conta conta = new Conta();
		conta.setUsuario(usuario);
		conta.setNome("Nubank");
		conta.setTipoConta(TipoConta.CORRENTE);
			
		contaDAO.cadastrar(conta);
		
		System.out.println("Conta Cadastrada!");*/
		 
			
				
				
// BUSCA DE CONTA POR CODIGO E ALTERAÇÃO EM INFORMAÇÕES
		/*ContaDAO contaDAO = new ContaDAOImpl();
						
		System.out.println("Conta Selecionada: ");
		Conta conta = contaDAO.buscarPorCodigo(2);
		
		conta.setNome("BRADESCO");
		
		contaDAO.alterar(conta);
		
		System.out.println("Alteração realizada");*/
		
		
		
// BUSCA DE TODAS AS CONTAS
		/*ContaDAO dao = new ContaDAOImpl ();
		
		List<Conta> conta = dao.buscarTodas();*/
		
		
		
// EXCLUSÃO DE CONTA
		
		/*ContaDAO dao = new ContaDAOImpl ();
		
		System.out.println("Conta Selecionada: ");
		Conta conta = dao.buscarPorCodigo(31);
		
		dao.deletar(31);
		
		System.out.println("Conta excluida!");*/
	}
}
			
		
