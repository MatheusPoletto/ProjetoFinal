package jdbc;

import java.sql.Connection;
import java.util.List;

import model.Proprietario;
import conexao.ConexaoUtil;
import dao.ProprietarioDAO;

public class ProprietarioDAOJDBC implements ProprietarioDAO{

	
	
	
	private Connection con;

	public  ProprietarioDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Proprietario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Proprietario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Proprietario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proprietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proprietario> todos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
