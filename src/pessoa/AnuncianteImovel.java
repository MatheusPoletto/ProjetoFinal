package pessoa;


public class AnuncianteImovel {
	private Pessoa pessoa;
	private Endereco enderešo; 
	private String idanuncianteImovel; 
	private String telefone;
	
	
	
	public AnuncianteImovel(){
		
		
	}
	
	
	
	
	
	
	
	
	public AnuncianteImovel(Pessoa pessoa, Endereco enderešo,
			String idanuncianteImovel, String telefone) {
		super();
		this.pessoa = pessoa;
		this.enderešo = enderešo;
		this.idanuncianteImovel = idanuncianteImovel;
		this.telefone = telefone;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Endereco getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(Endereco enderešo) {
		this.enderešo = enderešo;
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
