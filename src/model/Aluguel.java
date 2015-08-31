package model;

public class Aluguel{
	private Integer idAluguel;
	private Double valorMensal;
	private String formaDePagamento;
	private Corretor corretor;
	private Cliente cliente;
	
	public Integer getIdAluguel() {
		return idAluguel;
	}
	
	public void setIdAluguel(Integer idaluguel) {
		this.idAluguel = idaluguel;
	}
	
	public Double getValorMensal() {
		return valorMensal;
	}
	
	public void setValorMensal(Double valormensal) {
		this.valorMensal = valormensal;
	}
	
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	
	public void setFormaDePagamento(String formadepagamento) {
		this.formaDePagamento = formadepagamento;
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
	
	public Aluguel(Integer idaluguel, Double valormensal,
			String formadepagamento, Corretor corretor, Cliente cliente) {
		super();
		this.idAluguel = idaluguel;
		this.valorMensal = valormensal;
		this.formaDePagamento = formadepagamento;
		this.corretor = corretor;
		this.cliente = cliente;
	}
}
