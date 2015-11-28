package utilitario;

import javax.swing.JOptionPane;

public class MensagemAjuda {

	public void ajudaCadastroClienteInteresses(){
		JOptionPane.showMessageDialog(null,
				"Sempre que adicionar um novo cliente, você pode atribuir 3 interesses a ele.\nEsses interesses definem o que seu cliente procura nos imóveis.\nPor exemplo: barato, grande, mansão.\nNÃO É OBRIGATÓRIO!",
				"Ajuda", 
				JOptionPane.PLAIN_MESSAGE);
	}
	
	public void ajudaCadastroImovelDescricoes(){
		JOptionPane.showMessageDialog(null,
				"Sempre que adicionar um imóvel, você pode atribuir 3 descrições a ele.\nEssas descrições definem o que seu imóvel possui.\nPor exemplo: Luxo, Imobiliado, Confortável.\nNÃO É OBRIGATÓRIO!",
				"Ajuda", 
				JOptionPane.PLAIN_MESSAGE);
	}
	
}
