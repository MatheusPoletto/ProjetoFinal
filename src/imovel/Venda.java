package imovel;

import pessoa.Cliente;
import pessoa.Endereco;

public class Venda extends Imovel {
	private Double valorTotal;
	
	// nossso cerebro travou aqui, tirar duvidas. 
	

	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda(Integer idImovel, Endereco endereco, String metrosquadrados, Cliente cliente, Double valorTotal) {
		super(idImovel, endereco, metrosquadrados, cliente);
		this.valorTotal = valorTotal;
	}

	
	
	

	
	
}
