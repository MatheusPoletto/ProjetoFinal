package imovel;

import pessoa.Cliente;
import pessoa.Endereco;
import pessoa.Pessoa;


public class Imovel {
	private Integer idImovel;
	private String metrosquadrados; 
	private Double valorTotal;
	private Double valorMensal;
	private Integer mesesContrato;
	private Endereco endereco; 
	private Cliente cliente; 
	
	
	
	
	public Integer getIdImovel() {
		return idImovel;
	}
	
	public void setIdImovel(Integer idimovel) {
		this.idImovel = idimovel;
	}
	

	public String getMetrosquadrados() {
		return metrosquadrados;
	}

	public void setMetrosquadrados(String metrosquadrados) {
		this.metrosquadrados = metrosquadrados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

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

	public Imovel(Integer idImovel, String metrosquadrados, Double valorTotal, Double valorMensal,
			Integer mesesContrato, Endereco endereco, Cliente cliente) {
		super();
		this.idImovel = idImovel;
		this.metrosquadrados = metrosquadrados;
		this.valorTotal = valorTotal;
		this.valorMensal = valorMensal;
		this.mesesContrato = mesesContrato;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	public Imovel() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
}
