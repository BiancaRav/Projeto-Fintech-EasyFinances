package br.com.easyfinances.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.easyfinances.fintech.entidade.Usuario;
import br.com.easyfinances.fintech.jdbc.ConexaoJdbc;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void cadastrar(Usuario usuario) {
		
		try {
			conexao = ConexaoJdbc.obterConexao ();
			pstmt = conexao.prepareStatement("INSERT INTO T_FINTECH_USUARIO (CD_USUARIO, NM_USUARIO, DS_EMAIL, NR_SENHA) "
					+ "VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?)");
					
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
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
	public List<Usuario> buscarTodos() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet result = null;
		try {
			conexao = ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_USUARIO ORDER BY CD_USUARIO ASC");
			result = pstmt.executeQuery();
			
			while (result.next()) {
				int codigo = result.getInt("CD_USUARIO");
				String nome = result.getString("NM_USUARIO");
				String email = result.getString("DS_EMAIL");
				String senha = result.getString("NR_SENHA");
				Usuario usuario  = new Usuario (codigo, nome, email, senha);
				usuarios.add(usuario);
				
				System.out.println(codigo + "" + nome + "" + email + "" + senha + "");
			}
			conexao.close();
			
		}
		
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return usuarios;
		
	}
			
	@Override
	public Usuario buscarPorCodigo(int codigo) {
		Usuario usuario = null;
		ResultSet result = null;
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FINTECH_USUARIO WHERE CD_USUARIO = ?");
			pstmt.setInt(1, codigo);
			result = pstmt.executeQuery();
			result.next();
			
			codigo = result.getInt("CD_USUARIO");
			String nome = result.getString("NM_USUARIO");
			String email = result.getString("DS_EMAIL");
			String senha = result.getString("NR_SENHA");
			usuario  = new Usuario (codigo, nome, email, senha);
			
			System.out.println(codigo + "" + nome + "" + email + "" + senha + "");	
			
		conexao.close();
		}
		catch (SQLException e) {
			System.err.println("Não foi possivel se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		return usuario;				
	}
			
	@Override
	public void alterar (Usuario usuario) {
		
		try {
			conexao= ConexaoJdbc.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_FINTECH_USUARIO SET NM_USUARIO = ?, DS_EMAIL = ?, NR_SENHA = ? WHERE CD_USUARIO = ?");
			pstmt.setString (1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setInt(4, usuario.getCodigo());
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
			pstmt = conexao.prepareStatement("DELETE FROM T_FINTECH_USUARIO WHERE CD_USUARIO = ?");
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
