package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import DAOFactory.DaoFactoryJDBC;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import metodos.CadastrarCliente;
import metodos.CadastrarCorretor;
import metodos.CadastrarEndereco;
import metodos.CadastrarPessoa;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;
import utilitario.CriarCamponentes;
import utilitario.MensagemSucesso;
import utilitario.MetodosCheck;

public class TelaCadastroCorretor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = -4618300901528138050L;

	private JLabel jlbTitulo;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbGenero, jlbEstadoCivil, jlbTelefoneResidencial,
			jlbTelefoneCelular, jlbEmail;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular, jtfEmail,
			jtfDataNascimento;
	private JComboBox<String> jcbEstadoCivil;

	private JPanel jpnCadastroEndereco;
	private JLabel jlbRua, jlbNumero, jlbCidade, jlbBairro, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfCidade, jtfBairro, jtfUf, jtfCep;

	private JLabel jlbSalario, jlbComissao, jlbUsuario, jlbSenha;
	private JTextField jtfSalario, jtfComissao, jtfUsuario, jtfSenha;
	private JPanel jpnCadastroCliente;
	private JPanel jpnInfoCorretor;

	private JButton jbtSalvar, jbtLimpar;
	private JPanel jpnCadastrar;
 
	private ArrayList<JTextField> jtfsValidar = new ArrayList<>();

	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	
	private MetodosCheck mc = new MetodosCheck();
	private MensagemSucesso ms = new MensagemSucesso();
	
	private CriarCamponentes cp = new CriarCamponentes();

	public TelaCadastroCorretor() {
		setTitle("Cadastro de corretor");
		setLayout(null);

		jlbTitulo = new JLabel("NOVO CORRETOR", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		criarPanelCadastroCliente();

		criarPanelCadastroEndereco();

		criarPanelCadastrar();

		criarPanelInfoCorretor();


		setResizable(false);
		setSize(700, 450);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarPanelCadastroCliente() {
		jlbNome = cp.criarLabel("Nome:", 10, 20, 110, 30, jlbNome);
		jlbRg = cp.criarLabel("RG:", 10, 50, 110, 30, jlbRg);
		jlbCpf = cp.criarLabel("CPF:", 210, 50, 110, 30, jlbCpf);
		jlbDataNascimento = cp.criarLabel("Data de nascimento:", 420, 50, 120, 30, jlbDataNascimento);
		jlbGenero = cp.criarLabel("Gênero:", 10, 80, 110, 30, jlbGenero);
		jlbEstadoCivil = cp.criarLabel("Estado Civil:", 210, 80, 110, 30, jlbEstadoCivil);
		jlbTelefoneResidencial = cp.criarLabel("Tel. fixo:", 10, 110, 120, 30, jlbTelefoneResidencial);
		jlbTelefoneCelular = cp.criarLabel("Tel. celular:", 210, 110, 110, 30, jlbTelefoneCelular);
		jlbEmail = cp.criarLabel("Email:", 10, 140, 110, 30, jlbEmail);

		jtfNome = cp.criarTextField(80, 24, 560, 24, jtfNome);
		jtfRg = cp.criarTextField(80, 54, 120, 24, jtfRg);
		jtfCpf = cp.criarTextField(280, 54, 120, 24, jtfCpf);
		jtfGenero = cp.criarTextField(80, 84, 120, 24, jtfGenero);
		jtfTelefoneResidencial = cp.criarTextField(80, 114, 120, 24, jtfTelefoneResidencial);
		jtfTelefoneCelular = cp.criarTextField(280, 114, 120, 24, jtfTelefoneCelular);
		jtfEmail = cp.criarTextField(80, 144, 320, 24, jtfEmail);

		jcbEstadoCivil = new JComboBox<>();
		jcbEstadoCivil.setBounds(280, 84, 120, 24);
		jcbEstadoCivil.addItem("Solteiro(a)");
		jcbEstadoCivil.addItem("Casado(a)");
		jcbEstadoCivil.addItem("Divorciado(a)");
		jcbEstadoCivil.addItem("Viúvo(a)");
		jcbEstadoCivil.addItem("Separado(a) Judicialmente");
		jcbEstadoCivil.setSelectedIndex(-1);

		try {
			jtfDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jtfDataNascimento.setBounds(550, 54, 90, 24);
		jtfDataNascimento.setVisible(true);

		jpnCadastroCliente = cp.criarPanel("Dados Pessoais", 0, 50, 684, 182, jpnCadastroCliente, true);
		jpnCadastroCliente.add(jlbNome);
		jpnCadastroCliente.add(jlbRg);
		jpnCadastroCliente.add(jlbCpf);
		jpnCadastroCliente.add(jlbDataNascimento);
		jpnCadastroCliente.add(jlbGenero);
		jpnCadastroCliente.add(jlbEstadoCivil);
		jpnCadastroCliente.add(jlbTelefoneResidencial);
		jpnCadastroCliente.add(jlbTelefoneCelular);
		jpnCadastroCliente.add(jlbEmail);
		jpnCadastroCliente.add(jtfNome);
		jpnCadastroCliente.add(jtfRg);
		jpnCadastroCliente.add(jtfCpf);
		jpnCadastroCliente.add(jtfDataNascimento);
		jpnCadastroCliente.add(jtfGenero);
		jpnCadastroCliente.add(jcbEstadoCivil);
		jpnCadastroCliente.add(jtfTelefoneResidencial);
		jpnCadastroCliente.add(jtfTelefoneCelular);
		jpnCadastroCliente.add(jtfEmail);
		getContentPane().add(jpnCadastroCliente);
	}

	private void criarPanelCadastroEndereco() {
		jlbRua = cp.criarLabel("Rua:", 10, 20, 110, 30, jlbRua);
		jlbNumero = cp.criarLabel("Nº:", 510, 20, 110, 30, jlbNumero);
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

		jpnCadastroEndereco = cp.criarPanel("Endereço", 0, 232, 684, 90, jpnCadastroEndereco, true);
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
		getContentPane().add(jpnCadastroEndereco);
		
	}

	private void criarPanelCadastrar() {
		jbtSalvar = cp.criarBotao("SALVAR", 110, 2, 100, 30, jbtSalvar);
		jbtSalvar.setBackground(new Color(23, 20, 20));
		jbtSalvar.setForeground(Color.white);
		jbtSalvar.addActionListener(this);

		jbtLimpar = cp.criarBotao("LIMPAR", 10, 2, 100, 30, jbtLimpar);
		jbtLimpar.setBackground(new Color(23, 20, 20));
		jbtLimpar.setForeground(Color.white);
		jbtLimpar.addActionListener(this);
		
		jpnCadastrar = cp.criarPanel("", 463, 372, 220, 34, jpnCadastrar, true);
		jpnCadastrar.add(jbtSalvar);
		jpnCadastrar.add(jbtLimpar);
		jpnCadastrar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnCadastrar);

	}

	private void criarPanelInfoCorretor() {
		jlbSalario = cp.criarLabel("Salário:", 10, 12, 80, 30, jlbSalario);
		jlbComissao = cp.criarLabel("Comissão:", 135, 12, 80, 30, jlbComissao);
		jlbUsuario = cp.criarLabel("Usuário:", 280, 12, 80, 30, jlbUsuario);
		jlbSenha = cp.criarLabel("Senha:", 495, 12, 80, 30, jlbSenha);

		jtfSalario = cp.criarTextField(60, 15, 70, 27, jtfSalario);
		jtfComissao = cp.criarTextField(200, 14, 70, 27, jtfComissao);
		jtfUsuario = cp.criarTextField(335, 14, 150, 27, jtfUsuario);
		jtfSenha = cp.criarTextField(540, 14, 130, 27, jtfSenha);

		jpnInfoCorretor = cp.criarPanel("Criar usuário", 0, 325, 684, 50, jpnInfoCorretor, true);
		jpnInfoCorretor.add(jlbSalario);
		jpnInfoCorretor.add(jtfSalario);
		jpnInfoCorretor.add(jlbComissao);
		jpnInfoCorretor.add(jtfComissao);
		jpnInfoCorretor.add(jlbUsuario);
		jpnInfoCorretor.add(jtfUsuario);
		jpnInfoCorretor.add(jlbSenha);
		jpnInfoCorretor.add(jtfSenha);
		getContentPane().add(jpnInfoCorretor);

	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSalvar) {
			try {
				salvarCorretor();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void salvarCorretor() throws ParseException {
		jtfsValidar.add(jtfNome);
		jtfsValidar.add(jtfRg);
		jtfsValidar.add(jtfCpf);
		jtfsValidar.add(jtfDataNascimento);
		jtfsValidar.add(jtfGenero);
		jtfsValidar.add(jtfTelefoneCelular);
		jtfsValidar.add(jtfTelefoneResidencial);
		jtfsValidar.add(jtfEmail);
		jtfsValidar.add(jtfRua);
		jtfsValidar.add(jtfNumero);
		jtfsValidar.add(jtfBairro);
		jtfsValidar.add(jtfCidade);
		jtfsValidar.add(jtfUf);
		jtfsValidar.add(jtfCep);
		jtfsValidar.add(jtfSalario);
		jtfsValidar.add(jtfComissao);
		jtfsValidar.add(jtfUsuario);
		jtfsValidar.add(jtfSenha);
		Boolean camposPreenchidos = mc.verificaCampos(jtfsValidar, "cadastro_corretor");
		if (camposPreenchidos == true) {
			String nome = jtfNome.getText();
			String rg = jtfRg.getText();
			String cpf = jtfCpf.getText();
			Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(jtfDataNascimento.getText());
			String genero = jtfGenero.getText();
			String estadoCivil = jcbEstadoCivil.getSelectedItem().toString();
			String telefoneResidencial = jtfTelefoneResidencial.getText();
			String telefoneCelular = jtfTelefoneCelular.getText();
			String email = jtfEmail.getText();
			String rua = jtfRua.getText();
			String numero = jtfNumero.getText();
			String bairro  = jtfBairro.getText();
			String cidade = jtfCidade.getText();
			String uf = jtfUf.getText();
			String cep = jtfCep.getText();
			Double salario =  Double.valueOf(jtfSalario.getText());
			String login = jtfUsuario.getText();
			String senha = jtfSenha.getText();
			Integer nivelAcesso = 0; //cadastra como gestor
			
			CadastrarEndereco ce = new CadastrarEndereco();
			Endereco endereco = ce.salvarEndereco(rua, numero, bairro, cidade, uf, cep);
			CadastrarPessoa cp = new CadastrarPessoa();
			Pessoa pessoa = cp.salvarPessoa(nome, rg, cpf, dataNascimento, genero, estadoCivil, telefoneResidencial, telefoneCelular, email,  endereco);
			CadastrarCorretor cc = new CadastrarCorretor();
			Corretor corretor = cc.salvarCorretor(pessoa, salario, login, senha, nivelAcesso);
		}

	}

	public static void main(String[] args) {
		new TelaCadastroCorretor();
	}

}