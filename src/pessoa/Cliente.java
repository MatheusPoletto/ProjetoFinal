package pessoa;

public class Cliente {
	private Pessoa pessoa;
	private Integer idCliente;
	private String interesse1;
	private String interesse2;
	private String interesse3;

	public Cliente(Pessoa pessoa, Integer idCliente) {
		super();
		this.pessoa = pessoa;
		this.idCliente = idCliente;
	}

	public Cliente() {
		super();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getInteresse1() {
		return interesse1;
	}

	public void setInteresse1(String interesse1) {
		this.interesse1 = interesse1;
	}

	public String getInteresse2() {
		return interesse2;
	}

	public void setInteresse2(String interesse2) {
		this.interesse2 = interesse2;
	}

	public String getInteresse3() {
		return interesse3;
	}

	public void setInteresse3(String interesse3) {
		this.interesse3 = interesse3;
	}

}
