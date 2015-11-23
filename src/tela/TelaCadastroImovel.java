package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TelaCadastroImovel extends JFrame{

	private JLabel jlbTitulo;
	
	private JPanel jpnLocalizador;
	private CriarCamponentes cp = new CriarCamponentes();
	
	public TelaCadastroImovel() {
		setTitle("Alterar pessoa");
		setLayout(null);

		jlbTitulo = new JLabel("CADASTRO DE IMÓVEL", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		jpnLocalizador = cp.criarPanel("Localizador", 10, 50, 470, 80, jpnLocalizador, true);
		jpnLocalizador.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 1), 1, true));
		getContentPane().add(jpnLocalizador);

		setResizable(false);
		setSize(650, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaCadastroImovel();
	}
}
