package DAOFactory;

import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;

public class DaoFactory implements AbstractDaoFactory {

	
	
	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;
	
	//CONSTRUINDO A FABRICA DE DAO
	public static DaoFactory getDaoFactory(){
		if (factory == null) {
			factory = new DaoFactory();			
		}
		daoFactory = new DaoFactoryJDBC();
		return factory;
	}
	
		
		
	public ClienteDAO clienteDAO() {
		// TODO Auto-generated method stub
		return daoFactory.clienteDAO();
	}

	@Override
	public CorretorDAO corretorDAO() {
		// TODO Auto-generated method stub
		return daoFactory.corretorDAO();
	}

	@Override
	public EnderecoDAO enderecoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImobiliariaDAO imobiliariaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImovelDAO imovelDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PessoaDAO pessoaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDAO usuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaDAO vendaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
