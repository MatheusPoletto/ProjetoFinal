package model;

import java.time.LocalDate;

import imovel.Imovel;
import pessoa.Cliente;
import pessoa.Corretor;

public class Historico {
	private Integer idhistorico;
	private LocalDate data;
	private Imovel imovel;
	private Cliente cliente;
	private Corretor corretor;
	
	public Historico(Integer idhistorico, LocalDate data, Imovel imovel, Cliente cliente, Corretor corretor) {
		super();
		this.idhistorico = idhistorico;
		this.data = data;
		this.imovel = imovel;
		this.cliente = cliente;
		this.corretor = corretor;
	}

	public Integer getIdhistorico() {
		return idhistorico;
	}

	public void setIdhistorico(Integer idhistorico) {
		this.idhistorico = idhistorico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
