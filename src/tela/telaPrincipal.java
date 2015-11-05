package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import DAOFactory.DaoFactoryJDBC;
import dao.UsuarioDAO;
import pessoa.Usuario;

public class telaPrincipal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private telaLogin tlLogin = new telaLogin();
	private telaCadastroPessoas tlCadastroPessoa = new telaCadastroPessoas();
	private TelaListaPessoa tlListaPessoas = new TelaListaPessoa();
	private TelaAlterarPessoa tlAlterarPessoa = new TelaAlterarPessoa();
	private TelaListaUsuario tlListaUsuarios = new TelaListaUsuario();
	private static telaPrincipal tlPrincipal = new telaPrincipal();
	private JMenu jmnImovel, jmnCadastro, jmnProcurar, jmnGerenciamento;
	private JMenuItem jmiAlugar, jmiVender, jmiPessoa, jmiProcurarPessoa, jmiContaUsuario;
	private Integer idUsuario;
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	
	telaPrincipal(){		
		setTitle("M&M Sistema Imobili�rio");
		setLayout(null);
		
		getContentPane().add(tlLogin);
		tlLogin.setVisible(true);
		tlLogin.setLocation(250, 130);
		
		getContentPane().add(tlCadastroPessoa);
		tlCadastroPessoa.setVisible(false);
		tlCadastroPessoa.setLocation(97, 62);
		
		getContentPane().add(tlListaPessoas);
		tlListaPessoas.setVisible(false);
		tlListaPessoas.setLocation(97, 10);
		
		getContentPane().add(tlAlterarPessoa);
		tlAlterarPessoa.setVisible(false);
		tlAlterarPessoa.setLocation(97, 10);
		
		getContentPane().add(tlListaUsuarios);
		tlListaUsuarios.setVisible(false);
		tlListaUsuarios.setLocation(190, 30);
		
		barra = new JMenuBar();
		barra.setVisible(false);
		
		jmnCadastro = new JMenu("Cadastro");
		
		jmnImovel = new JMenu("Im�vel");
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
		
		jmiContaUsuario = new JMenuItem("Contas de usu�rios");
		jmiContaUsuario.addActionListener(this);
		jmnGerenciamento.add(jmiContaUsuario);
		barra.add(jmnGerenciamento);	
		
		getContentPane().setBackground(Color.white);
		setJMenuBar(barra);
		setSize(900,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void esconderTelas(){
		tlLogin.setVisible(false);
		tlCadastroPessoa.setVisible(false);
		tlListaPessoas.setVisible(false);
		tlAlterarPessoa.setVisible(false);
		
		tlLogin.setLocation(250, 130);
		tlCadastroPessoa.setLocation(97, 62);
		tlListaPessoas.setLocation(97, 10);
		tlAlterarPessoa.setLocation(97, 10);
	}
	
	public void alteraVisibilidade(){
		idUsuario = telaPrincipal.getTlPrincipal().getTlLogin().getIdUsuario();
		barra.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		telaPrincipal.getTlPrincipal();
	}

	public telaLogin getTlLogin() {
		return tlLogin;
	}
	
	public telaCadastroPessoas getTlCadastroPessoa() {
		return tlCadastroPessoa;
	}
	
	public TelaAlterarPessoa getTlAlterarPessoa(){
		return tlAlterarPessoa;
	}

	public TelaListaPessoa getTlListaPessoas() {
		return tlListaPessoas;
	}
	
	public TelaListaUsuario getTlListaUsuarios() {
		return tlListaUsuarios;
	}

	public static telaPrincipal getTlPrincipal() {
		if(tlPrincipal == null){
			tlPrincipal = new telaPrincipal();
		}
		return tlPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jmiPessoa){
			esconderTelas();
			tlCadastroPessoa.setVisible(true);
			//tlCadastroPessoa.setClosable(true);
		}
		if(e.getSource() == jmiProcurarPessoa){
			esconderTelas();
			tlListaPessoas.setVisible(true);
		}
		if(e.getSource() == jmiContaUsuario){
			Usuario usuario = usuarioDao.buscar(idUsuario);
			if(usuario.getNivelAcesso() == 0){
				JOptionPane.showMessageDialog(null, "Possui permiss�o de gestor");
				esconderTelas();
				tlListaUsuarios.setVisible(true);
			}else if(usuario.getNivelAcesso() == 1){
				JOptionPane.showMessageDialog(null, "N�o possui permiss�o de gestor");
			}
		}
		
	}	
}
