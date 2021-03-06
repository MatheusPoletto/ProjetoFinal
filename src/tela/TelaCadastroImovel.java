package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;

import metodos.CadastrarEndereco;
import metodos.CadastrarImovel;
import pessoa.Cliente;
import pessoa.Endereco;
import utilitario.CriarCamponentes;
import utilitario.MensagemAjuda;
import utilitario.MensagemSucesso;
import utilitario.MetodosCheck;

public class TelaCadastroImovel extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 4319035476296494897L;
	private JLabel jlbTitulo;
	private JPanel jpnLocalizador, jpnTab1;
	private JLabel jlbNovo, jlbRG, jlbNome, jlbCpf;
	private JButton jbtProcurar, jbtNovo;
	private JTextField jtfRg, jtfNome, jtfCpf;
	private JTabbedPane jtbPrincipal;
	private JPanel jpnTab2;
	private JButton jbtProcurar1;
	private JLabel jlbImagem1;
	private JFileChooser jfcProcurar;
	private JPanel jpnTab3;
	private JButton jbtProcurar2;
	private JLabel jlbImagem2;
	private JPanel jpnTab4;
	private JButton jbtProcurar3;
	private JLabel jlbImagem3;
	private JPanel jpnTab5;
	private JButton jbtProcurar4;
	private JLabel jlbImagem4;
	private JPanel jpnImovel;
	private JRadioButton jrbAlugar, jrbVender;
	private ButtonGroup btgTipoVenda;
	private JLabel jlbMetrosQuadrados, jlbValorTotal, jlbValorMensal, jlbMesesContrato;
	private JTextField jtfMetrosQuadrados, jtfMesesContrato, jtfValorTotal, jtfValorMensal;
	private CriarCamponentes cp = new CriarCamponentes();
	private JPanel jpnCadastroEndereco;
	private JLabel jlbRua, jlbNumero, jlbCidade, jlbBairro, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfCidade, jtfBairro, jtfUf, jtfCep;
	private File arquivo1, arquivo2, arquivo3, arquivo4;
	private JButton jbtSalvar;
	private JLabel jlbPossui;
	private JComboBox<String> jcbPossui;
	private JButton jbtAjudaDescricao;
	private JLabel jlbDescricao1, jlbDescricao2, jlbDescricao3;
	private JTextField jtfDescricao1, jtfDescricao2, jtfDescricao3;
	private JPanel jpnTab6;
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private Cliente clienteEncontrado;
	private MetodosCheck mc = new MetodosCheck();
	private MensagemSucesso ms = new MensagemSucesso();
	private MensagemAjuda ma = new MensagemAjuda();
	private List<JTextField> jtfsValidar = new ArrayList<>();
	private Boolean btgSelecionado = false;

	public TelaCadastroImovel() {
		setTitle("Cadastro de Im�vel");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("CADASTRO DE IM�VEL", 0, 0, 707, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);

		criarPanelCadastroEndereco();
		criarPanelLocalizadorProprietario();
		criarPainelTabs();
		jfcProcurar = new JFileChooser();
		criarBotoesInferiores();

		setResizable(false);
		setSize(700, 530);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarPainelTabs() {
		jlbMetrosQuadrados = cp.criarLabel("METROS QUADRADOS:", 10, 20, 200, 24, jlbMetrosQuadrados);
		jtfMetrosQuadrados = cp.criarTextField(170, 20, 150, 24, jtfMetrosQuadrados);

		jlbPossui = cp.criarLabel("DISPON�VEL:", 465, 20, 200, 24, jlbPossui);
		jcbPossui = new JComboBox<>();
		jcbPossui.addItem("N�O");
		jcbPossui.addItem("SIM");
		jcbPossui.setBounds(550, 20, 90, 24);
		jcbPossui.setVisible(true);
		getContentPane().add(jcbPossui);

		jrbAlugar = cp.criarRadioButton("IM�VEL PARA ALUGAR", 10, 60, 200, 24, jrbAlugar);
		jrbAlugar.addActionListener(this);
		jlbMesesContrato = cp.criarLabel("MESES DE CONTRATO:", 30, 90, 200, 24, jlbMesesContrato);
		jtfMesesContrato = cp.criarTextField(170, 90, 50, 24, jtfMesesContrato);
		jtfMesesContrato.setEnabled(false);
		jlbValorMensal = cp.criarLabel("VALOR MENSAL:", 230, 90, 200, 24, jlbValorMensal);
		jtfValorMensal = cp.criarTextField(335, 90, 150, 24, jtfValorMensal);
		jtfValorMensal.setEnabled(false);

		jrbVender = cp.criarRadioButton("IM�VEL PARA VENDER", 10, 125, 200, 24, jrbVender);
		jrbVender.addActionListener(this);
		jlbValorTotal = cp.criarLabel("VALOR TOTAL:", 30, 155, 200, 24, jlbValorTotal);
		jtfValorTotal = cp.criarTextField(130, 155, 150, 24, jtfValorTotal);
		jtfValorTotal.setEnabled(false);

		btgTipoVenda = new ButtonGroup();
		btgTipoVenda.add(jrbAlugar);
		btgTipoVenda.add(jrbVender);

		jpnImovel = cp.criarPanel("Im�vel", 0, 110, 684, 190, jpnImovel, true);
		jpnImovel.add(jrbAlugar);
		jpnImovel.add(jrbVender);
		jpnImovel.add(jlbMesesContrato);
		jpnImovel.add(jtfMesesContrato);
		jpnImovel.add(jlbPossui);
		jpnImovel.add(jcbPossui);
		jpnImovel.add(jlbValorMensal);
		jpnImovel.add(jtfValorMensal);
		jpnImovel.add(jlbValorTotal);
		jpnImovel.add(jtfValorTotal);
		jpnImovel.add(jlbMetrosQuadrados);
		jpnImovel.add(jtfMetrosQuadrados);

		jbtProcurar1 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar1);
		jbtProcurar2 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar2);
		jbtProcurar3 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar3);
		jbtProcurar4 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar4);

		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);

		jbtProcurar1.addActionListener(this);
		jbtProcurar2.addActionListener(this);
		jbtProcurar3.addActionListener(this);
		jbtProcurar4.addActionListener(this);

		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);

		jlbDescricao1 = cp.criarLabel("Descri��o 1:", 10, 10, 100, 24, jlbDescricao1);
		jlbDescricao2 = cp.criarLabel("Descri��o 2:", 10, 40, 100, 24, jlbDescricao2);
		jlbDescricao3 = cp.criarLabel("Descri��o 3:", 10, 70, 100, 24, jlbDescricao3);

		jtfDescricao1 = cp.criarTextField(100, 10, 470, 24, jtfDescricao1);
		jtfDescricao2 = cp.criarTextField(100, 40, 470, 24, jtfDescricao2);
		jtfDescricao3 = cp.criarTextField(100, 70, 470, 24, jtfDescricao3);

		jbtAjudaDescricao = cp.criarBotao("", 660, 4, 27, 27, jbtAjudaDescricao);
		jbtAjudaDescricao.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjudaDescricao.setOpaque(false);
		jbtAjudaDescricao.setBorderPainted(false);
		jbtAjudaDescricao.setBackground(new Color(0, 0, 0, 0));
		jbtAjudaDescricao.addActionListener(this);

		jpnTab1 = cp.criarPanel("", 0, 0, 700, 300, jpnTab1, true);
		jpnTab1.add(jpnLocalizador);
		jpnTab1.add(jpnCadastroEndereco);
		jpnTab1.add(jpnImovel);

		jpnTab2 = cp.criarPanel("", 0, 0, 700, 420, jpnTab2, true);
		jpnTab2.add(jbtProcurar1);
		jpnTab2.add(jlbImagem1);

		jpnTab3 = cp.criarPanel("", 0, 0, 700, 420, jpnTab3, true);
		jpnTab3.add(jbtProcurar2);
		jpnTab3.add(jlbImagem2);

		jpnTab4 = cp.criarPanel("", 0, 0, 700, 420, jpnTab4, true);
		jpnTab4.add(jbtProcurar3);
		jpnTab4.add(jlbImagem3);

		jpnTab5 = cp.criarPanel("", 0, 0, 700, 420, jpnTab5, true);
		jpnTab5.add(jbtProcurar4);
		jpnTab5.add(jlbImagem4);

		jpnTab6 = cp.criarPanel("", 0, 0, 700, 420, jpnTab6, true);
		jpnTab6.add(jlbDescricao1);
		jpnTab6.add(jlbDescricao2);
		jpnTab6.add(jlbDescricao3);
		jpnTab6.add(jtfDescricao1);
		jpnTab6.add(jtfDescricao2);
		jpnTab6.add(jtfDescricao3);
		jpnTab6.add(jbtAjudaDescricao);

		jtbPrincipal = new JTabbedPane();
		jtbPrincipal.add("Principal", jpnTab1);
		jtbPrincipal.add("Imagem 1", jpnTab2);
		jtbPrincipal.add("Imagem 2", jpnTab3);
		jtbPrincipal.add("Imagem 3", jpnTab4);
		jtbPrincipal.add("Imagem 4", jpnTab5);
		jtbPrincipal.add("Descri��o do Im�vel", jpnTab6);
		jtbPrincipal.setBounds(0, 50, 693, 420);
		getContentPane().add(jtbPrincipal);

	}

	private void criarBotoesInferiores() {
		jbtSalvar = cp.criarBotao("CADASTRAR", 540, 473, 150, 27, jbtSalvar);
		jbtSalvar = cp.alterarCorBotoes(jbtSalvar);
		jbtSalvar.addActionListener(this);
		getContentPane().add(jbtSalvar);
	}

	private void criarPanelCadastroEndereco() {
		jlbRua = cp.criarLabel("Rua:", 10, 20, 110, 30, jlbRua);
		jlbNumero = cp.criarLabel("N�:", 510, 20, 110, 30, jlbNumero);
		jlbBairro = cp.criarLabel("Bairro:", 10, 50, 110, 30, jlbBairro);
		jlbCidade = cp.criarLabel("Cidade:", 210, 50, 120, 30, jlbCidade);
		jlbUf = cp.criarLabel("UF:", 420, 50, 110, 30, jlbUf);
		jlbCep = cp.criarLabel("CEP:", 510, 50, 110, 30, jlbCep);

		jtfRua = cp.criarTextField(80, 24, 420, 24, jtfRua);
		jtfNumero = cp.criarTextField(550, 24, 90, 24, jtfNumero);
		jtfBairro = cp.criarTextField(80, 54, 120, 24, jtfBairro);
		jtfCidade = cp.criarTextField(280, 52, 130, 24, jtfCidade);
		jtfUf = cp.criarTextField(450, 54, 50, 24, jtfUf);
		jtfCep = cp.criarTextField(550, 54, 90, 24, jtfCep);

		jpnCadastroEndereco = cp.criarPanel("Endere�o", 0, 10, 684, 90, jpnCadastroEndereco, true);
		jpnCadastroEndereco.add(jlbRua);
		jpnCadastroEndereco.add(jlbNumero);
		jpnCadastroEndereco.add(jlbBairro);
		jpnCadastroEndereco.add(jlbCidade);
		jpnCadastroEndereco.add(jlbUf);
		jpnCadastroEndereco.add(jlbCep);
		jpnCadastroEndereco.add(jtfRua);
		jpnCadastroEndereco.add(jtfNumero);
		jpnCadastroEndereco.add(jtfBairro);
		jpnCadastroEndereco.add(jtfCidade);
		jpnCadastroEndereco.add(jtfUf);
		jpnCadastroEndereco.add(jtfCep);

	}

	private void criarPanelLocalizadorProprietario() {
		jlbNovo = cp.criarLabel("CADASTRAR:", 20, 20, 105, 24, jlbNovo);
		jlbRG = cp.criarLabel("OU PESQUISAR POR RG:", 220, 20, 150, 24, jlbRG);
		jlbNome = cp.criarLabel("NOME:", 20, 50, 50, 24, jlbNome);
		jlbCpf = cp.criarLabel("CPF:", 330, 50, 50, 24, jlbCpf);

		jtfRg = cp.criarTextField(370, 20, 100, 24, jtfRg);
		jtfNome = cp.criarTextField(65, 50, 250, 24, jtfNome);
		jtfNome.setEnabled(false);
		jtfCpf = cp.criarTextField(360, 50, 150, 24, jtfCpf);
		jtfCpf.setEnabled(false);

		jbtProcurar = cp.criarBotao("LOCALIZAR", 500, 20, 100, 24, jbtProcurar);
		jbtNovo = cp.criarBotao("CLIENTE", 100, 20, 105, 24, jbtNovo);

		jbtProcurar.addActionListener(this);
		jbtNovo.addActionListener(this);

		jpnLocalizador = cp.criarPanel("PROPRIET�RIO", 0, 310, 684, 80, jpnLocalizador, true);
		jpnLocalizador.add(jlbNovo);
		jpnLocalizador.add(jlbRG);
		jpnLocalizador.add(jtfRg);
		jpnLocalizador.add(jbtProcurar);
		jpnLocalizador.add(jbtNovo);
		jpnLocalizador.add(jlbNome);
		jpnLocalizador.add(jtfNome);
		jpnLocalizador.add(jlbCpf);
		jpnLocalizador.add(jtfCpf);

	}

	public static void main(String[] args) {
		new TelaCadastroImovel();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSalvar) {
			salvarImovel();

		}
		if (e.getSource() == jbtProcurar) {
			procorarProprietario();

		}
		if (e.getSource() == jrbAlugar) {
			rbAlugar();
			btgSelecionado = true;
		}
		if (e.getSource() == jrbVender) {
			rbVender();
			btgSelecionado = true;
		}
		if (e.getSource() == jbtProcurar1) {
			procurarImg1();
		}
		if (e.getSource() == jbtProcurar2) {
			procurarImg2();

		}
		if (e.getSource() == jbtProcurar3) {
			criarImg3();
		}
		if (e.getSource() == jbtProcurar4) {
			criarImg4();
		}
		if (e.getSource() == jbtAjudaDescricao) {
			criarBotaAjudaDescricao();
		}
		if (e.getSource() == jbtNovo) {
			telaPrincipal.getTlPrincipal().getTlCadastraCliente().setVisible(true);
		}

	}

	private void criarBotaAjudaDescricao() {
		ma.ajudaCadastroImovelDescricoes();

	}

	private void criarImg4() {
		jfcProcurar.showOpenDialog(null);
		Boolean isJpg = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
		if (isJpg) {
			arquivo4 = jfcProcurar.getSelectedFile();
			BufferedImage img4 = cp.redimensionarImagem(arquivo4.getAbsolutePath(), 700, 420);
			jlbImagem4.setIcon(new ImageIcon(img4));
		}

	}

	private void criarImg3() {
		jfcProcurar.showOpenDialog(null);
		Boolean isJpg = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
		if (isJpg) {
			arquivo3 = jfcProcurar.getSelectedFile();
			BufferedImage img3 = cp.redimensionarImagem(arquivo3.getAbsolutePath(), 700, 420);
			jlbImagem3.setIcon(new ImageIcon(img3));
		}

	}

	private void procurarImg2() {
		jfcProcurar.showOpenDialog(null);
		Boolean isJpg = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
		if (isJpg) {
			arquivo2 = jfcProcurar.getSelectedFile();
			BufferedImage img2 = cp.redimensionarImagem(arquivo2.getAbsolutePath(), 700, 420);
			jlbImagem2.setIcon(new ImageIcon(img2));
		}

	}

	private void procurarImg1() {
		jfcProcurar.showOpenDialog(null);
		Boolean isJpg = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
		if (isJpg) {
			arquivo1 = jfcProcurar.getSelectedFile();
			BufferedImage img1 = cp.redimensionarImagem(arquivo1.getAbsolutePath(), 700, 420);
			jlbImagem1.setIcon(new ImageIcon(img1));
		}

	}

	private void procorarProprietario() {
		if (jtfRg.getText().equals("") || (jtfRg.getText().isEmpty())) {
			telaPrincipal.getTlPrincipal().getTlProcurarCliente().setVisible(true);
			telaPrincipal.getTlPrincipal().getTlProcurarCliente()
					.setLocation(telaPrincipal.getTlPrincipal().getTlProcurarCliente().getX(), 10);
			telaPrincipal.getTlPrincipal().getTlProcurarCliente().setIsVenda(0);
		} else {
			for (Cliente cliente : clienteDao.todos()) {
				if (cliente.getPessoa().getRg().equals(jtfRg.getText())) {
					this.clienteEncontrado = cliente;
					jtfNome.setText(cliente.getPessoa().getNome());
					jtfCpf.setText(cliente.getPessoa().getCpf());
				}
			}
		}

	}

	public void selecionouProprietario(Cliente cliente) {
		this.clienteEncontrado = cliente;
		jtfNome.setText(cliente.getPessoa().getNome());
		jtfCpf.setText(cliente.getPessoa().getCpf());
		jtfRg.setText(cliente.getPessoa().getRg());
	}

	private void salvarImovel() {
		jtfsValidar.add(jtfRua);
		jtfsValidar.add(jtfNumero);
		jtfsValidar.add(jtfBairro);
		jtfsValidar.add(jtfCidade);
		jtfsValidar.add(jtfUf);
		jtfsValidar.add(jtfCep);
		jtfsValidar.add(jtfNome);
		jtfsValidar.add(jtfCpf);

		Boolean camposPreenchidos = mc.verificaCampos(jtfsValidar, "cadastro_imovel");
		if (camposPreenchidos == true) {
			if ((jcbPossui.getSelectedIndex() >= 0) && (btgSelecionado)) {
				CadastrarEndereco ce = new CadastrarEndereco();
				String rua = jtfRua.getText();
				String numero = jtfNumero.getText();
				String bairro = jtfBairro.getText();
				String cidade = jtfCidade.getText();
				String uf = jtfUf.getText();
				String cep = jtfCep.getText();
				Endereco endereco = ce.salvarEndereco(rua, numero, bairro, cidade, uf, cep);

				String metrosQuadrados = jtfMetrosQuadrados.getText();
				Cliente cliente = clienteEncontrado;
				Double valorTotal = null;
				Double valorMensal = null;
				Integer mesesContrato = null;
				if (jrbVender.isSelected()) {
					valorTotal = Double.valueOf(jtfValorTotal.getText());
					valorMensal = 0.0;
					mesesContrato = 0;
				} else if (jrbAlugar.isSelected()) {
					valorMensal = Double.valueOf(jtfValorMensal.getText());
					mesesContrato = Integer.valueOf(jtfMesesContrato.getText());
					valorTotal = 0.0;
				}

				String imagem1 = arquivo1.getAbsolutePath();
				String imagem2 = arquivo2.getAbsolutePath();
				String imagem3 = arquivo3.getAbsolutePath();
				String imagem4 = arquivo4.getAbsolutePath();
				String descricao1 = jtfDescricao1.getText();
				String descricao2 = jtfDescricao2.getText();
				String descricao3 = jtfDescricao3.getText();

				Integer possui = jcbPossui.getSelectedIndex();

				CadastrarImovel ci = new CadastrarImovel();
				ci.salvarImovel(rua, numero, bairro, cidade, uf, cep, metrosQuadrados, cliente, valorTotal, valorMensal,
						mesesContrato, endereco, imagem1, imagem2, imagem3, imagem4, descricao1, descricao2, descricao3,
						possui);
			} else {
				JOptionPane.showMessageDialog(null, "Defina o tipo do im�vel.");
			}
		}
	}

	private void rbVender() {
		jtfValorTotal.setEnabled(true);

		jtfValorMensal.setEnabled(false);
		jtfMesesContrato.setEnabled(false);
	}

	private void rbAlugar() {
		jtfValorMensal.setEnabled(true);
		jtfMesesContrato.setEnabled(true);

		jtfValorTotal.setEnabled(false);
	}

}
