package tela;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;

public class telaCadastroPessoas extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 3974193162640296208L;
	private JLabel jlbTitulo, jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbEstadoCivil, jlbGenero,
			jlbTelefoneResidencial, jlbTelefoneCelular, jlbEmail, jlbRua, jlbNumero, jlbBairro, jlbCidade, jlbUf,
			jlbCep, jlbTipoRegistro, jlbInteresses, jlbSalario, jlbComissao, jlbUsuario, jlbSenha;
	private JPanel jpnCadastroPessoa, jpnCadastroEndereco, jpnTipoCadastro, jpnInteresses, jpnSalvar, jpnInfoCorretor;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfDataNascimento, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular,
			jtfEmail, jtfRua, jtfNumero, jtfBairro, jtfCidade, jtfUf, jtfCep, jtfInteresse1, jtfInteresse2,
			jtfInteresse3, jtfSalario, jtfComissao, jtfUsuario, jtfSenha;
	private JComboBox<String> jcbEstadoCivil;
	private JToolBar jtbBarra;
	private JButton jbtRegistrarCliente, jbtRegistrarCorretor, jbtAjuda, jbtSalvar, jbtCancelar, jbtLimparCampos;
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private Boolean isCliente = false, isCorretor = false;

	public telaCadastroPessoas() {
		setTitle("Cadastrar pessoa");
		setLayout(null);

		jlbTitulo = new JLabel("CADASTRO DE PESSOA FÍSICA", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		criarPainelCadastroPessoa();
		criarPainelEndereco();
		criarPainelCadastrarComo();
		criarPainelNovoCliente();
		criarPainelNovoCorretor();
		criarPainelFinalizar();

		jbtLimparCampos = new JButton("LIMPAR");
		jbtLimparCampos.setBounds(592, 330, 81, 25);
		jbtLimparCampos.addActionListener(this);
		jbtLimparCampos.setBackground(new Color(23, 20, 21));
		jbtLimparCampos.setForeground(Color.white);
		jbtLimparCampos.setVisible(true);
		getContentPane().add(jbtLimparCampos);

		setResizable(false);
		setSize(707, 397);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarPainelFinalizar() {
		jbtSalvar = new JButton("SALVAR");
		jbtSalvar.setBounds(5, 5, 81, 25);
		jbtSalvar.addActionListener(this);
		jbtSalvar.setBackground(new Color(23, 20, 21));
		jbtSalvar.setForeground(Color.green);
		jbtSalvar.setVisible(true);
		getContentPane().add(jbtSalvar);

		jbtCancelar = new JButton("CANCELAR");
		jbtCancelar.setBounds(84, 5, 97, 25);
		jbtCancelar.addActionListener(this);
		jbtCancelar.setBackground(new Color(23, 20, 21));
		jbtCancelar.setForeground(Color.white);
		jbtCancelar.setVisible(true);
		getContentPane().add(jbtCancelar);

		jpnSalvar = new JPanel();
		jpnSalvar.setBounds(488, 365, 187, 35);
		jpnSalvar.setVisible(false);
		jpnSalvar.setLayout(null);
		jpnSalvar.add(jbtSalvar);
		jpnSalvar.add(jbtCancelar);
		jpnSalvar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnSalvar);

	}

	private void criarPainelNovoCorretor() {
		jlbSalario = new JLabel("Salário:");
		jlbSalario.setBounds(10, 0, 80, 30);
		jlbSalario.setVisible(true);
		getContentPane().add(jlbSalario);

		jtfSalario = new JTextField("1.120");
		jtfSalario.setBounds(55, 4, 50, 27);
		jtfSalario.setVisible(true);
		getContentPane().add(jtfSalario);

		jlbComissao = new JLabel("Comissão:");
		jlbComissao.setBounds(105, 0, 80, 30);
		jlbComissao.setVisible(true);
		getContentPane().add(jlbComissao);

		jtfComissao = new JTextField("10.0");
		jtfComissao.setBounds(167, 4, 35, 27);
		jtfComissao.setVisible(true);
		getContentPane().add(jtfComissao);

		jlbUsuario = new JLabel("Usuário:");
		jlbUsuario.setBounds(203, 0, 80, 30);
		jlbUsuario.setVisible(true);
		getContentPane().add(jlbUsuario);

		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(252, 4, 82, 27);
		jtfUsuario.setVisible(true);
		getContentPane().add(jtfUsuario);

		jlbSenha = new JLabel("Senha:");
		jlbSenha.setBounds(334, 0, 80, 30);
		jlbSenha.setVisible(true);
		getContentPane().add(jlbSenha);

		jtfSenha = new JTextField();
		jtfSenha.setBounds(375, 4, 80, 27);
		jtfSenha.setVisible(true);
		getContentPane().add(jtfSenha);

		jpnInfoCorretor = new JPanel();
		jpnInfoCorretor.setBounds(20, 365, 465, 35);
		jpnInfoCorretor.setVisible(false);
		jpnInfoCorretor.setLayout(null);
		jpnInfoCorretor.add(jlbSalario);
		jpnInfoCorretor.add(jtfSalario);
		jpnInfoCorretor.add(jlbComissao);
		jpnInfoCorretor.add(jtfComissao);
		jpnInfoCorretor.add(jlbUsuario);
		jpnInfoCorretor.add(jtfUsuario);
		jpnInfoCorretor.add(jlbSenha);
		jpnInfoCorretor.add(jtfSenha);
		jpnInfoCorretor.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnInfoCorretor);

	}

	private void criarPainelNovoCliente() {
		jlbInteresses = new JLabel("INTERESSES DE IMÓVEIS:");
		jlbInteresses.setBounds(10, 0, 150, 30);
		jlbInteresses.setVisible(true);
		getContentPane().add(jlbInteresses);

		jtfInteresse1 = new JTextField();
		jtfInteresse1.setBounds(160, 4, 90, 27);
		jtfInteresse1.setVisible(true);
		getContentPane().add(jtfInteresse1);

		jtfInteresse2 = new JTextField();
		jtfInteresse2.setBounds(251, 4, 90, 27);
		jtfInteresse2.setVisible(true);
		getContentPane().add(jtfInteresse2);

		jtfInteresse3 = new JTextField();
		jtfInteresse3.setBounds(342, 4, 90, 27);
		jtfInteresse3.setVisible(true);
		getContentPane().add(jtfInteresse3);

		jbtAjuda = new JButton();
		jbtAjuda.setBounds(434, 4, 27, 27);
		jbtAjuda.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjuda.setOpaque(false);
		jbtAjuda.setBorderPainted(false);
		jbtAjuda.setBackground(new Color(0, 0, 0, 0));
		jbtAjuda.addActionListener(this);
		jbtAjuda.setVisible(true);

		jpnInteresses = new JPanel();
		jpnInteresses.setBounds(20, 365, 465, 35);
		jpnInteresses.setVisible(false);
		jpnInteresses.setLayout(null);
		jpnInteresses.add(jlbInteresses);
		jpnInteresses.add(jtfInteresse1);
		jpnInteresses.add(jtfInteresse2);
		jpnInteresses.add(jtfInteresse3);
		jpnInteresses.add(jbtAjuda);
		jpnInteresses.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnInteresses);

	}

	private void criarPainelCadastrarComo() {
		jlbTipoRegistro = new JLabel("CADASTRAR COMO");
		jlbTipoRegistro.setBounds(7, 6, 150, 24);
		jlbTipoRegistro.setVisible(true);
		getContentPane().add(jlbTipoRegistro);

		jbtRegistrarCliente = new JButton("CLIENTE");
		jbtRegistrarCliente.setVisible(true);
		jbtRegistrarCliente.setBackground(new Color(23, 20, 20));
		jbtRegistrarCliente.setForeground(Color.white);
		jbtRegistrarCliente.setBounds(0, 0, 100, 30);
		jbtRegistrarCliente.addActionListener(this);

		jbtRegistrarCorretor = new JButton("CORRETOR");
		jbtRegistrarCorretor.setVisible(true);
		jbtRegistrarCorretor.setBackground(new Color(23, 20, 20));
		jbtRegistrarCorretor.setForeground(Color.white);
		jbtRegistrarCorretor.setBounds(100, 0, 100, 30);
		jbtRegistrarCorretor.addActionListener(this);

		jtbBarra = new JToolBar();
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setLayout(null);
		jtbBarra.setBounds(123, 3, 200, 30);
		jtbBarra.setVisible(true);
		jtbBarra.add(jbtRegistrarCliente);
		jtbBarra.add(jbtRegistrarCorretor);

		jpnTipoCadastro = new JPanel();
		jpnTipoCadastro.setBounds(20, 325, 325, 35);
		jpnTipoCadastro.setVisible(true);
		jpnTipoCadastro.setLayout(null);
		jpnTipoCadastro.add(jlbTipoRegistro);
		jpnTipoCadastro.add(jtbBarra);
		jpnTipoCadastro.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnTipoCadastro);

	}

	private void criarPainelCadastroPessoa() {
		jlbNome = new JLabel("Nome:");
		jlbNome.setBounds(10, 20, 110, 30);
		jlbNome.setVisible(true);

		jlbRg = new JLabel("RG:");
		jlbRg.setBounds(10, 50, 110, 30);
		jlbRg.setVisible(true);

		jlbCpf = new JLabel("CPF:");
		jlbCpf.setBounds(210, 50, 110, 30);
		jlbCpf.setVisible(true);

		jlbDataNascimento = new JLabel("Data de nascimento:");
		jlbDataNascimento.setBounds(420, 50, 120, 30);
		jlbDataNascimento.setVisible(true);

		jlbGenero = new JLabel("Gênero:");
		jlbGenero.setBounds(10, 80, 110, 30);
		jlbGenero.setVisible(true);

		jlbEstadoCivil = new JLabel("Estado Civil:");
		jlbEstadoCivil.setBounds(210, 80, 110, 30);
		jlbEstadoCivil.setVisible(true);

		jlbTelefoneResidencial = new JLabel("Tel. fixo:");
		jlbTelefoneResidencial.setBounds(10, 110, 120, 30);
		jlbTelefoneResidencial.setVisible(true);

		jlbTelefoneCelular = new JLabel("Tel. celular:");
		jlbTelefoneCelular.setBounds(210, 110, 110, 30);
		jlbTelefoneCelular.setVisible(true);

		jlbEmail = new JLabel("E-mail:");
		jlbEmail.setBounds(10, 140, 110, 30);
		jlbEmail.setVisible(true);

		jtfNome = new JTextField();
		jtfNome.setBounds(80, 24, 560, 24);
		jtfNome.setVisible(true);

		jtfRg = new JTextField();
		jtfRg.setBounds(80, 54, 120, 24);
		jtfRg.setVisible(true);

		jtfCpf = new JTextField();
		jtfCpf.setBounds(280, 54, 120, 24);
		jtfCpf.setVisible(true);

		try {
			jtfDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jtfDataNascimento.setBounds(550, 54, 90, 24);
		jtfDataNascimento.setVisible(true);

		jtfGenero = new JTextField();
		jtfGenero.setBounds(80, 84, 120, 24);
		jtfGenero.setVisible(true);

		jcbEstadoCivil = new JComboBox<>();
		jcbEstadoCivil.setBounds(280, 84, 120, 24);
		jcbEstadoCivil.addItem("Solteiro(a)");
		jcbEstadoCivil.addItem("Casado(a)");
		jcbEstadoCivil.addItem("Divorciado(a)");
		jcbEstadoCivil.addItem("Viúvo(a)");
		jcbEstadoCivil.addItem("Separado(a) Judicialmente");
		jcbEstadoCivil.setSelectedIndex(-1);

		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setBounds(80, 114, 120, 24);
		jtfTelefoneResidencial.setVisible(true);

		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setBounds(280, 114, 120, 24);
		jtfTelefoneCelular.setVisible(true);

		jtfEmail = new JTextField();
		jtfEmail.setBounds(80, 144, 320, 24);
		jtfEmail.setVisible(true);

		jpnCadastroPessoa = new JPanel();
		jpnCadastroPessoa.setBounds(20, 50, 655, 182);
		jpnCadastroPessoa.setVisible(true);
		jpnCadastroPessoa.setLayout(null);
		jpnCadastroPessoa.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
		jpnCadastroPessoa.add(jlbNome);
		jpnCadastroPessoa.add(jlbRg);
		jpnCadastroPessoa.add(jlbCpf);
		jpnCadastroPessoa.add(jlbDataNascimento);
		jpnCadastroPessoa.add(jlbGenero);
		jpnCadastroPessoa.add(jlbEstadoCivil);
		jpnCadastroPessoa.add(jlbTelefoneResidencial);
		jpnCadastroPessoa.add(jlbTelefoneCelular);
		jpnCadastroPessoa.add(jlbEmail);
		jpnCadastroPessoa.add(jtfNome);
		jpnCadastroPessoa.add(jtfRg);
		jpnCadastroPessoa.add(jtfCpf);
		jpnCadastroPessoa.add(jtfDataNascimento);
		jpnCadastroPessoa.add(jtfGenero);
		jpnCadastroPessoa.add(jcbEstadoCivil);
		jpnCadastroPessoa.add(jtfTelefoneResidencial);
		jpnCadastroPessoa.add(jtfTelefoneCelular);
		jpnCadastroPessoa.add(jtfEmail);
		getContentPane().add(jpnCadastroPessoa);

	}

	private void criarPainelEndereco() {
		jlbRua = new JLabel("Rua:");
		jlbRua.setBounds(10, 20, 110, 30);
		jlbRua.setVisible(true);

		jlbNumero = new JLabel("Nº:");
		jlbNumero.setBounds(510, 20, 110, 30);
		jlbNumero.setVisible(true);

		jlbBairro = new JLabel("Bairro:");
		jlbBairro.setBounds(10, 50, 110, 30);
		jlbBairro.setVisible(true);

		jlbCidade = new JLabel("Cidade:");
		jlbCidade.setBounds(210, 50, 120, 30);
		jlbCidade.setVisible(true);

		jlbUf = new JLabel("UF:");
		jlbUf.setBounds(420, 50, 110, 30);
		jlbUf.setVisible(true);

		jlbCep = new JLabel("CEP:");
		jlbCep.setBounds(510, 50, 110, 30);
		jlbCep.setVisible(true);

		jtfRua = new JTextField();
		jtfRua.setBounds(80, 24, 420, 24);
		jtfRua.setVisible(true);

		jtfNumero = new JTextField();
		jtfNumero.setBounds(550, 24, 90, 24);
		jtfNumero.setVisible(true);

		jtfBairro = new JTextField();
		jtfBairro.setBounds(80, 54, 120, 24);
		jtfBairro.setVisible(true);

		jtfCidade = new JTextField();
		jtfCidade.setBounds(280, 54, 130, 24);
		jtfCidade.setVisible(true);

		jtfUf = new JTextField();
		jtfUf.setBounds(450, 54, 50, 24);
		jtfUf.setVisible(true);

		jtfCep = new JTextField();
		jtfCep.setBounds(550, 54, 90, 24);
		jtfCep.setVisible(true);

		jpnCadastroEndereco = new JPanel();
		jpnCadastroEndereco.setBounds(20, 232, 655, 90);
		jpnCadastroEndereco.setVisible(true);
		jpnCadastroEndereco.setLayout(null);
		jpnCadastroEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
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

	public static void main(String[] args) {
		new telaCadastroPessoas();
	}

	private Boolean verificaCampos() {
		Boolean passou = false;
		if (jtfNome.getText().equals("") || jtfRg.getText().equals("") || jtfCpf.getText().equals("")
				|| jtfDataNascimento.getText().equals("") || jtfGenero.getText().equals("")
				|| jcbEstadoCivil.getSelectedIndex() == -1 || jtfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Todos os campos são obrigatórios e um pareçe estar vazio!\nRevise-os e tente novamente!",
					"Ops! Erro ao cadastrar uma nova pessoa", JOptionPane.WARNING_MESSAGE);
			passou = false;
		} else {
			passou = true;
		}
		return passou;
	}

	private Pessoa cadastrarPessoaEndereco() {
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(jtfDataNascimento.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDao.maiorId() + 1);
		pessoa.setNome(jtfNome.getText());
		pessoa.setRg(jtfRg.getText());
		pessoa.setCpf(jtfCpf.getText());
		pessoa.setDataNascimento(data);
		pessoa.setGenero(jtfGenero.getText());
		pessoa.setEstadoCivil(jcbEstadoCivil.getSelectedItem().toString());
		pessoa.setTelefoneResidencial(jtfTelefoneResidencial.getText());
		pessoa.setTelefoneCelular(jtfTelefoneCelular.getText());
		pessoa.setEmail(jtfEmail.getText());

		Endereco endereco = new Endereco();
		endereco.setId(enderecoDao.maiorId() + 1);
		endereco.setRua(jtfRua.getText());
		endereco.setNumero(jtfNumero.getText());
		endereco.setBairro(jtfBairro.getText());
		endereco.setCidade(jtfCidade.getText());
		endereco.setUf(jtfUf.getText());
		endereco.setCep(jtfCep.getText());
		enderecoDao.inserir(endereco);

		pessoa.setEndereco(endereco);
		pessoaDao.inserir(pessoa);

		return pessoa;
	}

	public void desabilitarCamposPessoais() {
		jbtLimparCampos.setVisible(false);
		jpnSalvar.setVisible(true);
		for (Component cp : jpnCadastroPessoa.getComponents()) {
			cp.setEnabled(false);
		}
		for (Component cp : jpnCadastroEndereco.getComponents()) {
			cp.setEnabled(false);
		}
	}

	public void habilitarCamposPessoais() {
		setSize(700, 397);
		jbtRegistrarCliente.setBackground(new Color(23, 20, 20));
		jbtRegistrarCliente.setForeground(Color.white);
		jbtRegistrarCorretor.setBackground(new Color(23, 20, 20));
		jbtRegistrarCorretor.setForeground(Color.white);
		jbtLimparCampos.setVisible(true);
		jpnSalvar.setVisible(false);
		jpnInfoCorretor.setVisible(false);
		jpnInteresses.setVisible(false);
		for (Component cp : jpnCadastroPessoa.getComponents()) {
			cp.setEnabled(true);
		}
		for (Component cp : jpnCadastroEndereco.getComponents()) {
			cp.setEnabled(true);
		}
	}

	public void limparCampos() {
		jtfNome.setText("");
		jtfRg.setText("");
		jtfCpf.setText("");
		jtfDataNascimento.setText("");
		jtfGenero.setText("");
		jcbEstadoCivil.setSelectedIndex(-1);
		jtfTelefoneResidencial.setText("");
		jtfTelefoneCelular.setText("");
		jtfEmail.setText("");
		jtfRua.setText("");
		jtfNumero.setText("");
		jtfBairro.setText("");
		jtfCidade.setText("");
		jtfUf.setText("");
		jtfCidade.setText("");
		jtfCep.setText("");

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtRegistrarCliente) {
			Boolean camposOk = verificaCampos();
			if (camposOk == true) {
				desabilitarCamposPessoais();
				setSize(700, 435);
				jbtRegistrarCliente.setBackground(Color.BLUE);
				jbtRegistrarCliente.setForeground(Color.WHITE);
				jbtRegistrarCorretor.setBackground(Color.black);
				jbtRegistrarCorretor.setForeground(Color.WHITE);

				isCliente = true;
				isCorretor = false;
				jpnInteresses.setVisible(true);
				jpnInfoCorretor.setVisible(false);
			}
		}
		if (e.getSource() == jbtRegistrarCorretor) {
			Boolean camposOk = verificaCampos();
			if (camposOk == true) {
				desabilitarCamposPessoais();
				setSize(700, 435);
				jbtRegistrarCorretor.setBackground(Color.BLUE);
				jbtRegistrarCorretor.setForeground(Color.WHITE);
				jbtRegistrarCliente.setBackground(Color.black);
				jbtRegistrarCliente.setForeground(Color.WHITE);

				isCorretor = true;
				isCliente = false;
				jpnInfoCorretor.setVisible(true);
				jpnInteresses.setVisible(false);
			}
		}
		if (e.getSource() == jbtSalvar) {
			if (isCliente == true) {
				Pessoa pessoa = cadastrarPessoaEndereco();
				Cliente cliente = new Cliente(pessoa, clienteDao.maiorId() + 1);
				cliente.setInteresse1(jtfInteresse1.getText());
				cliente.setInteresse2(jtfInteresse2.getText());
				cliente.setInteresse3(jtfInteresse3.getText());
				clienteDao.inserir(cliente);
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso!",
						JOptionPane.PLAIN_MESSAGE);

			}
			if (isCorretor == true) {
				if(jtfSalario.getText().equals("") || jtfComissao.getText().equals("") || jtfUsuario.getText().equals("") || jtfSenha.getText().equals("")){
					JOptionPane.showMessageDialog(null, "É obrigatório preencher os campos de comissão, salário. Também é necessário informar um nome de usuário e senha para esse corretor poder acessar o sistema!", "Erro ao salvar corretor", JOptionPane.WARNING_MESSAGE);
				}else{
					Pessoa pessoa = cadastrarPessoaEndereco();
					Corretor corretor = new Corretor(pessoa, corretorDao.maiorId() + 1,
						Double.valueOf(jtfSalario.getText()), Double.valueOf(jtfComissao.getText()));
					corretorDao.inserir(corretor);
					Usuario usuario = new Usuario(1, jtfUsuario.getText(), jtfSenha.getText(), corretor, 1);
					usuarioDao.inserir(usuario);
					JOptionPane.showMessageDialog(null, "Corretor cadastrado com sucesso!", "Sucesso!",
						JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		if (e.getSource() == jbtCancelar) {
			habilitarCamposPessoais();
		}
		if (e.getSource() == jbtAjuda) {
			JOptionPane.showMessageDialog(null,
					"Sempre que adicionar um novo cliente, você pode atribuir 3 interesses a ele.\nEsses interesses definem o que seu cliente procura nos imóveis.\nPor exemplo: barato, grande, mansão.\nNÃO É OBRIGATÓRIO!",
					"Ajuda", JOptionPane.PLAIN_MESSAGE);
		}
		if (e.getSource() == jbtLimparCampos) {
			limparCampos();
		}

	}

}
