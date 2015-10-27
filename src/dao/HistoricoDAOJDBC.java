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
	public void inserir(Historico historico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Historico historico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Historico historico) {
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


	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
