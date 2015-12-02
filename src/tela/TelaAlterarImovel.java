package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAOFactory.DaoFactoryJDBC;
import dao.EnderecoDAO;
import dao.ImovelDAO;
import imovel.Imovel;
import metodos.AlterarImovel;
import metodos.CadastrarEndereco;
import metodos.CadastrarImovel;
import pessoa.Cliente;
import pessoa.Endereco;
import utilitario.CriarCamponentes;
import utilitario.MensagemAjuda;
import utilitario.MetodosCheck;

public class TelaAlterarImovel extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 2404426739863880445L;
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
	private JButton jbtSalvarAlteracoes, jbtCancelar;
	private Imovel imovelAlterar;
	private JPanel jpnTab6;
	private JLabel jlbDescricao1, jlbDescricao2, jlbDescricao3;
	private JTextField jtfDescricao1, jtfDescricao2, jtfDescricao3;
	private JButton jbtAjudaDescricao;
	private JLabel jlbPossui;
	private JComboBox<String> jcbPossui;
	private Endereco enderecoAlterar;
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private ImovelDAO imovelDao = DaoFactoryJDBC.get().imovelDAO();
	private MetodosCheck mc = new MetodosCheck();
	private MensagemAjuda ma = new MensagemAjuda();

	public TelaAlterarImovel() {
		setTitle("ALTERAR IMÓVEL");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("ALTERAÇÃO DE IMÓVEL", 0, 0, 707, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);

		criarComponentes();
		criarAdicionaNoPane();
		criarCorBotoes();
		criarActionListener();

		jbtAjudaDescricao.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjudaDescricao.setOpaque(false);
		jbtAjudaDescricao.setBorderPainted(false);
		jbtAjudaDescricao.setBackground(new Color(0, 0, 0, 0));

		setResizable(false);
		setSize(700, 530);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarComponentes() {
		jbtSalvarAlteracoes = cp.criarBotao("SALVAR ALTERAÇÕES", 540, 473, 150, 27, jbtSalvarAlteracoes);
		jbtCancelar = cp.criarBotao("CANCELAR", 440, 473, 100, 27, jbtCancelar);
		jbtProcurar1 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar1);
		jbtProcurar2 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar2);
		jbtProcurar3 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar3);
		jbtProcurar4 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar4);
		jbtAjudaDescricao = cp.criarBotao("", 660, 4, 27, 27, jbtAjudaDescricao);
		jbtProcurar = cp.criarBotao("LOCALIZAR", 500, 20, 100, 24, jbtProcurar);
		jbtNovo = cp.criarBotao("CLIENTE", 100, 20, 105, 24, jbtNovo);

		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);
		jlbDescricao1 = cp.criarLabel("Descrição 1:", 10, 10, 100, 24, jlbDescricao1);
		jlbDescricao2 = cp.criarLabel("Descrição 2:", 10, 40, 100, 24, jlbDescricao2);
		jlbDescricao3 = cp.criarLabel("Descrição 3:", 10, 70, 100, 24, jlbDescricao3);
		jlbMetrosQuadrados = cp.criarLabel("Metros quadrados:", 10, 20, 200, 24, jlbMetrosQuadrados);
		jlbPossui = cp.criarLabel("Disponível:", 465, 20, 200, 24, jlbPossui);
		jlbMesesContrato = cp.criarLabel("Meses de Contrato:", 30, 90, 200, 24, jlbMesesContrato);
		jlbValorMensal = cp.criarLabel("Valor mensal:", 230, 90, 200, 24, jlbValorMensal);
		jlbValorTotal = cp.criarLabel("Valor total:", 30, 155, 200, 24, jlbValorTotal);
		jlbRua = cp.criarLabel("Rua:", 10, 20, 110, 30, jlbRua);
		jlbNumero = cp.criarLabel("Nº:", 510, 20, 110, 30, jlbNumero);
		jlbBairro = cp.criarLabel("Bairro:", 10, 50, 110, 30, jlbBairro);
		jlbCidade = cp.criarLabel("Cidade:", 210, 50, 120, 30, jlbCidade);
		jlbUf = cp.criarLabel("UF:", 420, 50, 110, 30, jlbUf);
		jlbCep = cp.criarLabel("CEP:", 510, 50, 110, 30, jlbCep);
		jlbNovo = cp.criarLabel("Cadastrar:", 20, 20, 105, 24, jlbNovo);
		jlbRG = cp.criarLabel("ou pesquisar por rg:", 220, 20, 150, 24, jlbRG);
		jlbNome = cp.criarLabel("NOME:", 20, 50, 50, 24, jlbNome);
		jlbCpf = cp.criarLabel("CPF:", 330, 50, 50, 24, jlbCpf);

		jtfDescricao1 = cp.criarTextField(100, 10, 470, 24, jtfDescricao1);
		jtfDescricao2 = cp.criarTextField(100, 40, 470, 24, jtfDescricao2);
		jtfDescricao3 = cp.criarTextField(100, 70, 470, 24, jtfDescricao3);
		jtfMetrosQuadrados = cp.criarTextField(170, 20, 150, 24, jtfMetrosQuadrados);
		jtfValorMensal = cp.criarTextField(335, 90, 150, 24, jtfValorMensal);
		jtfMesesContrato = cp.criarTextField(170, 90, 50, 24, jtfMesesContrato);
		jtfValorTotal = cp.criarTextField(130, 155, 150, 24, jtfValorTotal);
		jtfMesesContrato.setEnabled(false);
		jtfValorMensal.setEnabled(false);
		jtfValorTotal.setEnabled(false);
		jtfRua = cp.criarTextField(80, 24, 420, 24, jtfRua);
		jtfNumero = cp.criarTextField(550, 24, 90, 24, jtfNumero);
		jtfBairro = cp.criarTextField(80, 54, 120, 24, jtfBairro);
		jtfCidade = cp.criarTextField(280, 52, 130, 24, jtfCidade);
		jtfUf = cp.criarTextField(450, 54, 50, 24, jtfUf);
		jtfCep = cp.criarTextField(550, 54, 90, 24, jtfCep);
		jtfRg = cp.criarTextField(370, 20, 100, 24, jtfRg);
		jtfNome = cp.criarTextField(65, 50, 250, 24, jtfNome);
		jtfNome.setEnabled(false);
		jtfCpf = cp.criarTextField(360, 50, 150, 24, jtfCpf);
		jtfCpf.setEnabled(false);

		jcbPossui = new JComboBox<>();
		jcbPossui.addItem("NÃO");
		jcbPossui.addItem("SIM");
		jcbPossui.setBounds(550, 20, 90, 24);
		jcbPossui.setVisible(true);

		jrbAlugar = cp.criarRadioButton("IMÓVEL PARA ALUGAR", 10, 60, 200, 24, jrbAlugar);
		jrbVender = cp.criarRadioButton("IMÓVEL PARA VENDER", 10, 125, 200, 24, jrbVender);

		btgTipoVenda = new ButtonGroup();
		btgTipoVenda.add(jrbAlugar);
		btgTipoVenda.add(jrbVender);

		jpnLocalizador = cp.criarPanel("PROPRIETÁRIO", 0, 310, 684, 80, jpnLocalizador, true);
		jpnLocalizador.add(jlbNovo);
		jpnLocalizador.add(jlbRG);
		jpnLocalizador.add(jtfRg);
		jpnLocalizador.add(jbtProcurar);
		jpnLocalizador.add(jbtNovo);
		jpnLocalizador.add(jlbNome);
		jpnLocalizador.add(jtfNome);
		jpnLocalizador.add(jlbCpf);
		jpnLocalizador.add(jtfCpf);

		jpnCadastroEndereco = cp.criarPanel("Endereço", 0, 10, 684, 90, jpnCadastroEndereco, true);
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

		jpnImovel = cp.criarPanel("Imóvel", 0, 110, 684, 190, jpnImovel, true);
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

		jfcProcurar = new JFileChooser();

		jpnTab1 = cp.criarPanel("", 0, 0, 700, 300, jpnTab1, true);
		jpnTab2 = cp.criarPanel("", 0, 0, 700, 420, jpnTab2, true);
		jpnTab3 = cp.criarPanel("", 0, 0, 700, 420, jpnTab3, true);
		jpnTab4 = cp.criarPanel("", 0, 0, 700, 420, jpnTab4, true);
		jpnTab5 = cp.criarPanel("", 0, 0, 700, 420, jpnTab5, true);
		jpnTab6 = cp.criarPanel("", 0, 0, 700, 420, jpnTab6, true);

		jpnTab1.add(jpnLocalizador);
		jpnTab1.add(jpnCadastroEndereco);
		jpnTab1.add(jpnImovel);
		jpnTab2.add(jbtProcurar1);
		jpnTab2.add(jlbImagem1);
		jpnTab3.add(jbtProcurar2);
		jpnTab3.add(jlbImagem2);
		jpnTab4.add(jbtProcurar3);
		jpnTab4.add(jlbImagem3);
		jpnTab5.add(jbtProcurar4);
		jpnTab5.add(jlbImagem4);
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
		jtbPrincipal.add("Descrição do Imóvel", jpnTab6);
		jtbPrincipal.setBounds(0, 50, 693, 420);
		getContentPane().add(jtbPrincipal);
	}

	private void criarCorBotoes() {
		jbtSalvarAlteracoes = cp.alterarCorBotoes(jbtSalvarAlteracoes);
		jbtCancelar = cp.alterarCorBotoes(jbtCancelar);
	}

	private void criarAdicionaNoPane() {
		getContentPane().add(jbtSalvarAlteracoes);
		getContentPane().add(jbtCancelar);
	}

	private void criarActionListener() {
		jbtSalvarAlteracoes.addActionListener(this);
		jbtCancelar.addActionListener(this);
		jbtProcurar1.addActionListener(this);
		jbtProcurar2.addActionListener(this);
		jbtProcurar3.addActionListener(this);
		jbtProcurar4.addActionListener(this);
		jbtAjudaDescricao.addActionListener(this);
		jrbAlugar.addActionListener(this);
		jrbVender.addActionListener(this);

		jtfValorTotal.setEnabled(false);
	}

	public static void main(String[] args) {
		new TelaAlterarImovel();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSalvarAlteracoes) {
			salvarAlteracoes();
		}

		if (e.getSource() == jrbAlugar) {
			rbAlugar();
		}
		if (e.getSource() == jrbVender) {
			rbVender();
		}
		if (e.getSource() == jbtProcurar1) {
			jfcProcurar.showOpenDialog(null);
			arquivo1 = jfcProcurar.getSelectedFile();
			Boolean verificaExtensao = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
			if (verificaExtensao) {
				BufferedImage img1 = cp.redimensionarImagem(arquivo1.getAbsolutePath(), 700, 420);
				jlbImagem1.setIcon(new ImageIcon(img1));
			}
		}
		if (e.getSource() == jbtProcurar2) {
			jfcProcurar.showOpenDialog(null);
			arquivo2 = jfcProcurar.getSelectedFile();
			Boolean verificaExtensao = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
			if (verificaExtensao) {
				BufferedImage img2 = cp.redimensionarImagem(arquivo2.getAbsolutePath(), 700, 420);
				jlbImagem2.setIcon(new ImageIcon(img2));
			}

		}
		if (e.getSource() == jbtProcurar3) {
			jfcProcurar.showOpenDialog(null);
			arquivo3 = jfcProcurar.getSelectedFile();
			Boolean verificaExtensao = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
			if (verificaExtensao) {
				BufferedImage img3 = cp.redimensionarImagem(arquivo3.getAbsolutePath(), 700, 420);
				jlbImagem3.setIcon(new ImageIcon(img3));
			}
		}
		if (e.getSource() == jbtProcurar4) {
			jfcProcurar.showOpenDialog(null);
			arquivo4 = jfcProcurar.getSelectedFile();
			Boolean verificaExtensao = mc.verificaExtensaoJpg(jfcProcurar, "adicionar_jpg");
			if (verificaExtensao) {
				BufferedImage img4 = cp.redimensionarImagem(arquivo4.getAbsolutePath(), 700, 420);
				jlbImagem4.setIcon(new ImageIcon(img4));
			}
		}
		if (e.getSource() == jbtAjudaDescricao) {
			ma.ajudaCadastroImovelDescricoes();
		}

	}

	private void salvarAlteracoes() {
		String metrosQuadrados = jtfMetrosQuadrados.getText();
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
		
		AlterarImovel ai = new AlterarImovel();
		ai.alterarImovel(imovelAlterar.getIdImovel(), metrosQuadrados, valorTotal, valorMensal, mesesContrato, imagem1, imagem2, imagem3, imagem4, descricao1, descricao2, descricao3, possui);
		
		enderecoAlterar.setRua(jtfRua.getText());
		enderecoAlterar.setBairro(jtfBairro.getText());
		enderecoAlterar.setNumero(jtfNumero.getText());
		enderecoAlterar.setCidade(jtfCidade.getText());
		enderecoAlterar.setUf(jtfUf.getText());
		enderecoAlterar.setCep(jtfCep.getText());

		imovelAlterar.setMetrosquadrados(jtfMetrosQuadrados.getText());
		imovelAlterar.setImagem1(arquivo1.getAbsolutePath());
		imovelAlterar.setImagem2(arquivo2.getAbsolutePath());
		imovelAlterar.setImagem3(arquivo3.getAbsolutePath());
		imovelAlterar.setImagem4(arquivo4.getAbsolutePath());
		imovelAlterar.setDescricao1(jtfDescricao1.getText());
		imovelAlterar.setDescricao2(jtfDescricao2.getText());
		imovelAlterar.setDescricao3(jtfDescricao3.getText());
		imovelAlterar.setPossui(jcbPossui.getSelectedIndex());
		if (jrbAlugar.isSelected()) {
			imovelAlterar.setMesesContrato(Integer.valueOf(jtfMesesContrato.getText()));
			imovelAlterar.setValorMensal(Double.valueOf(jtfValorMensal.getText()));
			imovelAlterar.setValorTotal(0.0);
		} else if (jrbVender.isSelected()) {
			imovelAlterar.setValorTotal(Double.valueOf(jtfValorTotal.getText()));
			imovelAlterar.setMesesContrato(0);
			imovelAlterar.setValorMensal(0.0);
		}
		enderecoDao.alterar(enderecoAlterar);

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

	public void preencherCampos(Imovel imovel) {
		this.enderecoAlterar = enderecoDao.buscar(imovel.getEndereco().getId());
		this.imovelAlterar = imovel;
		jtfRua.setText(imovel.getEndereco().getRua());
		jtfBairro.setText(imovel.getEndereco().getBairro());
		jtfNumero.setText(imovel.getEndereco().getNumero());
		jtfCidade.setText(imovel.getEndereco().getCidade());
		jtfUf.setText(imovel.getEndereco().getUf());
		jtfCep.setText(imovel.getEndereco().getCep());
		jtfMetrosQuadrados.setText(imovel.getMetrosquadrados());

		jtfMesesContrato.setText(String.valueOf(imovel.getMesesContrato()));
		jtfValorMensal.setText(String.valueOf(imovel.getValorMensal()));
		jtfValorTotal.setText(String.valueOf(imovel.getValorTotal()));

		if ((imovel.getValorTotal() > 1) && (imovel.getValorMensal() < 1)) {
			rbVender();
			jrbVender.setSelected(true);
			jrbAlugar.setEnabled(false);
		} else if ((imovel.getValorMensal() > 1) && (imovel.getValorTotal() < 1)) {
			rbAlugar();
			jrbAlugar.setSelected(true);
			jrbVender.setEnabled(false);
		}

		if (imovel.getPossui() == 0) {
			jcbPossui.setSelectedIndex(0);
		} else {
			jcbPossui.setSelectedIndex(1);
		}

		jtfDescricao1.setText(imovel.getDescricao1());
		jtfDescricao2.setText(imovel.getDescricao2());
		jtfDescricao3.setText(imovel.getDescricao3());

		jbtNovo.setEnabled(false);
		jbtProcurar.setEnabled(false);
		jtfRg.setEnabled(false);

		jtfNome.setText(imovel.getCliente().getPessoa().getNome());
		jtfCpf.setText(imovel.getCliente().getPessoa().getCpf());

		BufferedImage img1 = cp.redimensionarImagem(imovel.getImagem1(), 700, 420);
		jlbImagem1.setIcon(new ImageIcon(img1));

		BufferedImage img2 = cp.redimensionarImagem(imovel.getImagem2(), 700, 420);
		jlbImagem2.setIcon(new ImageIcon(img2));

		BufferedImage img3 = cp.redimensionarImagem(imovel.getImagem3(), 700, 420);
		jlbImagem3.setIcon(new ImageIcon(img3));

		BufferedImage img4 = cp.redimensionarImagem(imovel.getImagem4(), 700, 420);
		jlbImagem4.setIcon(new ImageIcon(img4));

	}

}
