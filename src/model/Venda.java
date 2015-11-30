package model;

import imovel.Imovel;
import pessoa.Cliente;
import pessoa.Corretor;

public class Venda {
	private Integer idhistorico;
	private String data;
	private Double comissaoImobiliaria;
	private Double comissaoCorretor;
	private Imovel imovel;
	private Cliente cliente;
	private Corretor corretor;

	public Venda(Integer idhistorico, String data, Double comissaoImobiliaria, Double comissaoCorretor, Imovel imovel,
			Cliente cliente, Corretor corretor) {
		super();
		this.idhistorico = idhistorico;
		this.data = data;
		this.comissaoImobiliaria = comissaoImobiliaria;
		this.comissaoCorretor = comissaoCorretor;
		this.imovel = imovel;
		this.cliente = cliente;
		this.corretor = corretor;
	}

	public Venda() {
		super();
	}

	public Integer getIdhistorico() {
		return idhistorico;
	}

	public void setIdhistorico(Integer idhistorico) {
		this.idhistorico = idhistorico;
	}

	public String getData() {
		return data;
	}

	public void setData(String date) {
		this.data = date;
	}

	public Double getComissaoImobiliaria() {
		return comissaoImobiliaria;
	}

	public void setComissaoImobiliaria(Double comissaoImobiliaria) {
		this.comissaoImobiliaria = comissaoImobiliaria;
	}

	public Double getComissaoCorretor() {
		return comissaoCorretor;
	}

	public void setComissaoCorretor(Double comissaoCorretor) {
		this.comissaoCorretor = comissaoCorretor;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

}
