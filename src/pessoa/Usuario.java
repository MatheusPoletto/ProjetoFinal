package pessoa;

public class Usuario {
	private Integer idUsuario;
	private String login;
	private String senha;
	private Corretor corretor;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	
	public Usuario(Integer idUsuario, String login, String senha, Corretor corretor) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.corretor = corretor;
	}
	
	public Usuario() {
		super();
	}
}
