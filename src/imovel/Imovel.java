package imovel;

import pessoa.Proprietario;

public class Imovel {
	private Integer idImovel;
	private String rua;
	private Integer numero;
	private String cidade;
	private String bairro;
	private String uf;
	private Proprietario proprietario;
	private Boolean isAlugar;
	
	private void isAlugar(){
		if(isAlugar == true){
			
		}
	}
	
	public Integer getIdImovel() {
		return idImovel;
	}
	
	public void setIdImovel(Integer idimovel) {
		this.idImovel = idimovel;
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

	public Boolean getIsAlugar() {
		return isAlugar;
	}

	public void setIsAlugar(Boolean isAlugar) {
		this.isAlugar = isAlugar;
	}

	public Imovel(){
		
	}
	
	public Imovel(Integer idimovel, String uf, String cidade, String bairro,
			String rua, Integer numero, Proprietario proprietario) {
		super();
		this.idImovel = idimovel;
		this.proprietario = proprietario;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.uf = uf;
	}	
}
