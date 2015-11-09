package tela;

import javax.swing.JFrame;
public class TelaProcurarCliente extends JFrame {

	public TelaProcurarCliente() {
		setTitle("Cadastrar imóvel");
		setLayout(null);
		
		setResizable(false);
		setSize(707, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaProcurarCliente();
	}
	
}
