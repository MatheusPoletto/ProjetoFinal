package utilitario;

import javax.swing.JOptionPane;

public class MensagemAjuda {

	public void ajudaCadastroClienteInteresses(){
		JOptionPane.showMessageDialog(null,
				"Sempre que adicionar um novo cliente, voc� pode atribuir 3 interesses a ele.\nEsses interesses definem o que seu cliente procura nos im�veis.\nPor exemplo: barato, grande, mans�o.\nN�O � OBRIGAT�RIO!",
				"Ajuda", 
				JOptionPane.PLAIN_MESSAGE);
	}
	
	public void ajudaCadastroImovelDescricoes(){
		JOptionPane.showMessageDialog(null,
				"Sempre que adicionar um im�vel, voc� pode atribuir 3 descri��es a ele.\nEssas descri��es definem o que seu im�vel possui.\nPor exemplo: Luxo, Imobiliado, Confort�vel.\nN�O � OBRIGAT�RIO!",
				"Ajuda", 
				JOptionPane.PLAIN_MESSAGE);
	}
	
}
