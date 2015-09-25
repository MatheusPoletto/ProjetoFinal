package dao;

import java.sql.Connection;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Pessoa;

public class PessoaDAOJDBC implements PessoaDAO{

	
	private Connection con;

	public  PessoaDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}
	
	
	@Override
	public void inserir(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}
