package pessoa;

import java.time.LocalDate;

public class Pessoa {
	private Integer id;
	// id não é auto incremento? 
	private String nome;
	private String rg;
	private String cpf;
	private Integer estadoCivil;
	//usamos um combobox que retorna um inteiro, 0 solteiro, 1 casado, 2 Divorciado, 3 viuvo, 4 separado
	private Integer genero;
	//outro combobox que retorna 0 para masculino e 1 para feminino
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String Telefone;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Integer getGenero() {
		return genero;
	}
	public void setGenero(Integer genero) {
		this.genero = genero;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	} 
	
	
	
	
	
	
}
