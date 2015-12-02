package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.EnderecoDAO;
import pessoa.Endereco;

public class CadastrarEndereco {

	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	
	public Endereco salvarEndereco(String rua, String numero, String bairro, String cidade, String uf, String cep){
		Endereco endereco = new Endereco(enderecoDao.maiorId()+1, rua, numero, bairro, cidade, cep, uf);
		enderecoDao.inserir(endereco);
		return endereco;
	}
}
