package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOFactory.DaoFactoryJDBC;
import conexao.ConexaoUtil;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{

	private Connection con;

	public  UsuarioDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Usuario usuario) {
		String sql = "insert into Usuario(idUsuario, login, senha, Corretor_idCorretor, nivelAcesso) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, usuario.getIdUsuario());
			pstmt.setString(2, usuario.getLogin());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setInt(4, usuario.getCorretor().getIdCorretor());
			pstmt.setInt(5, usuario.getNivelAcesso());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario usuario) {
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
		CorretorDAO corretorDao = new CorretorDAOJDBC();
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivelAcesso(rs.getInt("nivelAcesso"));
				usuario.setCorretor(corretorDao.buscar(rs.getInt("Corretor_idCorretor")));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
