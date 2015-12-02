package metodos;

import java.util.Date;

import DAOFactory.DaoFactoryJDBC;
import dao.PessoaDAO;
import pessoa.Endereco;
import pessoa.Pessoa;

public class CadastrarPessoa {

	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	
	public Pessoa salvarPessoa(String nome, String rg, String cpf, Date dataNascimento, String genero, String estadoCivil, String telefoneResidencial, String telefoneCelular, String email, Endereco endereco){
		Pessoa pessoa = new Pessoa(pessoaDao.maiorId()+1, nome, rg, cpf, estadoCivil, genero, dataNascimento, endereco, telefoneResidencial, telefoneCelular, email);
		pessoaDao.inserir(pessoa);
		return pessoa;
	}


	
	
}
