package pessoa;

import java.util.ArrayList;

public class Cliente {
	private Pessoa pessoa;
	private Integer idCliente;
	private ArrayList<Interesse> interesses;
	
	public Cliente(){
		super();
	}

	public Cliente(Pessoa pessoa, Integer idCliente) {
		super();
		this.pessoa = pessoa;
		this.idCliente = idCliente;

		
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

	public ArrayList<Interesse> getInteresses() {
		return interesses;
	}
	public void setInteresses(ArrayList<Interesse> interesses) {
		this.interesses = interesses;
	}
}
