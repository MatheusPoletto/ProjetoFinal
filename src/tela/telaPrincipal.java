package tela;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class telaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private telaLogin tlLogin = new telaLogin();
	private static telaPrincipal tlPrincipal = new telaPrincipal();
	private JMenu jmnImovel, jmnCadastro, jmnPessoa;
	private JMenuItem jmiAlugar, jmiVender, jmiCliente, jmiCorretor;
	
	telaPrincipal(){		
		setTitle("M&M Sistema Imobiliário");
		setLayout(null);
		
		getContentPane().add(tlLogin);
		tlLogin.setVisible(true);
		
		barra = new JMenuBar();
		barra.setVisible(false);
		
		jmnCadastro = new JMenu("Cadastro");
		
		jmnImovel = new JMenu("Imóvel");
		jmnCadastro.add(jmnImovel);
		jmiAlugar = new JMenuItem("Alugar");
		jmiVender = new JMenuItem("Vender");
		jmnImovel.add(jmiAlugar);
		jmnImovel.addSeparator();
		jmnImovel.add(jmiVender);
		
		jmnCadastro.addSeparator();
		
		jmnPessoa = new JMenu("Pessoa");
		jmnCadastro.add(jmnPessoa);
		jmiCliente = new JMenuItem("Cliente");
		jmiCorretor = new JMenuItem("Corretor");
		jmnPessoa.add(jmiCliente);
		jmnPessoa.addSeparator();
		jmnPessoa.add(jmiCorretor);
		
		barra.add(jmnCadastro);
		
		
		getContentPane().setBackground(new Color(181, 181, 181));
		setJMenuBar(barra);
		setSize(900,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void alteraVisibilidade(){
		barra.setVisible(true);
	}
	
	public static void main(String[] args) {
		telaPrincipal.getTlPrincipal();
	}

	public telaLogin getTlLogin() {
		return tlLogin;
	}

	public static telaPrincipal getTlPrincipal() {
		if(tlPrincipal == null){
			tlPrincipal = new telaPrincipal();
		}
		return tlPrincipal;
	}	
}
