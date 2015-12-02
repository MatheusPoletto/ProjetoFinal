package exception;

public class ErroInserirBanco extends Exception {

	private static final long serialVersionUID = 2173945334030239919L;

	
	public ErroInserirBanco(String message) {
		super(message);
	}
	
	public String getMensagemAmigavel() {
		String msg = "";
		if (getMessage() != null) {
			if (getMessage().contains("Duplicate")) {
				msg = "Registro já existente";
			}
		}
		return msg;
	}
}
