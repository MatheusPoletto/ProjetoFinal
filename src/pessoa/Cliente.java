package pessoa;

import java.util.ArrayList;

public class Cliente {
	private Pessoa pessoa;
	private Integer idCliente;
	private Double salario;
	
	//String ou arraylist?
	private ArrayList<String> interesses;
	//aqui tinha o telefone, resolvemos tirar poque na quase pessoa já existe um telefone. 
	
	
	public Cliente(){
		
	}
	
	
	
	
	public Cliente(Pessoa pessoa, Integer idCliente, Double salario,
			ArrayList<String> interesses) {
		super();
		this.pessoa = pessoa;
		this.idCliente = idCliente;
		this.salario = salario;
		
		this.interesses = interesses;
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
	

	public ArrayList<String> getInteresses() {
		return interesses;
	}
	public void setInteresses(ArrayList<String> interesses) {
		this.interesses = interesses;
	}
}
