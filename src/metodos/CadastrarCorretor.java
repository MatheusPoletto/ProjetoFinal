package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.CorretorDAO;
import dao.UsuarioDAO;
import pessoa.Corretor;
import pessoa.Pessoa;
import pessoa.Usuario;
import utilitario.MensagemSucesso;

public class CadastrarCorretor {

	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private MensagemSucesso ms = new MensagemSucesso();
	
	public Corretor salvarCorretor(Pessoa pessoa, Double salario, String login, String senha, Integer nivelAcesso){
			Corretor corretor = new Corretor(pessoa, corretorDao.maiorId()+1, salario);
			Usuario usuario = new Usuario(usuarioDao.maiorId()+1, login, senha, corretor, nivelAcesso);
			corretorDao.inserir(corretor);
			ms.sucessoCadastrarCliente();
			return corretor;
	}
	
	
}
