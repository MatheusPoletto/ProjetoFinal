package model;

public class Cliente {
	
	private Integer idcliente;
	private String nome;
	private Long cpf;
	private Long rg;
	private String uf;
	private String cidade;
	private String rua;
	private String bairro;
	private Integer numero;
	private Double salario;
	private Long telefone;
	private String interesses;
	
	
	public Cliente(){
		
		
	}
	
	public Cliente(Integer idcliente, String nome, Long cpf, Long rg,
			String uf, String cidade, String rua, String bairro,
			Integer numero, Double salario, Long telefone, String interesses) {
		super();
		this.idcliente = idcliente;
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


	public Integer getIdcliente() {
		return idcliente;
	}
	
	
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Long getRg() {
		return rg;
	}
	
	public void setRg(Long rg) {
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
	
	public Long getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	public String getInteresses() {
		return interesses;
	}
	
	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}
	
	
	

}
