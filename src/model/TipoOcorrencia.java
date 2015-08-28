package model;

public class TipoOcorrencia {
	
	//teste herança
	
	private Corretor corretor;
	private Imovel imovel;
	


	public TipoOcorrencia(Corretor corretor, Imovel imovel) {
		super();
		this.corretor = corretor;
		this.imovel = imovel;
		
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}


	
	

}
