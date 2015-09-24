package pessoa;

public class Corretor {
	private Pessoa pessoa;
	private Integer idCorretor;
	private Double salario;
	private Double porcentagemComissao;
	
	// teste de metodo para calcular o salario
	public Double calculaSalario(Double valor){
		salario = salario + (0.6 * valor);
		return salario;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao(Double porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public Integer getIdCorretor() {
		return idCorretor;
	}

	public void setIdCorretor(Integer idcorretor) {
		this.idCorretor = idcorretor;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Corretor(){

	}
	
	public Corretor(Integer idCorretor, Double salario, Double porcentagemComissao) {
		super();
		this.idCorretor = idCorretor;
		this.salario = salario;
		this.porcentagemComissao = porcentagemComissao;
	}
}