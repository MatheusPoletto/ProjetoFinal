package pessoa;


public class AnuncianteImovel {
	private Pessoa pessoa;
	private Endereco endere�o; 
	private String idanuncianteImovel; 
	private String telefone;
	
	
	
	public AnuncianteImovel(){
		
		
	}
	
	
	
	
	
	
	
	
	public AnuncianteImovel(Pessoa pessoa, Endereco endere�o,
			String idanuncianteImovel, String telefone) {
		super();
		this.pessoa = pessoa;
		this.endere�o = endere�o;
		this.idanuncianteImovel = idanuncianteImovel;
		this.telefone = telefone;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	} 
	
	
	
	
	
}
