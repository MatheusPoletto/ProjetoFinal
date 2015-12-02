package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import pessoa.Cliente;
import pessoa.Pessoa;
import utilitario.MensagemSucesso;

public class CadastrarCliente {
	
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private MensagemSucesso ms = new MensagemSucesso();
	
	public Cliente salvarCliente(Pessoa pessoa, String interesse1, String interesse2, String interesse3){
			Cliente cliente = new Cliente(pessoa, clienteDao.maiorId(), interesse1, interesse2, interesse3);
			clienteDao.inserir(cliente);
			ms.sucessoCadastrarCliente();
			return cliente;
	}
	

}
