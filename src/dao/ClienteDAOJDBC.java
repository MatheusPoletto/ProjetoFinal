package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Cliente;

public class ClienteDAOJDBC implements ClienteDAO{

	private Connection con;

	public  ClienteDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Cliente entidade) {
		String sql = "insert into Cliente (idCliente, Pessoa_idPessoa) values(?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, entidade.getIdCliente());
			pstmt.setInt(2, entidade.getPessoa().getId());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Cliente entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cliente entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
