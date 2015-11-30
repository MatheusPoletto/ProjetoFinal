package model;

import pessoa.Endereco;

public class Imobiliaria {
	private Integer idImobiliaria;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private Endereco endereco;
	private String telefone;

	public Imobiliaria(Integer idImobiliaria, String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco,
			String telefone) {
		super();
		this.idImobiliaria = idImobiliaria;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Imobiliaria() {
		super();
	}

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

}