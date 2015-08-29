package model;

public class Venda {
	
	private Integer idcompra;
	private Double valor;
	private String formadepagamento;
			
	private Corretor corretor;
	private Cliente cliente;
	
	
	
	public Venda(){
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public Venda(Integer idcompra, Double valor, String formadepagamento,
			Corretor corretor, Cliente cliente) {
		super();
		this.idcompra = idcompra;
		this.valor = valor;
		this.formadepagamento = formadepagamento;
		this.corretor = corretor;
		this.cliente = cliente;
	}
	public Integer getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(Integer idcompra) {
		this.idcompra = idcompra;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
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

	
	

