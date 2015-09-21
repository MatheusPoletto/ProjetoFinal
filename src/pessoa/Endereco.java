package pessoa;

public class Endereco {

	
	private String uf;
	private String cidade;
	private String rua;
	private String bairro;
	private Integer numero;
	
	
	
	
	public Endereco(){} 
	
	
	
	
	
	
	
	
	public Endereco(String uf, String cidade, String rua, String bairro,
			Integer numero) {
		super();
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
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
	
	
	
	
	
}
