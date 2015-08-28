package model;

public class Venda extends TipoOcorrencia{
	
	private Integer idcompra;
	private Double valor;
	private String formadepagamento;
	

	
//teste herança
	
	


	public Venda(Corretor corretor, Imovel imovel, Integer idcompra,
			Double valor, String formadepagamento) {
		super(corretor, imovel);
		this.idcompra = idcompra;
		this.valor = valor;
		this.formadepagamento = formadepagamento;
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



















	
	
	

}
