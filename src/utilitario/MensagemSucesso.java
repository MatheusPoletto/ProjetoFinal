package utilitario;

import javax.swing.JOptionPane;

public class MensagemSucesso {

	public void sucessoCadastrarCorretor(){
		JOptionPane.showMessageDialog(null, 
				"Corretor cadastrado com sucesso!", 
				"Sucesso!",
				JOptionPane.PLAIN_MESSAGE);
	}
	
	public void sucessoCadastrarCliente(){
		JOptionPane.showMessageDialog(null, 
				"Cliente cadastrado com sucesso!", 
				"Sucesso!",
				JOptionPane.PLAIN_MESSAGE);
	}
	
	
}
