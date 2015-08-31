package model;

public class Cliente {
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String rg;
	private String uf;
	private String cidade;
	private String rua;
	private String bairro;
	private Integer numero;
	private Double salario;
	private String telefone;
	private String interesses;
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idcliente) {
		this.idCliente = idcliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getInteresses() {
		return interesses;
	}
	
	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}
	
	public Cliente(){
		
	}
	
	public Cliente(Integer idcliente, String nome, String cpf, String rg,
			String uf, String cidade, String rua, String bairro,
			Integer numero, Double salario, String telefone, String interesses) {
		super();
		this.idCliente = idcliente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.salario = salario;
		this.telefone = telefone;
		this.interesses = interesses;
	}
}
