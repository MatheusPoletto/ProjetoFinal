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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

public class TelaCadastroCorretor extends JFrame implements ActionListener{
	
	private JLabel jlbTitulo;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbGenero, jlbEstadoCivil, jlbTelefoneResidencial, jlbTelefoneCelular, jlbEmail;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular, jtfEmail, jtfDataNascimento;
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
		
		jlbNome = criarLabel("Nome:", 10, 20, 110, 30, jlbNome);
		jlbRg = criarLabel("RG:", 10, 50, 110, 30, jlbRg);
		jlbCpf = criarLabel("CPF:", 210, 50, 110, 30, jlbCpf);
		jlbDataNascimento = criarLabel("Data de nascimento:", 420, 50, 120, 30, jlbDataNascimento);
		jlbGenero = criarLabel("Gênero:", 10, 80, 110, 30, jlbGenero);
		jlbEstadoCivil = criarLabel("Estado Civil:", 210, 80, 110, 30, jlbEstadoCivil);
		jlbTelefoneResidencial = criarLabel("Tel. fixo:", 10, 110, 120, 30, jlbTelefoneResidencial);
		jlbTelefoneCelular = criarLabel("Tel. celular:", 210, 110, 110, 30, jlbTelefoneCelular);
		jlbEmail = criarLabel("Email:", 10, 140, 110, 30, jlbEmail);

		jtfNome = criarTextField(80, 24, 560, 24, jtfNome);
		jtfRg = criarTextField(80, 54, 120, 24, jtfRg);
		jtfCpf = criarTextField(280, 54, 120, 24, jtfCpf);
		jtfGenero = criarTextField(80, 84, 120, 24, jtfGenero);
		jtfTelefoneResidencial = criarTextField(80, 114, 120, 24, jtfTelefoneResidencial);
		jtfTelefoneCelular = criarTextField(280, 114, 120, 24, jtfTelefoneCelular);
		jtfEmail = criarTextField(80, 144, 320, 24, jtfEmail);

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

		jpnCadastroCliente = criarPanel("Dados Pessoais", 0, 50, 684, 182, jpnCadastroCliente, true);
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
		
		jlbRua = criarLabel("Rua:", 10, 20, 110, 30, jlbRua);
		jlbNumero = criarLabel("Nº:", 510, 20, 110, 30, jlbNumero);
		jlbBairro = criarLabel("Bairro:", 10, 50, 110, 30, jlbBairro);
		jlbCidade = criarLabel("Cidade:", 210, 50, 120, 30, jlbCidade);
		jlbUf = criarLabel("UF:", 420, 50, 110, 30, jlbUf);
		jlbCep = criarLabel("CEP:", 510, 50, 110, 30, jlbCep);

		jtfRua = criarTextField(80, 24, 420, 24, jtfRua);
		jtfNumero = criarTextField(550, 24, 90, 24, jtfNumero);
		jtfBairro = criarTextField(80, 54, 120, 24, jtfBairro);
		jtfCidade = criarTextField(280, 52, 130, 24, jtfCidade);
		jtfUf = criarTextField(450, 54, 50, 24, jtfUf);
		jtfCep = criarTextField(550, 54, 90, 24, jtfCep);

		jpnCadastroEndereco = criarPanel("Endereço", 0, 232, 684, 90, jpnCadastroEndereco, true);
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
		
		jbtSalvar = criarBotao("SALVAR", 110, 2, 100, 30, jbtSalvar);
		jbtSalvar.setBackground(new Color(23, 20, 20));
		jbtSalvar.setForeground(Color.white);

		jbtLimpar = criarBotao("LIMPAR", 10, 2, 100, 30, jbtLimpar);
		jbtLimpar.setBackground(new Color(23, 20, 20));
		jbtLimpar.setForeground(Color.white);


		jpnCadastrar = criarPanel("", 463, 372, 220, 34, jpnCadastrar, true);
		jpnCadastrar.add(jbtSalvar);
		jpnCadastrar.add(jbtLimpar);
		jpnCadastrar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		
		jlbSalario = criarLabel("Salário:", 10, 12, 80, 30, jlbSalario);
		jlbComissao = criarLabel("Comissão:", 135, 12, 80, 30, jlbComissao);
		jlbUsuario = criarLabel("Usuário:", 280, 12, 80, 30, jlbUsuario);
		jlbSenha = criarLabel("Senha:", 495, 12, 80, 30, jlbSenha);
		
		jtfSalario = criarTextField(60, 15, 70, 27, jtfSalario);
		jtfComissao = criarTextField(200, 14, 70, 27, jtfComissao);
		jtfUsuario = criarTextField(335, 14, 150, 27, jtfUsuario);
		jtfSenha = criarTextField(540, 14, 130, 27, jtfSenha);
		
		jpnInfoCorretor = criarPanel("Criar usuário", 0, 325, 684, 50, jpnInfoCorretor, true);
		jpnInfoCorretor.add(jlbSalario);
		jpnInfoCorretor.add(jtfSalario);
		jpnInfoCorretor.add(jlbComissao);
		jpnInfoCorretor.add(jtfComissao);
		jpnInfoCorretor.add(jlbUsuario);
		jpnInfoCorretor.add(jtfUsuario);
		jpnInfoCorretor.add(jlbSenha);
		jpnInfoCorretor.add(jtfSenha);
		
		jtfsValidar.add(jtfNome);
		jtfsValidar.add(jtfRg);
		jtfsValidar.add(jtfCpf);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 450);
		setVisible(true);
	}
	
	public JPanel criarPanel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JPanel panel,
			Boolean visibilidade) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(texto));
		panel.setBounds(col, lin, lar, alt);
		panel.setVisible(visibilidade);
		getContentPane().add(panel);
		return panel;

	}

	public JLabel criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label) {
		label = new JLabel(texto);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		getContentPane().add(label);
		return label;

	}

	public JTextField criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		getContentPane().add(textField);
		return textField;

	}

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.addActionListener(this);
		button.setVisible(true);
		getContentPane().add(button);
		return button;

	}
	
	public Boolean verificaCampos(List<JTextField> componentes) {
		Boolean passou = true;
		for (JTextField cp : componentes) {
			if (cp.getText().equals("")) {
				passou = false;
			}
		}
		if (passou == false) {
			JOptionPane.showMessageDialog(null,
					"Todos os campos são obrigatorios! Preencha corretamente e tente novamente.", "Campos em branco",
					JOptionPane.ERROR_MESSAGE);
		}
		return passou;
	}
	
	public static void main(String[] args) {
		new TelaCadastroCorretor();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSalvar){
			Boolean camposPreenchidos = verificaCampos(jtfsValidar);
			if(camposPreenchidos == true){
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

}