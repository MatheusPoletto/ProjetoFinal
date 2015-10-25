package model;

import pessoa.Endereco;

public class Imobiliaria  {	
	private Integer idImobiliaria;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	//Tinhamos esquecido de colocar endereco endereco aqui e tava tudo os atributos grandes de antes
	private Endereco endereco; 



	private String telefone;
	private String nomeProprietario;
	public Integer getIdImobiliaria() {
		return idImobiliaria;
	}
	public void setIdImobiliaria(Integer idImobiliaria) {
		this.idImobiliaria = idImobiliaria;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	public Imobiliaria(Integer idImobiliaria, String razaoSocial,
			String nomeFantasia, String cnpj, Endereco endereco,
			String telefone, String nomeProprietario) {
		super();
		this.idImobiliaria = idImobiliaria;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nomeProprietario = nomeProprietario;
	}

	
	public Imobiliaria(){
		
	}

}