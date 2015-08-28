package model;

public class Aluguel extends TipoOcorrencia{
	


	private Integer idaluguel;
	
	private Double valormensal;
	private String formadepagamento;
	

	
	//teste herança
	

	
	
	


	public Aluguel(Corretor corretor, Imovel imovel, Integer idaluguel,
			Double valormensal, String formadepagamento) {
		super(corretor, imovel);
		this.idaluguel = idaluguel;
		this.valormensal = valormensal;
		this.formadepagamento = formadepagamento;
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
	


	
	
	
	
	

}
