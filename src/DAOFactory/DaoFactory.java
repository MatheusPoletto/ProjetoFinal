package DAOFactory;

import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import dao.NotaFiscalDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;

public class DaoFactory implements AbstractDaoFactory {

	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;

	public static DaoFactory getDaoFactory() {
		if (factory == null) {
			factory = new DaoFactory();
		}
		daoFactory = new DaoFactoryJDBC();
		return factory;
	}

	public ClienteDAO clienteDAO() {
		return daoFactory.clienteDAO();
	}

	public NotaFiscalDAO notaFiscalDAO() {
		return daoFactory.notaFiscalDAO();
	}

	public CorretorDAO corretorDAO() {
		return daoFactory.corretorDAO();
	}

	public EnderecoDAO enderecoDAO() {
		return null;
	}

	public ImobiliariaDAO imobiliariaDAO() {
		return null;
	}

	public ImovelDAO imovelDAO() {
		return null;
	}

	public PessoaDAO pessoaDAO() {
		return null;
	}

	public UsuarioDAO usuarioDAO() {
		return null;
	}

	public VendaDAO vendaDAO() {
		return null;
	}

}
