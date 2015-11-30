package model;

public class NotaFiscal {
	private Integer idNotaFiscal;
	private String dataEmissao;
	private Double valorTotal;
	private Imobiliaria imobiliaria;
	private Venda venda;

	public NotaFiscal(Integer idNotaFiscal, String dataEmissao, Double valorTotal, Imobiliaria imobiliaria,
			Venda venda) {
		super();
		this.idNotaFiscal = idNotaFiscal;
		this.dataEmissao = dataEmissao;
		this.valorTotal = valorTotal;
		this.imobiliaria = imobiliaria;
		this.venda = venda;
	}

	public NotaFiscal() {
		super();
	}

	public Integer getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Integer idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Imobiliaria getImobiliaria() {
		return imobiliaria;
	}

	public void setImobiliaria(Imobiliaria imobiliaria) {
		this.imobiliaria = imobiliaria;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
