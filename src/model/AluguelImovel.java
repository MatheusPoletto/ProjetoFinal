package model;

import java.time.LocalDate;

import imovel.Imovel;
import pessoa.Cliente;

public class AluguelImovel extends Historico {

	public AluguelImovel(Integer idhistorico, LocalDate data, Imovel imovel, Cliente cliente) {
		super(idhistorico, data, imovel, cliente);
		// TODO Auto-generated constructor stub
	}

}
