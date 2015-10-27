package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import imovel.Aluguel;
import imovel.Imovel;
import imovel.Venda;
import model.Historico;
import model.VendaImovel;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;

public class Main {
	public static void main(String[] args) throws ParseException {		
		PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
		EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
		ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
		CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
		UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	
		/*Endereco enderecoCliente = new Endereco(enderecoDao.maiorId()+1, "Rua Irineu Bornhausen", "160", "Antonio Paglia", "Ponte Serrada", "89683-000", "SC");
		enderecoDao.inserir(enderecoCliente);
		Endereco enderecoCorretor = new Endereco(enderecoDao.maiorId()+1, "Rua Paraná", "170", "BR-282", "Ponte Serrada", "89683-000", "SC");
		enderecoDao.inserir(enderecoCorretor);
		
		Date dateCliente = new SimpleDateFormat("yyyyMMdd").parse("19970124");
		Date dateCorretor = new SimpleDateFormat("yyyyMMdd").parse("19961020");
		Pessoa pessoaCliente = new Pessoa(pessoaDao.maiorId()+1, "Matheus Otavio Poletto", "6.516.346", "098.676.444-81", "Casado", "Masculino", dateCliente, enderecoCliente, "3435-0000", "motaviop@gmail.com");
		pessoaDao.inserir(pessoaCliente);
		Pessoa pessoaCorretor = new Pessoa(pessoaDao.maiorId()+1, "Matheus Arilton Ribak", "5.269.689", "158.987.458-79", "Solteiro", "Masculino", dateCorretor, enderecoCorretor, "3435-1589", "matheusribak@hotmail.com");
		pessoaDao.inserir(pessoaCorretor);
		
		Cliente cliente = new Cliente(pessoaCliente, clienteDao.maiorId()+1); 
		//ArrayList<String> interesses = new ArrayList<>();
		clienteDao.inserir(cliente);
		
		Corretor corretor = new Corretor(pessoaCorretor, corretorDao.maiorId()+1, 1500.00, 10.5);
		corretorDao.inserir(corretor);
	
		Usuario usuario = new Usuario(usuarioDao.maiorId()+1, "MPoletto", "1234", 2, corretor);
		usuarioDao.inserir(usuario);*/
		
		System.out.println("PESSOAS: ");
		for(Pessoa pessoas : pessoaDao.todos()){
			System.out.println("NOME: "+ pessoas.getNome() +" | ENDERECO: " + pessoas.getEndereco().getRua() +", " + pessoas.getEndereco().getBairro());
		}
		
		System.out.println("\nCORRETORES:");
		for(Corretor corretores : corretorDao.todos()){
			System.out.println("NOME: "+ corretores.getPessoa().getNome() +" | ENDERECO: " + corretores.getPessoa().getEndereco().getRua() +","
					+ " " + corretores.getPessoa().getEndereco().getBairro());
		}
		
		System.out.println("\nCLIENTES:");
		for(Cliente clientes : clienteDao.todos()){
			System.out.println("NOME: "+ clientes.getPessoa().getNome()+" | ENDERECO: " + clientes.getPessoa().getEndereco().getRua() +","
					+ " " + clientes.getPessoa().getEndereco().getBairro());
		}
		
		System.out.println("\nENDEREÇOS:");		
		for(Endereco enderecos : enderecoDao.todos()){
			System.out.println("RUA: "+ enderecos.getRua());
		}
		
		System.out.println("\nUSUARIOS:");		
		for(Usuario usuarios : usuarioDao.todos()){
			System.out.println("Nível: "+ usuarios.getNivelAcesso() +"| LOGIN: "+ usuarios.getLogin() + " | SENHA: "+ usuarios.getSenha() + " | CORRETOR RESPONSÁVEL PELA CONTA: "+ usuarios.getCorretor().getPessoa().getNome());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Endereco enderecoImovel = new Endereco(1, "Rua Angelo Favretto", "25", "Centro", "Ponte Serrada", "89683-000", "SC");
		
		Imovel imovel = new Imovel();
		imovel.setIdImovel(0);
		imovel.setEndereco(enderecoImovel);
		imovel.setMetrosquadrados("50 metros");
		imovel.setCliente(cliente);
		
		
		Aluguel aluguel = new Aluguel(imovel.getIdImovel(), imovel.getEndereco(), imovel.getMetrosquadrados(), imovel.getCliente(), 950.00, 12);
		
		Pessoa pessoaComprador = new Pessoa();
		pessoaComprador.setId(0);
		pessoaComprador.setNome("Matheus Arilton Ribak");
		pessoaComprador.setRg("5.353.445");
		pessoaComprador.setCpf("099.676.183-85");
		pessoaComprador.setEstadoCivil("Casado");
		pessoaComprador.setGenero("Masculino");
		//pessoaComprador.setDataNascimento(LocalDate.of(1996, 05, 20));
		pessoaComprador.setEndereco(endereco);
		pessoaComprador.setTelefone("3435-1111");
		
		Cliente clienteComprador = new Cliente(); 
		clienteComprador.setPessoa(pessoaComprador);
		clienteComprador.setIdCliente(0);
		ArrayList<String> interesses = new ArrayList<>();
		interesses.add("pequena");
		interesses.add("barata");
		clienteComprador.setInteresses(interesses);
		clienteComprador.setSalario(3500.60);
		
		Pessoa pessoaCorretor = new Pessoa();
		pessoaCorretor.setId(0);
		pessoaCorretor.setNome("Matheus Arilton Ribak");
		pessoaCorretor.setRg("5.353.445");
		pessoaCorretor.setCpf("099.676.183-85");
		pessoaCorretor.setEstadoCivil("Casado");
		pessoaCorretor.setGenero("Masculino");
		//pessoaCorretor.setDataNascimento(LocalDate.of(1996, 05, 20));
		pessoaCorretor.setEndereco(endereco);
		pessoaCorretor.setTelefone("3435-1111");
		
		Corretor corretor = new Corretor();
		corretor.setPessoa(pessoaCorretor);
		corretor.setIdCorretor(0);
		corretor.setSalario(3443.50);
		corretor.setPorcentagemComissao(10.0);
		corretor.setTelefone("9954-9681");
		
		Historico historico = new Historico(0, LocalDate.now(), imovel, clienteComprador, corretor);
		System.out.println(historico.getCliente().getPessoa().getNome());
		
	*/	
	}
}
