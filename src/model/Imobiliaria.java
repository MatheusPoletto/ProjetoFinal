package model;

public class Imobiliaria  {
	
	// diario de bordo dia 28/08/2015, depois de muito sofrimento, consigo escrever estas
	// linhas, creio que estou entrando em um planeta desconhecido 
	// apagar isto depois (AVA) 
	
	private Integer idimobiliaria;
	private String razaosocial;
	private String nomefantasia;
	private String cnpj;
	// não é melhor fazer uma classe endereço ai chama o endereço ? 
	private String uf; 
	private String cidade;
	private String rua;
	private String bairro;
	private Integer numero; 
	private String telefone;
	private String nomeproprietario;
	
	
	public Imobiliaria(){
		
		// construtor vazio
	}
	
	
	public Imobiliaria(Integer idimobiliaria, String razaosocial,
			String nomefantasia, String cnpj, String uf, String cidade,
			String rua, String bairro, Integer numero, String telefone,
			String nomeproprietario) {
		
		// construtor com atributos 
		super();
		this.idimobiliaria = idimobiliaria;
		this.razaosocial = razaosocial;
		this.nomefantasia = nomefantasia;
		this.cnpj = cnpj;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.telefone = telefone;
		this.nomeproprietario = nomeproprietario;
	}


	public Integer getIdimobiliaria() {
		return idimobiliaria;
	}


	public void setIdimobiliaria(Integer idimobiliaria) {
		this.idimobiliaria = idimobiliaria;
	}


	public String getRazaosocial() {
		return razaosocial;
	}


	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}


	public String getNomefantasia() {
		return nomefantasia;
	}


	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
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


	public String getNomeproprietario() {
		return nomeproprietario;
	}


	public void setNomeproprietario(String nomeproprietario) {
		this.nomeproprietario = nomeproprietario;
	}
	
	
	
	
	

	
	
	

}
