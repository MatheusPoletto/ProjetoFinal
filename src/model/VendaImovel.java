package model;

import java.time.LocalDate;

import imovel.Imovel;
import pessoa.Cliente;
import pessoa.Corretor;

public class VendaImovel extends Historico {

	
	public VendaImovel(Integer idhistorico, LocalDate data, Imovel imovel, Cliente cliente, Corretor corretor) {
		super(idhistorico, data, imovel, cliente, corretor);
		// TODO Auto-generated constructor stub
	}

	
	
}
