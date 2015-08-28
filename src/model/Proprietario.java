package model;

public class Proprietario {
	
	private String nome;
	private Long cpf;
	private Long rg;
	private String contato;
	private String telefonecontato;
	
	
	
	public Proprietario(){
		
	}
	
	
	public Proprietario(String nome, Long cpf, Long rg, String contato,
			String telefonecontato) {
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
	
	public String getTelefonecontato() {
		return telefonecontato;
	}
	
	public void setTelefonecontato(String telefonecontato) {
		this.telefonecontato = telefonecontato;
	}
	
	
	
	

}
