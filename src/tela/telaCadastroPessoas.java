package tela;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class telaCadastroPessoas extends JFrame {
	private JRadioButton rbtCliente, rbtCorretor, rbtAnunciante;
	private ButtonGroup btnCadastro;
	
	public telaCadastroPessoas() {
		setTitle("Cadastrar pessoa");
		setLayout(null);	
		
		rbtAnunciante = new JRadioButton("Anunciante");
		rbtAnunciante.setBounds(0, 0, 130, 30);
		rbtAnunciante.setVisible(true);
		getContentPane().add(rbtAnunciante);
		
		rbtCorretor = new JRadioButton("Corretor");
		rbtCorretor.setBounds(130, 0, 130, 30);
		rbtCorretor.setVisible(true);
		getContentPane().add(rbtCorretor);
		
		rbtCliente = new JRadioButton("Cliente");
		rbtCliente.setBounds(260, 0, 130, 30);
		rbtCliente.setVisible(true);
		getContentPane().add(rbtCliente);
		
		btnCadastro = new ButtonGroup();
		btnCadastro.add(rbtAnunciante);
		btnCadastro.add(rbtCorretor);
		btnCadastro.add(rbtCliente);
		
		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new telaCadastroPessoas();
	}

}
