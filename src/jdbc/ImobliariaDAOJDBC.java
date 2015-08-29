package jdbc;

import java.sql.Connection;
import java.util.List;

import model.Imobiliaria;
import conexao.ConexaoUtil;
import dao.ImobiliariaDAO;

public class ImobliariaDAOJDBC implements ImobiliariaDAO {

	
	private Connection con;

	public  ImobliariaDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imobiliaria entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Imobiliaria entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Imobiliaria entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Imobiliaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imobiliaria> todos() {
		// TODO Auto-generated method stub
		return null;
	}
}
