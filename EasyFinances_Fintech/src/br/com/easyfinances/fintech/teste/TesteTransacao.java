package br.com.easyfinances.fintech.teste;

import java.util.Date;
import java.util.List;

import br.com.easyfinances.fintech.dao.ContaDAO;
import br.com.easyfinances.fintech.dao.ContaDAOImpl;
import br.com.easyfinances.fintech.dao.TransacaoDAO;
import br.com.easyfinances.fintech.dao.TransacaoDAOImpl;
import br.com.easyfinances.fintech.dao.UsuarioDAO;
import br.com.easyfinances.fintech.dao.UsuarioDAOImpl;
import br.com.easyfinances.fintech.entidade.Categoria;
import br.com.easyfinances.fintech.entidade.Conta;
import br.com.easyfinances.fintech.entidade.StatusTransacao;
import br.com.easyfinances.fintech.entidade.TipoPagamento;
import br.com.easyfinances.fintech.entidade.TipoTransacao;
import br.com.easyfinances.fintech.entidade.Transacao;
import br.com.easyfinances.fintech.entidade.Usuario;

public class TesteTransacao {
	
public static void main(String[] args) {
		
// CADASTRO DE TRANSAÇÕES
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();
				
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(1);
				
		Transacao transacao = new Transacao();
		transacao.setUsuario(usuario);
		transacao.setDescricao("EDP");
		transacao.setValor(169.78);
		transacao.setData(new Date(2023, 10, 22));
		transacao.setUsuario(usuario);
		transacao.setConta(new Conta(1));
		transacao.setTipoTransacao(TipoTransacao.DESPESA);
		transacao.setCategoria(Categoria.CONTASFIXAS);
		transacao.setTipoPagamento(TipoPagamento.PIX);
		transacao.setStatusTransacao(StatusTransacao.QUITADA);
				
		transacaoDAO.cadastrar(transacao);
				
		System.out.println("Transação Cadastrada!");*/
	
	
	
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();
	
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(70);
	
		Transacao transacao = new Transacao();
		transacao.setUsuario(usuario);
		transacao.setDescricao("Aluguel Vestido");
		transacao.setValor(150.00);
		transacao.setData(new Date(2023, 10, 26));
		transacao.setUsuario(usuario);
		transacao.setConta(new Conta(12));
		transacao.setTipoTransacao(TipoTransacao.DESPESA);
		transacao.setCategoria(Categoria.DESPESASPESSOAIS);
		transacao.setTipoPagamento(TipoPagamento.PIX);
		transacao.setStatusTransacao(StatusTransacao.PENDENTE);
		
		transacaoDAO.cadastrar(transacao);
	
		System.out.println("Transação Cadastrada!");*/
	
	
	
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();
			
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(73);
			
		Transacao transacao = new Transacao();
		transacao.setUsuario(usuario);
		transacao.setDescricao("Criptomoeda");
		transacao.setValor(1000.00);
		transacao.setData(new Date(2023, 10, 19));
		transacao.setUsuario(usuario);
		transacao.setConta(new Conta(14));
		transacao.setTipoTransacao(TipoTransacao.INVESTIMENTO);
		transacao.setCategoria(Categoria.INVESTIMENTOS);
		transacao.setTipoPagamento(TipoPagamento.TRANSFERENCIA);
		transacao.setStatusTransacao(StatusTransacao.QUITADA);
		
		transacaoDAO.cadastrar(transacao);
			
		System.out.println("Transação Cadastrada!");*/
	
	
	
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();
		
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(72);
			
		Transacao transacao = new Transacao();
		transacao.setUsuario(usuario);
		transacao.setDescricao("Bolo da Edina");
		transacao.setValor(90.00);
		transacao.setData(new Date(2023, 10, 12));
		transacao.setUsuario(usuario);
		transacao.setConta(new Conta(13));
		transacao.setTipoTransacao(TipoTransacao.RECEITA);
		transacao.setCategoria(Categoria.RECEBIVEIS);
		transacao.setTipoPagamento(TipoPagamento.DINHEIRO);
		transacao.setStatusTransacao(StatusTransacao.QUITADA);
			
		transacaoDAO.cadastrar(transacao);
			
		System.out.println("Transação Cadastrada!");*/
				
	
	
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();
			
		System.out.println("Usuario Selecionado: ");
		Usuario usuario = usuarioDAO.buscarPorCodigo(71);
			
		Transacao transacao = new Transacao();
		transacao.setUsuario(usuario);
		transacao.setDescricao("Faculdade");
		transacao.setValor(780.00);
		transacao.setData(new Date(2023, 10, 30));
		transacao.setUsuario(usuario);
		transacao.setConta(new Conta(17));
		transacao.setTipoTransacao(TipoTransacao.DESPESA);
		transacao.setCategoria(Categoria.EDUCACAO);
		transacao.setTipoPagamento(TipoPagamento.BOLETO);
		transacao.setStatusTransacao(StatusTransacao.PENDENTE);
			
		transacaoDAO.cadastrar(transacao);
			
		System.out.println("Transação Cadastrada!");*/
				
	
	
	
// BUSCA DE TRANSAÇÃO POR CODIGO E ALTERAÇÃO EM INFORMAÇÕES
		/*TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
							
		System.out.println("Transação Selecionada: ");
		Transacao transacao = transacaoDAO.buscarPorCodigo(31);
				
		transacao.setValor(169.98);
			
		transacaoDAO.alterar(transacao);
			
		System.out.println("Alteração realizada");*/
				
				
				
// BUSCA DE TODAS AS TRANSAÇÕES
		/*TransacaoDAO dao = new TransacaoDAOImpl();
				
		List<Transacao> transacao = dao.buscarTodas();*/
				
				
				
// EXCLUSÃO DE TRANSAÇÃO
		/*TransacaoDAO dao = new TransacaoDAOImpl();
				
		System.out.println("Transação Selecionada: ");
		Transacao transacao = dao.buscarPorCodigo(31);
				
		dao.deletar(31);
				
		System.out.println("Transação excluida!");*/
	}

}
