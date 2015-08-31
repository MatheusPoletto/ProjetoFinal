package dao;

import java.sql.Connection;
import java.util.List;

import model.Imovel;
import conexao.ConexaoUtil;

public class ImovelDAOJDBC implements ImovelDAO{

	
	
	private Connection con;

	public  ImovelDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imovel entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Imovel entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Imovel entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Imovel buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imovel> todos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
