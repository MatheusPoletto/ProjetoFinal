package metodos;

import java.util.Date;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import pessoa.Cliente;
import pessoa.Pessoa;
import utilitario.MensagemSucesso;

public class AlterarCliente {

	private MensagemSucesso ms = new MensagemSucesso();
	private AlterarPessoa ap = new AlterarPessoa();
	ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public void alterarCliente(Integer idPessoa, String nome, String rg, String cpf, Date dataNascimento, String genero,
			String estadoCivil, String telefoneResidencial, String telefoneCelular, String email, String interesse1,
			String interesse2, String interesse3) {

		Pessoa pessoa = ap.alterarPessoa(idPessoa, nome, rg, cpf, dataNascimento, genero, estadoCivil,
				telefoneResidencial, telefoneCelular, email);

		Cliente clienteAltera = new Cliente();
		for (Cliente cliente : clienteDao.todos()) {
			if (cliente.getPessoa().getId() == pessoa.getId()) {
				clienteAltera = clienteDao.buscar(cliente.getIdCliente());
			}
		}

		clienteAltera.setInteresse1(interesse1);
		clienteAltera.setInteresse2(interesse2);
		clienteAltera.setInteresse3(interesse3);
		clienteDao.alterar(clienteAltera);

		ms.sucessoAlterarCliente();

	}

}
