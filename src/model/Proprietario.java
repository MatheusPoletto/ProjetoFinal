package model;

public class Proprietario {
	
	private String nome;
	private Long cpf;
	private Long rg;
	private String contato;
	private Long telefonecontato;
	
	
	
	public Proprietario(){
		
	}
	
	
	public Proprietario(String nome, Long cpf, Long rg, String contato,
			Long telefonecontato) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.contato = contato;
		this.telefonecontato = telefonecontato;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Long getRg() {
		return rg;
	}
	
	public void setRg(Long rg) {
		this.rg = rg;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public Long getTelefonecontato() {
		return telefonecontato;
	}
	
	public void setTelefonecontato(Long telefonecontato) {
		this.telefonecontato = telefonecontato;
	}
	
	
	
	

}
