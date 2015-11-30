package DAOFactory;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import dao.CorretorDAO;
import dao.CorretorDAOJDBC;
import dao.EnderecoDAO;
import dao.EnderecoDAOJDBC;
import dao.ImobiliariaDAO;
import dao.ImobliariaDAOJDBC;
import dao.ImovelDAO;
import dao.ImovelDAOJDBC;
import dao.NotaFiscalDAO;
import dao.NotaFiscalDAOJDBC;
import dao.PessoaDAO;
import dao.PessoaDAOJDBC;
import dao.UsuarioDAO;
import dao.UsuarioDAOJDBC;
import dao.VendaDAO;
import dao.VendaDAOJDBC;

public class DaoFactoryJDBC implements AbstractDaoFactory {

	private static DaoFactoryJDBC factory;

	public static DaoFactoryJDBC get() {

		if (factory == null) {
			factory = new DaoFactoryJDBC();
		}
		return factory;
	}

	public ClienteDAO clienteDAO() {
		return new ClienteDAOJDBC();
	}

	public NotaFiscalDAO notaFiscalDAO() {
		return new NotaFiscalDAOJDBC();
	}

	public CorretorDAO corretorDAO() {

		return new CorretorDAOJDBC();
	}

	public EnderecoDAO enderecoDAO() {

		return new EnderecoDAOJDBC();
	}

	public ImobiliariaDAO imobiliariaDAO() {

		return new ImobliariaDAOJDBC();
	}

	public ImovelDAO imovelDAO() {

		return new ImovelDAOJDBC();
	}

	public PessoaDAO pessoaDAO() {

		return new PessoaDAOJDBC();
	}

	public UsuarioDAO usuarioDAO() {

		return new UsuarioDAOJDBC();
	}

	public VendaDAO vendaDAO() {
		return new VendaDAOJDBC();
	}

}
