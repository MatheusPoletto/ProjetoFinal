package utilitario;

import javax.swing.JOptionPane;

	public class MensagemErro {
		
	//erros de cadastro
	protected void erroCadastrarCliente(){
		JOptionPane.showMessageDialog(null,
				"Os campos de NOME, RG E CPF s�o obrigatorios! Preencha-os corretamente e tente novamente.",
				"Campo(os) em branco", 
				JOptionPane.ERROR_MESSAGE);
	}
	protected void erroCadastrarCorretor(){
		JOptionPane.showMessageDialog(null,
				"Todos os campos s�o obrigat�rios! Preencha-os e tente novamente.",
				"Campo(os) em branco", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	protected void erroCadastroImovel(){
		JOptionPane.showMessageDialog(null,
				"Todos os campos do painel 'Principal' s�o obrigat�rios! Preencha-os e tente novamente.",
				"Campo(os) em branco", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
	//erro de file chooser
	protected void erroFormatoJpg(){
		JOptionPane.showMessageDialog(null, 
				"Permitido somente imagens com extens�o .jpg!", 
				"Aviso!", 
				JOptionPane.WARNING_MESSAGE);
	}
	
}
