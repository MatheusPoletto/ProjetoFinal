package model;

public class Imovel {

	
	private Integer idimovel;
	private String uf;
	private String cidade;
	private String bairro;
	private String rua;
	private Integer numero;
	private Proprietario proprietario;
	
	
	
	
	public Imovel(){
		
		
	}
	
	
	public Imovel(Integer idimovel, String uf, String cidade, String bairro,
			String rua, Integer numero, Proprietario proprietario) {
		super();
		this.idimovel = idimovel;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.proprietario = proprietario;
	}

	public Integer getIdimovel() {
		return idimovel;
	}
	
	public void setIdimovel(Integer idimovel) {
		this.idimovel = idimovel;
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
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
	
	
	
	
	
	
	
}
