package model;

public class Corretor {
	
	private Integer idcorretor;
	private String nomecorretor;
	private String cpf;
	private String rg;
	private String uf;
	private String cidade;
	private String rua;
	private Integer numero;
	private Double salario;
	private Double comissão;
	private String telefone;
	
	// private Imobiliaria Imobiliaria; ?????
	
	
	
	public Corretor(){
		
		//Construtor vazio
	}
	
	
	
	
	public Corretor(Integer idcorretor, String nomecorretor, String cpf, String rg,
			String uf, String cidade, String rua, Integer numero,
			Double salario, Double comissão, String telefone) {
		//construtor com atributos 
		super();
		this.idcorretor = idcorretor;
		this.nomecorretor = nomecorretor;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.salario = salario;
		this.comissão = comissão;
		this.telefone = telefone;
	}
	
	public Integer getIdcorretor() {
		return idcorretor;
	}

	public void setIdcorretor(Integer idcorretor) {
		this.idcorretor = idcorretor;
	}
	
	public String getNomecorretor() {
		return nomecorretor;
	}
	
	public void setNomecorretor(String nomecorretor) {
		this.nomecorretor = nomecorretor;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
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
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Double getComissão() {
		return comissão;
	}
	
	public void setComissão(Double comissão) {
		this.comissão = comissão;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	// teste de metodo para calcular o salario. 
	
	public Double calculaSalario(Double valor){

		salario = salario + (0.6 * valor);
		return salario;
	}
	
	
	
	
	
	
	

}
