package model;

import java.time.LocalDate;

import imovel.Imovel;
import pessoa.Cliente;

public class Historico {
	private Integer idhistorico;
	private LocalDate data;
	private Imovel imovel;
	private Cliente cliente;
	
	public Historico(Integer idhistorico, LocalDate data, Imovel imovel, Cliente cliente) {
		super();
		this.idhistorico = idhistorico;
		this.data = data;
		this.imovel = imovel;
		this.cliente = cliente;
	}
	
	
}
