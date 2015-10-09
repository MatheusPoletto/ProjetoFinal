package pessoa;


public class AnuncianteImovel {
	private Pessoa pessoa;
	private Endereco endereço; 
	private String idanuncianteImovel; 
	private String telefone;
	
	
	
	public AnuncianteImovel(){
		
		
	}
	
	
	
	
	
	
	
	
	public AnuncianteImovel(Pessoa pessoa, Endereco endereço,
			String idanuncianteImovel, String telefone) {
		super();
		this.pessoa = pessoa;
		this.endereço = endereço;
		this.idanuncianteImovel = idanuncianteImovel;
		this.telefone = telefone;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	} 
	
	
	
	
	
}
