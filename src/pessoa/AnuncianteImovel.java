package pessoa;


public class AnuncianteImovel {
	private Pessoa pessoa;
	private Endereco endere�o; 
	private String idanuncianteImovel; 
	//aqui tinha o telefone, resolvemos tirar poque na quase pessoa j� existe um telefone. 
	
	
	
	public AnuncianteImovel(){
		
		
	}
	
	
	
	
	
	
	
	
	public AnuncianteImovel(Pessoa pessoa, Endereco endere�o,
			String idanuncianteImovel, String telefone) {
		super();
		this.pessoa = pessoa;
		this.endere�o = endere�o;
		this.idanuncianteImovel = idanuncianteImovel;
	
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Endereco getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(Endereco endere�o) {
		this.endere�o = endere�o;
	}
	public String getIdanuncianteImovel() {
		return idanuncianteImovel;
	}
	public void setIdanuncianteImovel(String idanuncianteImovel) {
		this.idanuncianteImovel = idanuncianteImovel;
	}

	
	
	
	
	
}
