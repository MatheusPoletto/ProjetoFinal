package model;

public class Imobiliaria  {	
	private Integer idImobiliaria;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String uf; 
	private String cidade;
	private String rua;
	private String bairro;
	private Integer numero; 
	private String telefone;
	private String nomeProprietario;

	public Integer getIdImobiliaria() {
		return idImobiliaria;
	}

	public void setIdImobiliaria(Integer idimobiliaria) {
		this.idImobiliaria = idimobiliaria;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaosocial) {
		this.razaoSocial = razaosocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomefantasia) {
		this.nomeFantasia = nomefantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public void setNomeProprietario(String nomeproprietario) {
		this.nomeProprietario = nomeproprietario;
	}
		
	public Imobiliaria(){
		
	}
	
	public Imobiliaria(Integer idimobiliaria, String razaosocial,
			String nomefantasia, String cnpj, String uf, String cidade,
			String rua, String bairro, Integer numero, String telefone,
			String nomeproprietario) {
		super();
		this.idImobiliaria = idimobiliaria;
		this.razaoSocial = razaosocial;
		this.nomeFantasia = nomefantasia;
		this.cnpj = cnpj;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.telefone = telefone;
		this.nomeProprietario = nomeproprietario;
	}
}