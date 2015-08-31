package pessoa;

public class Corretor {
	private Integer idCorretor;
	private String nomeCorretor;
	private String cpf;
	private String rg;
	private String uf;
	private String cidade;
	private String rua;
	private Integer numero;
	private Double salario;
	private Double comiss�o;
	private String telefone;
	// private Imobiliaria Imobiliaria; ?????
	
	// teste de metodo para calcular o salario
	public Double calculaSalario(Double valor){
		salario = salario + (0.6 * valor);
		return salario;
	}
	
	public Integer getIdCorretor() {
		return idCorretor;
	}

	public void setIdCorretor(Integer idcorretor) {
		this.idCorretor = idcorretor;
	}
	
	public String getNomeCorretor() {
		return nomeCorretor;
	}
	
	public void setNomeCorretor(String nomecorretor) {
		this.nomeCorretor = nomecorretor;
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
	
	public Double getComiss�o() {
		return comiss�o;
	}
	
	public void setComiss�o(Double comiss�o) {
		this.comiss�o = comiss�o;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Corretor(){

	}
	
	public Corretor(Integer idcorretor, String nomecorretor, String cpf, String rg,
			String uf, String cidade, String rua, Integer numero,
			Double salario, Double comiss�o, String telefone) {
		super();
		this.idCorretor = idcorretor;
		this.nomeCorretor = nomecorretor;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.salario = salario;
		this.comiss�o = comiss�o;
		this.telefone = telefone;
	}
}