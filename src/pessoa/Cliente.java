package pessoa;

public class Cliente {
	private Pessoa pessoa;
	private Integer idCliente;
	private Double salario;
	
	//String ou arraylist?
	private String interesses;
	private Endereco endereco;
	//aqui tinha o telefone, resolvemos tirar poque na quase pessoa já existe um telefone. 
	
	
	public Cliente(){
		
	}
	
	
	
	
	public Cliente(Pessoa pessoa, Integer idCliente, Double salario,
			String interesses, Endereco endereco) {
		super();
		this.pessoa = pessoa;
		this.idCliente = idCliente;
		this.salario = salario;
		
		this.interesses = interesses;
		this.endereco = endereco;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	

	public String getInteresses() {
		return interesses;
	}
	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
