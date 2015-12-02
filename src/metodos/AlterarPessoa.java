package metodos;

import java.util.Date;

import DAOFactory.DaoFactoryJDBC;
import dao.PessoaDAO;
import pessoa.Pessoa;

public class AlterarPessoa {

	PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();

	protected Pessoa alterarPessoa(Integer idPessoa, String nome, String rg, String cpf, Date dataNascimento, String genero,
			String estadoCivil, String telefoneResidencial, String telefoneCelular, String email) {
		Pessoa pessoa = pessoaDao.buscar(idPessoa);
		pessoa.setNome(nome);
		pessoa.setRg(rg);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setGenero(genero);
		pessoa.setEstadoCivil(estadoCivil);
		pessoa.setTelefoneResidencial(telefoneResidencial);
		pessoa.setTelefoneCelular(telefoneCelular);
		pessoa.setEmail(email);
		pessoaDao.alterar(pessoa);
		return pessoa;

	}

}
