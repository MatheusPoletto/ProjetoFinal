package dao;

import java.sql.Connection;
import java.util.List;

import pessoa.Endereco;
import conexao.ConexaoUtil;

public class EnderecoDAOJDBC implements EnderecoDAO{

	
	
	private Connection con;

	public  EnderecoDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> todos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
