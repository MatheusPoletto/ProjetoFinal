package metodos;

import java.util.Date;

import DAOFactory.DaoFactoryJDBC;
import dao.CorretorDAO;
import pessoa.Corretor;
import pessoa.Pessoa;
import utilitario.MensagemSucesso;

public class AlterarCorretor {

	private MensagemSucesso ms = new MensagemSucesso();
	private AlterarPessoa ap = new AlterarPessoa();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	
	public void alterarCorretor(Integer idPessoa, String nome, String rg, String cpf, Date dataNascimento, String genero,
			String estadoCivil, String telefoneResidencial, String telefoneCelular, String email, Double salario) {

		Pessoa pessoa = ap.alterarPessoa(idPessoa, nome, rg, cpf, dataNascimento, genero, estadoCivil,
				telefoneResidencial, telefoneCelular, email);

		Corretor corretorAltera = new Corretor();
		for (Corretor corretor : corretorDao.todos()) {
			if (corretor.getPessoa().getId() == pessoa.getId()) {
				corretorAltera = corretorDao.buscar(corretor.getIdCorretor());
			}
		}

		corretorAltera.setSalario(salario);
		
		corretorDao.alterar(corretorAltera);
		
		ms.sucessoAlterarCorretor();

	}
	
	
}
