package dao;

import java.sql.Connection;
import java.util.List;

import model.Cliente;
import conexao.ConexaoUtil;

public class ClienteDAOJDBC implements ClienteDAO{

	private Connection con;

	public  ClienteDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Cliente entidade) {
		// TODO Auto-generated method stub
		
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
	
	
}
