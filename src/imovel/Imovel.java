package imovel;

import pessoa.Endereco;
import pessoa.Pessoa;


public class Imovel {
	private Integer idImovel;
	private Endereco endereco; 
	private String metrosquadrados; 
	private Pessoa pessoa; 
	
	
	// não coloquei os gettes e os settes porque o imovel tem que receber uma venda ou um aluguel e o seu dono
	// se está lendo isto já sabe o que fazer. 
	
	
	
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
}
