package br.com.easyfinances.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.easyfinances.fintech.entidade.CartaoCredito;
import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.jdbc.ConexaoJdbc;

public class CartaoCreditoDAOImpl implements CartaoCreditoDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void cadastrar(CartaoCredito cartaoCredito) {
		
		try {
			conexao = ConexaoJdbc.obterConexao ();
			pstmt = conexao.prepareStatement("INSERT INTO T_FINTECH_CART_CRED (CD_CARTAO_CREDITO, NM_CARTAO_CREDITO, VL_LIMITE, CD_USUARIO) "
					+ "VALUES (SEQ_CART_CRED.NEXTVAL, ?, ?, ?)");
					
			pstmt.setString(1, cartaoCredito.getNome());
			pstmt.setDouble(2, cartaoCredito.getValorLimite());
			pstmt.setInt(3, cartaoCredito.getUsuario().getCodigo());
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
	public List<CartaoCredito> buscarTodos() {
		
		List<CartaoCredito> cartoesCredito = new ArrayList<CartaoCredito>();
		ResultSet result = null;
		try {
			conexao = ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_CART_CRED ORDER BY CD_CARTAO_CREDITO ASC");
			result = pstmt.executeQuery();
			
			while (result.next()) {
				int codigo = result.getInt("CD_CARTAO_CREDITO");
				String nome = result.getString("NM_CARTAO_CREDITO");
				double valorLimite = result.getDouble("VL_LIMITE");
				int usuario = result.getInt("CD_USUARIO");
				CartaoCredito cartaoCredito  = new CartaoCredito (codigo, nome, valorLimite, new Usuario(usuario));
				cartoesCredito.add(cartaoCredito);
				
				System.out.println(codigo + "" + nome + "" + valorLimite + "" + usuario + "");
			}
			conexao.close();
			
		}
		
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return cartoesCredito;
		
	}
			
	@Override
	public CartaoCredito buscarPorCodigo(int codigo) {
		CartaoCredito cartaoCredito = null;
		ResultSet result = null;
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_CART_CRED WHERE CD_CARTAO_CREDITO = ?");
			pstmt.setInt(1, codigo);
			result = pstmt.executeQuery();
			result.next();
			
			codigo = result.getInt("CD_CARTAO_CREDITO");
			String nome = result.getString("NM_CARTAO_CREDITO");
			double valorLimite = result.getDouble("VL_LIMITE");
			int usuario = result.getInt("CD_USUARIO");
			cartaoCredito  = new CartaoCredito (codigo, nome, valorLimite, new Usuario(usuario));
			
			System.out.println(codigo + "" + nome + "" + valorLimite + "" + usuario + "");	
			
		conexao.close();
		}
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return cartaoCredito;				
	}
			
	@Override
	public void alterar (CartaoCredito cartaoCredito) {
		
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_FINTECH_CART_CRED SET NM_CARTAO_CREDITO = ?, VL_LIMITE = ?, CD_USUARIO = ? WHERE CD_CARTAO_CREDITO = ?");
			pstmt.setString (1, cartaoCredito.getNome());
			pstmt.setDouble(2, cartaoCredito.getValorLimite());
			pstmt.setInt(3, cartaoCredito.getUsuario().getCodigo());
			pstmt.setInt(4, cartaoCredito.getCodigo());
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
	
	@Override
	public void deletar(int codigo) {
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_FINTECH_CART_CRED WHERE CD_CARTAO_CREDITO = ?");
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
