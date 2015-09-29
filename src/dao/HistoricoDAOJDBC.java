package dao;

import java.sql.Connection;
import java.util.List;

import conexao.ConexaoUtil;
import model.Historico;

public class HistoricoDAOJDBC implements HistoricoDAO{
	
	
	
	private Connection con;

	public  HistoricoDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}
	

	@Override
	public void inserir(Historico entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Historico entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Historico entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Historico buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historico> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
