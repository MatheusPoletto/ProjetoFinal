package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAOFactory.DaoFactoryJDBC;
import dao.UsuarioDAO;
import pessoa.Usuario;

public class telaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	//private telaLogin tlLogin = new telaLogin();
	private telaCadastroPessoas tlCadastroPessoa = new telaCadastroPessoas();
	private TelaListaPessoa tlListaPessoas = new TelaListaPessoa();
	private TelaAlterarPessoa tlAlterarPessoa = new TelaAlterarPessoa();
	private TelaListaUsuario tlListaUsuarios = new TelaListaUsuario();
	private static telaPrincipal tlPrincipal = new telaPrincipal();
	private JMenu jmnImovel, jmnCadastro, jmnProcurar, jmnGerenciamento;
	private JMenuItem jmiAlugar, jmiVender, jmiPessoa, jmiProcurarPessoa, jmiContaUsuario;
	private Usuario usuario;
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private ArrayList<JInternalFrame> frames = new ArrayList<>();
	private JLabel jlbLogo;

	telaPrincipal() {
		setTitle("M&M Sistema Imobiliário");
		setLayout(null);

		criarBarra();

		
		jlbLogo = new JLabel();
		jlbLogo.setBounds(808, 515, 175, 75);
		//jlbLogo.setBounds(808, 0, 175, 75);
		jlbLogo.setVisible(true);
		jlbLogo.setOpaque(true);
		jlbLogo.setIcon(new ImageIcon("img/logo_imo.png"));
		getContentPane().add(jlbLogo);
		
		
		setJMenuBar(barra);
		setSize(1000, 650);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//frames.add(tlLogin);
		frames.add(tlCadastroPessoa);
		frames.add(tlListaPessoas);
		frames.add(tlAlterarPessoa);
		frames.add(tlListaUsuarios);
		posicionaFrames(frames);

		//tlLogin.setVisible(true);

	}

	private void criarBarra() {
		barra = new JMenuBar();
		barra.setVisible(true);

		jmnCadastro = new JMenu("Cadastro");
		jmnImovel = new JMenu("Imóvel");
		jmnCadastro.add(jmnImovel);
		jmiAlugar = new JMenuItem("Alugar");
		jmiVender = new JMenuItem("Vender");
		jmnImovel.add(jmiAlugar);
		jmnImovel.addSeparator();
		jmnImovel.add(jmiVender);
		jmnCadastro.addSeparator();
		jmiPessoa = new JMenuItem("Pessoa");
		jmnCadastro.add(jmiPessoa);
		jmiPessoa.addActionListener(this);
		barra.add(jmnCadastro);

		jmnProcurar = new JMenu("Procurar");
		jmiProcurarPessoa = new JMenuItem("Cliente/Corretor");
		jmiProcurarPessoa.addActionListener(this);
		jmnProcurar.add(jmiProcurarPessoa);
		jmiProcurarPessoa.addActionListener(this);
		barra.add(jmnProcurar);

		jmnGerenciamento = new JMenu("Gerenciamento");
		jmiContaUsuario = new JMenuItem("Contas de usuários");
		jmiContaUsuario.addActionListener(this);
		jmnGerenciamento.add(jmiContaUsuario);
		barra.add(jmnGerenciamento);

	}

	private void posicionaFrames(List<JInternalFrame> frames) {
		for (JInternalFrame fr : frames) {
			fr.setLocation((super.getWidth() / 2) - fr.getWidth() / 2,
					((super.getHeight() / 2) - fr.getHeight() / 2) - 50);
			getContentPane().add(fr);
			fr.setVisible(false);
		}
	}

	public void esconderTelas() {
		//tlLogin.setVisible(false);
		tlCadastroPessoa.setVisible(false);
		tlListaPessoas.setVisible(false);
		tlAlterarPessoa.setVisible(false);
		tlListaUsuarios.setVisible(false);

		posicionaFrames(frames);
	}

	public void alteraVisibilidade() {
		//usuario = telaPrincipal.getTlPrincipal().getTlLogin().getUsuario();
		barra.setVisible(true);
	}

	//public telaLogin getTlLogin() {
		//return tlLogin;
	//}

	public telaCadastroPessoas getTlCadastroPessoa() {
		return tlCadastroPessoa;
	}

	public TelaAlterarPessoa getTlAlterarPessoa() {
		return tlAlterarPessoa;
	}

	public TelaListaPessoa getTlListaPessoas() {
		return tlListaPessoas;
	}

	public TelaListaUsuario getTlListaUsuarios() {
		return tlListaUsuarios;
	}

	public static telaPrincipal getTlPrincipal() {
		if (tlPrincipal == null) {
			tlPrincipal = new telaPrincipal();
		}
		return tlPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jmiPessoa) {
			esconderTelas();
			tlCadastroPessoa.setVisible(true);
		}

		if (e.getSource() == jmiProcurarPessoa) {
			esconderTelas();
			tlListaPessoas.setVisible(true);
		}

		if (e.getSource() == jmiContaUsuario) {
			if (usuario.getNivelAcesso() == 0) {
				JOptionPane.showMessageDialog(null, "Possui permissão de gestor");
				esconderTelas();
				tlListaUsuarios.setVisible(true);
			} else if (usuario.getNivelAcesso() == 1) {
				JOptionPane.showMessageDialog(null, "Não possui permissão de gestor");
			}
		}

	}

	public static void main(String[] args) {
		telaPrincipal.getTlPrincipal();
	}

}
