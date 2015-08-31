package model;

public class Proprietario {
	
	private String nome;
	private String cpf;
	private String rg;
	private String emailContato;
	private String telefoneContato;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEmailContato() {
		return emailContato;
	}
	
	public void setEmailContato(String contato) {
		this.emailContato = contato;
	}
	
	public String getTelefoneContato() {
		return telefoneContato;
	}
	
	public void setTelefoneContato(String telefonecontato) {
		this.telefoneContato = telefonecontato;
	}
	
	public Proprietario(){
		
	}
	
	public Proprietario(String nome, String cpf, String rg, String emailContato,
			String telefonecontato) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.emailContato = emailContato;
		this.telefoneContato = telefonecontato;
	}
}