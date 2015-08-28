package model;

public class Aluguel{
	


	private Integer idaluguel;
	
	private Double valormensal;
	private String formadepagamento;
	
	private Corretor corretor;
	private Cliente cliente;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Aluguel(Integer idaluguel, Double valormensal,
			String formadepagamento, Corretor corretor, Cliente cliente) {
		super();
		this.idaluguel = idaluguel;
		this.valormensal = valormensal;
		this.formadepagamento = formadepagamento;
		this.corretor = corretor;
		this.cliente = cliente;
	}
	
	public Integer getIdaluguel() {
		return idaluguel;
	}
	public void setIdaluguel(Integer idaluguel) {
		this.idaluguel = idaluguel;
	}
	public Double getValormensal() {
		return valormensal;
	}
	public void setValormensal(Double valormensal) {
		this.valormensal = valormensal;
	}
	public String getFormadepagamento() {
		return formadepagamento;
	}
	public void setFormadepagamento(String formadepagamento) {
		this.formadepagamento = formadepagamento;
	}
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	

	
	
	


	


	
	
	
	
	

}
