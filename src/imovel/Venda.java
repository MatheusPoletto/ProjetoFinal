package imovel;

import pessoa.Proprietario;

public class Venda extends Imovel {
	private Double valorTotal;

	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda(Integer idimovel, String uf, String cidade, String bairro, String rua, Integer numero,
			Proprietario proprietario) {
		super(idimovel, uf, cidade, bairro, rua, numero, proprietario);
	}
	
	

	
	
}
