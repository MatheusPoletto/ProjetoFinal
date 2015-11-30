package pessoa;

public class Usuario {
	private Integer idUsuario;
	private String login;
	private String senha;
	private Integer nivelAcesso; // nível = 1 (corretor) = 2 (gestor)
	private Corretor corretor;

	public Usuario(Integer idUsuario, String login, String senha, Corretor corretor, Integer nivelAcesso) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.corretor = corretor;
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario() {
		super();
	}

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

	public Integer getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Integer nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

}
