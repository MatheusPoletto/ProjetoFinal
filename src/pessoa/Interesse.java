package pessoa;

public class Interesse {
	private Integer idInteresse;
	private String descricao;
	private Cliente cliente;
	
	public Integer getIdInteresse() {
		return idInteresse;
	}
	public void setIdInteresse(Integer idInteresse) {
		this.idInteresse = idInteresse;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Interesse(Integer idInteresse, String descricao, Cliente cliente) {
		super();
		this.idInteresse = idInteresse;
		this.descricao = descricao;
		this.cliente = cliente;
	}
	public Interesse() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
