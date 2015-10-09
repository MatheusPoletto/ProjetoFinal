package pessoa;


public class AnuncianteImovel {
	private Pessoa pessoa;
	private Endereco endereço; 
	private String idanuncianteImovel; 
	//aqui tinha o telefone, resolvemos tirar poque na quase pessoa já existe um telefone. 
	
	
	
	public AnuncianteImovel(){
		
		
	}
	
	
	
	
	
	
	
	
	public AnuncianteImovel(Pessoa pessoa, Endereco endereço,
			String idanuncianteImovel, String telefone) {
		super();
		this.pessoa = pessoa;
		this.endereço = endereço;
		this.idanuncianteImovel = idanuncianteImovel;
	
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Endereco getEndereço() {
		return endereço;
	}
	public void setEndereço(Endereco endereço) {
		this.endereço = endereço;
	}
	public String getIdanuncianteImovel() {
		return idanuncianteImovel;
	}
	public void setIdanuncianteImovel(String idanuncianteImovel) {
		this.idanuncianteImovel = idanuncianteImovel;
	}

	
	
	
	
	
}
