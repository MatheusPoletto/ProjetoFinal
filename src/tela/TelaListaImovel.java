package tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaListaImovel extends JFrame {

	private JLabel jlbTitulo;
	private CriarCamponentes cp = new CriarCamponentes();
	
	private JPanel jpnProcurar;
	
	public TelaListaImovel(){
		setTitle("Meus imóveis");
		setLayout(null);

		jlbTitulo = new JLabel("Meus Imóveis", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 650, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		jpnProcurar = cp.criarPanel("Procurar", 10, 50, 625, 80, jpnProcurar, true);
		getContentPane().add(jpnProcurar);

		setResizable(false);
		setSize(650, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaListaImovel();
	}
	
}
