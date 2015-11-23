package pessoa;

public class Corretor {
	private Pessoa pessoa;
	private Integer idCorretor;
	private Double salario;

	
	// teste de metodo para calcular o salario
	public Double calculaSalario(Double valor){
		salario = salario + (0.6 * valor);
		return salario;
	}
	
	public Corretor(){

	}
	
	
	public Corretor(Pessoa pessoa, Integer idCorretor, Double salario) {
		super();
		this.pessoa = pessoa;
		this.idCorretor = idCorretor;
		this.salario = salario;
	}




	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
}