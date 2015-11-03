package DAOFactory;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import dao.CorretorDAO;
import dao.CorretorDAOJDBC;
import dao.EnderecoDAO;
import dao.EnderecoDAOJDBC;
import dao.HistoricoDAO;
import dao.HistoricoDAOJDBC;
import dao.ImobiliariaDAO;
import dao.ImobliariaDAOJDBC;
import dao.ImovelDAO;
import dao.ImovelDAOJDBC;
import dao.PessoaDAO;
import dao.PessoaDAOJDBC;
import dao.UsuarioDAO;
import dao.UsuarioDAOJDBC;

// tem que digitar como ta se colocar letra minuscula e no dao ta maiscula vai dar erro. 

public class DaoFactoryJDBC implements AbstractDaoFactory {
	
	private static DaoFactoryJDBC factory;
	
	public static DaoFactoryJDBC get(){
		
		if(factory == null){
			factory = new DaoFactoryJDBC();
		}
		return factory;
	}

	
	@Override
	public ClienteDAO clienteDAO() {
		return new ClienteDAOJDBC();
	}

	@Override
	public CorretorDAO corretorDAO() {
	
		return new CorretorDAOJDBC();
	}

	@Override
	public EnderecoDAO enderecoDAO() {
		
		return new EnderecoDAOJDBC();
	}

	@Override
	public HistoricoDAO historicoDAO() {
	
		 return new HistoricoDAOJDBC(); //falta fazer historico dao jdbc 
	//return null; 
	}

	@Override
	public ImobiliariaDAO imobiliariaDAO() {
		
		return new ImobliariaDAOJDBC();  //criado sem o i , não quiz mudar 
	}

	@Override
	public ImovelDAO imovelDAO() {
		
		return new ImovelDAOJDBC();
	}

	@Override
	public PessoaDAO pessoaDAO() {
		
		return new PessoaDAOJDBC();
	}

	@Override
	public UsuarioDAO usuarioDAO() {

		return new UsuarioDAOJDBC();
	}


}
