package br.com.easyfinances.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.easyfinances.fintech.entidade.Conta;
import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.entidade.TipoConta;
import br.com.easyfinances.fintech.jdbc.ConexaoJdbc;


public class ContaDAOImpl implements ContaDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void cadastrar(Conta conta) {
		
		try {
			conexao = ConexaoJdbc.obterConexao ();
			pstmt = conexao.prepareStatement("INSERT INTO T_FINTECH_CONTA (CD_CONTA, NM_CONTA, CD_USUARIO, CD_TIPO_CONTA) "
					+ "VALUES (SEQ_CONTA.NEXTVAL, ?, ?, ?)");
					
			pstmt.setString(1, conta.getNome());
			pstmt.setInt(2, conta.getUsuario().getCodigo());
			pstmt.setInt(3, conta.getTipoConta().getId());
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
	public List<Conta> buscarTodas() {
		
		List<Conta> contas = new ArrayList<Conta>();
		ResultSet result = null;
		try {
			conexao = ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_CONTA ORDER BY CD_CONTA ASC");
			result = pstmt.executeQuery();
			
			while (result.next()) {
				int codigoConta = result.getInt("CD_CONTA");
				String nome = result.getString("NM_CONTA");
				int usuario = result.getInt("CD_USUARIO");
				int tipoConta = result.getInt("CD_TIPO_CONTA");
				Conta conta  = new Conta (codigoConta, nome, new Usuario(usuario), TipoConta.getTipoConta(tipoConta));
				contas.add(conta);
				
				System.out.println(codigoConta + "" + nome + "" + usuario + "" + tipoConta + "");
			}
			conexao.close();
			
		}
		
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return contas;
		
	}
			
	@Override
	public Conta buscarPorCodigo(int codigoConta) {
		Conta conta = null;
		ResultSet result = null;
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_CONTA WHERE CD_CONTA = ?");
			pstmt.setInt(1, codigoConta);
			result = pstmt.executeQuery();
			result.next();
			
			int codigo = result.getInt("CD_CONTA");
			String nome = result.getString("NM_CONTA");
			int usuario = result.getInt("CD_USUARIO");
			int tipoConta = result.getInt("CD_TIPO_CONTA");
			conta  = new Conta (codigo, nome, new Usuario(usuario), TipoConta.getTipoConta(tipoConta));
			
			System.out.println(codigoConta + "" + nome + "" + usuario + "" + tipoConta + "");	
			
		conexao.close();
		}
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return conta;				
	}
			
	@Override
	public void alterar (Conta conta) {
		
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_FINTECH_CONTA SET NM_CONTA = ?, CD_USUARIO = ?, CD_TIPO_CONTA = ? WHERE CD_CONTA = ?");
			pstmt.setString (1, conta.getNome());
			pstmt.setInt(2, conta.getUsuario().getCodigo());
			pstmt.setInt(3, conta.getTipoConta().getId());
			pstmt.setInt(4, conta.getCodigoConta());
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
	public void deletar(int codigoConta) {
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_FINTECH_CONTA WHERE CD_CONTA = ?");
			pstmt.setInt (1, codigoConta);
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
