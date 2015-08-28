package model;

public class Corretor {
	
	private Integer idcorretor;
	private String nomecorretor;
	private Long cpf;
	private Long rg;
	private String uf;
	private String estado;
	private String rua;
	private Integer numero;
	private Double salario;
	private Double comissão;
	private Long telefone;
	
	// private Imobiliaria Imobiliaria; ?????
	
	
	
	public Corretor(){
		
		//Construtor vazio
	}
	
	
	
	
	public Corretor(Integer idcorretor, String nomecorretor, Long cpf, Long rg,
			String uf, String estado, String rua, Integer numero,
			Double salario, Double comissão, Long telefone) {
		//construtor com atributos 
		super();
		this.idcorretor = idcorretor;
		this.nomecorretor = nomecorretor;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.estado = estado;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
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
	
	public Long getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
	
	

}
