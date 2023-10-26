package br.com.easyfinances.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.easyfinances.fintech.entidade.CartaoCredito;
import br.com.easyfinances.fintech.entidade.Categoria;
import br.com.easyfinances.fintech.entidade.Conta;
import br.com.easyfinances.fintech.entidade.StatusTransacao;
import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.entidade.TipoPagamento;
import br.com.easyfinances.fintech.entidade.TipoTransacao;
import br.com.easyfinances.fintech.entidade.Transacao;
import br.com.easyfinances.fintech.jdbc.ConexaoJdbc;

public class TransacaoDAOImpl implements TransacaoDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void cadastrar(Transacao transacao) {
		
		try {
			conexao = ConexaoJdbc.obterConexao ();
			pstmt = conexao.prepareStatement("INSERT INTO T_FINTECH_TRANSACAO (CD_TRANSACAO, DS_TRANSACAO, VL_TRANSACAO, DT_TRANSACAO, CD_USUARIO, "
					+ "CD_CONTA, CD_TIPO_TRANSACAO, CD_CATEGORIA, CD_TIPO_PGTO, CD_STATUS_TRANSACAO, CD_CARTAO_CREDITO) "
					+ "VALUES (SEQ_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
			pstmt.setString(1, transacao.getDescricao());
			pstmt.setDouble(2, transacao.getValor());
			pstmt.setDate(3, new java.sql.Date (transacao.getData().getTime()));
			pstmt.setInt(4, transacao.getUsuario().getCodigo());
			pstmt.setInt(5, transacao.getConta().getCodigoConta());
			pstmt.setInt(6, transacao.getTipoTransacao().getId());
			pstmt.setInt(7, transacao.getCategoria().getId());
			pstmt.setInt(8, transacao.getTipoPagamento().getId());
			pstmt.setInt(9, transacao.getStatusTransacao().getId());
			pstmt.setObject(10, (transacao.getCartaoCredito() != null) ? (transacao.getCartaoCredito().getCodigo()) : null);
			pstmt.executeUpdate();					
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conexao.close();
			}	
			catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Transacao> buscarTodas() {
		
		List<Transacao> transacoes = new ArrayList<Transacao>();
		ResultSet result = null;
		try {
			conexao = ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_TRANSACAO ORDER BY CD_TRANSACAO ASC");
			result = pstmt.executeQuery();
			
			while (result.next()) {
				int codigo = result.getInt("CD_TRANSACAO");
				String descricao = result.getString("DS_TRANSACAO");
				double valor = result.getDouble("VL_TRANSACAO");
				Date data = result.getDate("DT_TRANSACAO");
				int usuario = result.getInt("CD_USUARIO");
				int conta = result.getInt("CD_CONTA");
				int tipoTransacao = result.getInt("CD_TIPO_TRANSACAO");
				int categoria = result.getInt("CD_CATEGORIA");
				int tipoPagamento = result.getInt("CD_TIPO_PGTO");
				int statusTransacao = result.getInt("CD_STATUS_TRANSACAO");
				int cartaoCredito = result.getInt("CD_CARTAO_CREDITO");
				
				Transacao transacao  = new Transacao (codigo, descricao, valor, data, new Usuario(usuario), new Conta(conta),TipoTransacao.getTipoTransacao(tipoTransacao), 
						Categoria.getCategoria(categoria), TipoPagamento.getTipoPagamento(tipoPagamento), StatusTransacao.getStatusTransacao(statusTransacao), 
						new CartaoCredito(cartaoCredito));
				
				transacoes.add(transacao);
				
				System.out.println(codigo + "" + descricao + "" + valor + "" + data + "" + usuario + "" + conta + "" + tipoTransacao + "" + categoria
						+ "" + tipoPagamento + "" + statusTransacao + "" + cartaoCredito + "");
			}
			conexao.close();
			
		}
		
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return transacoes;
		
	}
			
	@Override
	public Transacao buscarPorCodigo(int codigo) {
		Transacao transacao = null;
		ResultSet result = null;
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_TRANSACAO WHERE CD_TRANSACAO = ?");
			pstmt.setInt(1, codigo);
			result = pstmt.executeQuery();
			result.next();
			
			String descricao = result.getString("DS_TRANSACAO");
			double valor = result.getDouble("VL_TRANSACAO");
			Date data = result.getDate("DT_TRANSACAO");
			int usuario = result.getInt("CD_USUARIO");
			int conta = result.getInt("CD_CONTA");
			int tipoTransacao = result.getInt("CD_TIPO_TRANSACAO");
			int categoria = result.getInt("CD_CATEGORIA");
			int tipoPagamento = result.getInt("CD_TIPO_PGTO");
			int statusTransacao = result.getInt("CD_STATUS_TRANSACAO");
			int cartaoCredito = result.getInt("CD_CARTAO_CREDITO");
			transacao  = new Transacao (codigo, descricao, valor, data, new Usuario(usuario), new Conta(conta),
					TipoTransacao.getTipoTransacao(tipoTransacao), Categoria.getCategoria(categoria), 
					TipoPagamento.getTipoPagamento(tipoPagamento), StatusTransacao.getStatusTransacao(statusTransacao), new CartaoCredito(cartaoCredito));
			
			System.out.println(codigo + "" + descricao + "" + valor + "" + data + "" + usuario + "" + conta + "" + tipoTransacao + "" + categoria
					+ "" + tipoPagamento + "" + statusTransacao + "" + cartaoCredito + "");	
			
		conexao.close();
		}
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return transacao;				
	}
			
	@Override
	public void alterar (Transacao transacao) {
		
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_FINTECH_TRANSACAO SET DS_TRANSACAO = ?, VL_TRANSACAO = ?, DT_TRANSACAO = ?, CD_USUARIO = ?, "
					+ "CD_CONTA = ?, CD_TIPO_TRANSACAO = ?, CD_CATEGORIA = ?, CD_TIPO_PGTO = ?, CD_STATUS_TRANSACAO = ?, CD_CARTAO_CREDITO = ?"
					+ " WHERE CD_TRANSACAO = ?");
			pstmt.setString (1, transacao.getDescricao());
			pstmt.setDouble (2, transacao.getValor());
			pstmt.setDate (3, new java.sql.Date (transacao.getData().getTime()));
			pstmt.setInt(4, transacao.getUsuario().getCodigo());
			pstmt.setInt(5, transacao.getConta().getCodigoConta());
			pstmt.setInt(6, transacao.getTipoTransacao().getId());
			pstmt.setInt(7, transacao.getCategoria().getId());
			pstmt.setInt(8, transacao.getTipoPagamento().getId());
			pstmt.setInt(9, transacao.getStatusTransacao().getId());
			pstmt.setObject(10, (transacao.getCartaoCredito() != null) ? (transacao.getCartaoCredito().getCodigo()) : null);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conexao.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deletar(int codigo) {
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_FINTECH_TRANSACAO WHERE CD_TRANSACAO = ?");
			pstmt.setInt (1, codigo);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conexao.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
