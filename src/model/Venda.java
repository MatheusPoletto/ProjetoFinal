package model;

public class Venda {
	private Integer idCompra;
	private Double valor;
	private String formaDePagamento;	
	private Corretor corretor;
	private Cliente cliente;
	
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idcompra) {
		this.idCompra = idcompra;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setformaDePagamento(String formadepagamento) {
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
	
	public Venda(){
		
	}
	
	public Venda(Integer idcompra, Double valor, String formadepagamento,
			Corretor corretor, Cliente cliente) {
		super();
		this.idCompra = idcompra;
		this.valor = valor;
		this.formaDePagamento = formadepagamento;
		this.corretor = corretor;
		this.cliente = cliente;
	}
}