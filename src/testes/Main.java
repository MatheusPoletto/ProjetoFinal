package testes;

import java.time.LocalDate;
import java.util.ArrayList;

import imovel.Aluguel;
import imovel.Imovel;
import imovel.Venda;
import model.Historico;
import model.VendaImovel;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;

public class Main {
	public static void main(String[] args) {		
		Endereco endereco = new Endereco(0, "Rua Irineu Bornhausen", "160", "Antonio Paglia", "Ponte Serrada", "89683-000", "SC");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(0);
		pessoa.setNome("Matheus Otavio Poletto");
		pessoa.setRg("6.543.345");
		pessoa.setCpf("098.676.199-87");
		pessoa.setEstadoCivil(0);
		pessoa.setGenero(0);
		pessoa.setDataNascimento(LocalDate.of(1997, 01, 24));
		pessoa.setEndereco(endereco);
		pessoa.setTelefone("3435-0000");
		
		Cliente cliente = new Cliente(); 
		cliente.setPessoa(pessoa);
		cliente.setIdCliente(0);
		//ArrayList<String> interesses = new ArrayList<>();
		cliente.setInteresses(null);
		cliente.setSalario(3500.60);
		
		Endereco enderecoImovel = new Endereco(1, "Rua Angelo Favretto", "25", "Centro", "Ponte Serrada", "89683-000", "SC");
		
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
		pessoaComprador.setEstadoCivil(1);
		pessoaComprador.setGenero(0);
		pessoaComprador.setDataNascimento(LocalDate.of(1996, 05, 20));
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
		pessoaCorretor.setEstadoCivil(1);
		pessoaCorretor.setGenero(0);
		pessoaCorretor.setDataNascimento(LocalDate.of(1996, 05, 20));
		pessoaCorretor.setEndereco(endereco);
		pessoaCorretor.setTelefone("3435-1111");
		
		Corretor corretor = new Corretor();
		corretor.setPessoa(pessoaCorretor);
		corretor.setIdCorretor(0);
		corretor.setSalario(3443.50);
		corretor.setPorcentagemComissao(10.0);
		corretor.setTelefone("9954-9681");
		
		Historico historico = new Historico(0, LocalDate.now(), imovel, clienteComprador, corretor);
		
		
	}
}
