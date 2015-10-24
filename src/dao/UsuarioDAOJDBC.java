package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{

	private Connection con;

	public  UsuarioDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Usuario entidade) {
		String sql = "insert into Usuario(idUsuario, login, senha, Corretor_idCorretor) values(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, entidade.getIdUsuario());
			pstmt.setString(2, entidade.getLogin());
			pstmt.setString(3, entidade.getSenha());
			pstmt.setInt(4, entidade.getCorretor().getIdCorretor());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Usuario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idUsuario) from usuario";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idUsuario)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}

	@Override
	public List<Usuario> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}
