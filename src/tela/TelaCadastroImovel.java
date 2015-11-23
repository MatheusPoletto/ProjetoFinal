package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TelaCadastroImovel extends JFrame{

	private JLabel jlbTitulo;
	
	private JPanel jpnLocalizador, jpnTab1;
	private JLabel jlbNovo, jlbRG, jlbNome, jlbCpf;
	private JButton jbtProcurar, jbtNovo;
	private JTextField jtfRg, jtfNome, jtfCpf;
	private JTabbedPane jtbPrincipal;
	
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
				
		jlbNovo = cp.criarLabel("CADASTRAR:", 20, 20, 105, 24, jlbNovo);
		jlbRG = cp.criarLabel("OU PESQUISAR POR RG:", 220, 20, 150, 24, jlbRG);
		jlbNome = cp.criarLabel("NOME:", 20, 50, 50, 24, jlbNome);
		jlbCpf = cp.criarLabel("CPF:", 330, 50, 50, 24, jlbCpf);			
		
		jtfRg = cp.criarTextField(370, 20, 100, 24, jtfRg);
		jtfNome = cp.criarTextField(65, 50, 250, 24, jtfNome);
		jtfCpf = cp.criarTextField(360, 50, 150, 24, jtfCpf);
		
		jbtProcurar = cp.criarBotao("LOCALIZAR", 500, 20, 100, 24, jbtProcurar);
		jbtNovo = cp.criarBotao("CLIENTE", 100, 20, 105, 24, jbtNovo);

		jpnLocalizador = cp.criarPanel("PROPRIETÁRIO", 0, 300, 637, 80, jpnLocalizador, true);
		jpnLocalizador.add(jlbNovo);
		jpnLocalizador.add(jlbRG);
		jpnLocalizador.add(jtfRg);
		jpnLocalizador.add(jbtProcurar);
		jpnLocalizador.add(jbtNovo);
		jpnLocalizador.add(jlbNome);
		jpnLocalizador.add(jtfNome);
		jpnLocalizador.add(jlbCpf);
		jpnLocalizador.add(jtfCpf);
		
		
		jpnTab1 = cp.criarPanel("", 0, 0, 400, 300, jpnTab1, true);
		jpnTab1.add(jpnLocalizador);
		
		jtbPrincipal = new JTabbedPane();
		jtbPrincipal.add("Principal", jpnTab1);
		jtbPrincipal.add("Imagem 1", new JPanel());
		jtbPrincipal.add("Imagem 2", new JPanel());
		jtbPrincipal.add("Imagem 3", new JPanel());
		jtbPrincipal.add("Imagem 4", new JPanel());
		jtbPrincipal.setBounds(0,50,643,420);
		getContentPane().add(jtbPrincipal);


		setResizable(false);
		setSize(650, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaCadastroImovel();
	}
}
