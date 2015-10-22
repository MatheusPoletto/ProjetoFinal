package imovel;

import pessoa.Cliente;
import pessoa.Endereco;

public class Aluguel extends Imovel{
	private Double valorMensal;
	private Integer mesesContrato;
	// nossso cerebro travou aqui, tirar duvidas. // nossso cerebro travou aqui, tirar duvidas. 
	
	public Double getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}
	public Integer getMesesContrato() {
		return mesesContrato;
	}
	public void setMesesContrato(Integer mesesContrato) {
		this.mesesContrato = mesesContrato;
	}
	
	public Aluguel(Integer idImovel, Endereco endereco, String metrosquadrados, Cliente cliente, Double valorMensal,
			Integer mesesContrato) {
		super(idImovel, endereco, metrosquadrados, cliente);
		this.valorMensal = valorMensal;
		this.mesesContrato = mesesContrato;
	}
}
