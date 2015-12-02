package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import conexao.ConexaoUtil;
import pessoa.Usuario;
import relatorios.RelatorioUtil;

public class telaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private TelaCadastroCorretor tlCadastroCorretor = new TelaCadastroCorretor();
	private TelaCadastraCliente tlCadastraCliente = new TelaCadastraCliente();
	private TelaListaPessoa tlListaPessoas = new TelaListaPessoa();
	private TelaAlterarPessoa tlAlterarPessoa = new TelaAlterarPessoa();
	private TelaListaUsuario tlListaUsuarios = new TelaListaUsuario();
	private TelaProcurarCliente tlProcurarCliente = new TelaProcurarCliente();
	private TelaAlterarImovel tlAlterarImovel = new TelaAlterarImovel();
	private TelaAlterarNota tlAlterarNota = new TelaAlterarNota();
	private TelaListaNota tlListaNota = new TelaListaNota();
	private telaLogin tlLogin = new telaLogin();
	private TelaListaImovel tlListaImovel = new TelaListaImovel();
	private TelaCadastroImovel tlCadastroImovel = new TelaCadastroImovel();
	private TelaProcurarCorretor tlProcurarCorretor = new TelaProcurarCorretor();
	private TelaCadastrarVenda tlCadastrarVenda = new TelaCadastrarVenda();
	private static telaPrincipal tlPrincipal = new telaPrincipal();
	private JMenu jmnCadastro, jmnProcurar, jmnGerenciamento, jmnRelatorios, jmnSair, jmnVendas;
	private JMenuItem jmiCliente, jmiCorretor, jmiProcurarPessoa, jmiContaUsuario, jmiRelatorioCliente, jmiNotas,
			jmiProcurarImovel, jmiImovel;
	private Usuario usuario;
	private ArrayList<JInternalFrame> frames = new ArrayList<>();

	telaPrincipal() {
		setTitle("ImoSoft Imobiliárias");
		setLayout(null);

		criarBarra();

		setJMenuBar(barra);
		setSize(1000, 650);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		frames.add(tlCadastroCorretor);
		frames.add(tlCadastraCliente);
		frames.add(tlListaPessoas);
		frames.add(tlAlterarPessoa);
		frames.add(tlListaUsuarios);
		frames.add(tlProcurarCliente);
		frames.add(tlListaImovel);
		frames.add(tlCadastroImovel);
		frames.add(tlAlterarImovel);
		frames.add(tlProcurarCorretor);
		frames.add(tlCadastrarVenda);
		frames.add(tlAlterarNota);
		frames.add(tlListaNota);
		posicionaFrames(frames);

	}

	private void criarBarra() {
		barra = new JMenuBar();
		barra.setVisible(true);

		jmnCadastro = new JMenu("Cadastro");
		jmiImovel = new JMenuItem("Cadastro de imóvel");
		jmiImovel.addActionListener(this);
		jmnCadastro.add(jmiImovel);

		jmnCadastro.addSeparator();
		jmiCliente = new JMenuItem("Cadastro de cliente");
		jmnCadastro.add(jmiCliente);
		jmiCliente.addActionListener(this);
		jmiCorretor = new JMenuItem("Cadastro de corretor");
		jmnCadastro.add(jmiCorretor);
		jmiCorretor.addActionListener(this);
		barra.add(jmnCadastro);

		jmnProcurar = new JMenu("Procurar");
		jmiProcurarPessoa = new JMenuItem("Cliente/Corretor");
		jmiProcurarPessoa.addActionListener(this);
		jmnProcurar.add(jmiProcurarPessoa);
		jmiProcurarImovel = new JMenuItem("Imóvel");
		jmiProcurarImovel.addActionListener(this);
		jmnProcurar.addSeparator();
		jmnProcurar.add(jmiProcurarImovel);
		barra.add(jmnProcurar);

		jmnVendas = new JMenu("Vendas");
		jmiNotas = new JMenuItem("Vendas/Notas Fiscais");
		jmnVendas.add(jmiNotas);
		jmiNotas.addActionListener(this);

		barra.add(jmnVendas);

		jmnGerenciamento = new JMenu("Gerenciamento");
		jmiContaUsuario = new JMenuItem("Contas de usuários");
		jmiContaUsuario.addActionListener(this);
		jmnGerenciamento.add(jmiContaUsuario);
		barra.add(jmnGerenciamento);

		jmnRelatorios = new JMenu("Relatórios");
		jmiRelatorioCliente = new JMenuItem("Gerar relatório de clientes cadastrados");
		jmiRelatorioCliente.addActionListener(this);
		jmnRelatorios.add(jmiRelatorioCliente);
		barra.add(jmnRelatorios);

		jmnSair = new JMenu("Sair");
		jmnSair.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				telaPrincipal.getTlPrincipal().setVisible(false);
				telaPrincipal.getTlPrincipal().getTlLogin().setVisible(true);

			}

			public void menuDeselected(MenuEvent e) {

			}

			public void menuCanceled(MenuEvent e) {

			}
		});
		barra.add(jmnSair);

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
		tlCadastroCorretor.setVisible(false);
		tlCadastraCliente.setVisible(false);
		tlListaPessoas.setVisible(false);
		tlAlterarPessoa.setVisible(false);
		tlListaUsuarios.setVisible(false);
		tlProcurarCliente.setVisible(false);
		tlCadastroImovel.setVisible(false);
		tlListaImovel.setVisible(false);
		tlAlterarImovel.setVisible(false);
		tlProcurarCorretor.setVisible(false);
		tlCadastrarVenda.setVisible(false);
		tlAlterarNota.setVisible(true);
		tlListaNota.setVisible(false);
		posicionaFrames(frames);
	}

	public void alteraVisibilidade() {
		usuario = tlLogin.getUsuario();
		tlPrincipal.setVisible(true);
		barra.setVisible(true);
	}

	public TelaListaNota getTlListaNota() {
		return tlListaNota;
	}

	public TelaAlterarNota getTlAlterarNota() {
		return tlAlterarNota;
	}

	public TelaProcurarCorretor getTlProcurarCorretor() {
		return tlProcurarCorretor;
	}

	public TelaAlterarImovel getTlAlterarImovel() {
		return tlAlterarImovel;
	}

	public TelaCadastroCorretor getTlCadastroCorretor() {
		return tlCadastroCorretor;
	}

	public TelaListaImovel getTlListaImovel() {
		return tlListaImovel;
	}

	public TelaCadastrarVenda getTlCadastrarVenda() {
		return tlCadastrarVenda;
	}

	public TelaCadastroImovel getTlCadastroImovel() {
		return tlCadastroImovel;
	}

	public TelaCadastraCliente getTlCadastraCliente() {
		return tlCadastraCliente;
	}

	public TelaProcurarCliente getTlProcurarCliente() {
		return tlProcurarCliente;
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

	public telaLogin getTlLogin() {
		return tlLogin;
	}

	public static telaPrincipal getTlPrincipal() {
		if (tlPrincipal == null) {
			tlPrincipal = new telaPrincipal();
		}
		return tlPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jmiProcurarImovel) {
			esconderTelas();
			tlListaImovel.setVisible(true);
		}
		if (e.getSource() == jmiImovel) {
			esconderTelas();
			tlCadastroImovel.setVisible(true);
		}
		if (e.getSource() == jmiCliente) {
			esconderTelas();
			tlCadastraCliente.setVisible(true);
		}

		if (e.getSource() == jmiCorretor) {
			esconderTelas();
			tlCadastroCorretor.setVisible(true);
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

		if (e.getSource() == jmiRelatorioCliente) {
			Map<String, Object> parametros = new HashMap<String, Object>();
			new RelatorioUtil().viewReport("src/relatorios/Cherry_Landscape.jasper", ConexaoUtil.getCon(), parametros);
		}

		if (e.getSource() == jmiNotas) {
			telaPrincipal.getTlPrincipal().esconderTelas();
			telaPrincipal.getTlPrincipal().getTlListaNota().alimentarTabela();
			telaPrincipal.getTlPrincipal().getTlListaNota().setVisible(true);
		}

	}

	public static void main(String[] args) {
		telaPrincipal.getTlPrincipal().getTlLogin();
		tlPrincipal.setVisible(false);
	}

}
