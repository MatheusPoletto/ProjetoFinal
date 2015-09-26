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
	
	
	
}
