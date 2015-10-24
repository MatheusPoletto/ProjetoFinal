package imovel;

import pessoa.Cliente;
import pessoa.Endereco;
import pessoa.Pessoa;


public class Imovel {
	private Integer idImovel;
	private Endereco endereco; 
	private String metrosquadrados; 
	private Cliente cliente; 
	
	
	
	
	public Integer getIdImovel() {
		return idImovel;
	}
	
	public void setIdImovel(Integer idimovel) {
		this.idImovel = idimovel;
	}
	

	public String getMetrosquadrados() {
		return metrosquadrados;
	}

	public void setMetrosquadrados(String metrosquadrados) {
		this.metrosquadrados = metrosquadrados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Imovel(Integer idImovel, Endereco endereco, String metrosquadrados, Cliente cliente) {
		super();
		this.idImovel = idImovel;
		this.endereco = endereco;
		this.metrosquadrados = metrosquadrados;
		this.cliente = cliente;
	}

	public Imovel() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
}
