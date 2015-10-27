package dao;

import java.sql.Connection;
import java.util.List;

import conexao.ConexaoUtil;
import imovel.Imovel;

public class ImovelDAOJDBC implements ImovelDAO{

	
	
	private Connection con;

	public  ImovelDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imovel imovel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Imovel imovel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Imovel imovel) {
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

	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
