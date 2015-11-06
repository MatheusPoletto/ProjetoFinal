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
import javax.swing.JInternalFrame;
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
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;

public class TelaAlterarPessoa extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 835773138459611748L;
	private JLabel jlbTitulo, jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbEstadoCivil, jlbGenero,
			jlbTelefoneResidencial, jlbTelefoneCelular, jlbEmail, jlbRua, jlbNumero, jlbBairro, jlbCidade, jlbUf,
			jlbCep, jlbInteresses, jlbSalario, jlbComissao;
	private JPanel jpnCadastroPessoa, jpnCadastroEndereco, jpnInteresses, jpnInfoCorretor;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfDataNascimento, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular,
			jtfEmail, jtfRua, jtfNumero, jtfBairro, jtfCidade, jtfUf, jtfCep, jtfInteresse1, jtfInteresse2,
			jtfInteresse3, jtfSalario, jtfComissao;
	private JComboBox<String> jcbEstadoCivil;
	private JButton jbtAjuda, jbtSalvar, jbtCancelar;
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private Integer idPessoa = null;
	private String tipo = null;
	private ArrayList<JTextField> componentes = new ArrayList<>();

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
	
	public TelaAlterarPessoa() {
		setTitle("Alterar pessoa");
		setLayout(null);

		jlbTitulo = new JLabel("ALTERAR PESSOA CADASTRADA", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		criarPainelCadastroPessoa();
		criarPainelEndereco();
		criarPainelNovoCliente();
		criarPainelNovoCorretor();

		jbtSalvar = criarBotao("SALVAR", 497, 330, 81, 25, jbtSalvar);
		jbtSalvar.setBackground(new Color(23, 20, 21));
		jbtSalvar.setForeground(Color.green);
		
		jbtCancelar = criarBotao("CANCELAR", 579, 330, 97, 25, jbtCancelar);
		jbtCancelar.setBackground(new Color(23, 20, 21));
		jbtCancelar.setForeground(Color.white);
		
		componentes.add(jtfNome);
		componentes.add(jtfRg);
		componentes.add(jtfCpf);
		componentes.add(jtfDataNascimento);
		componentes.add(jtfGenero);
		componentes.add(jtfTelefoneResidencial);
		componentes.add(jtfTelefoneCelular);
		componentes.add(jtfEmail);
		componentes.add(jtfRua);
		componentes.add(jtfNumero);
		componentes.add(jtfBairro);
		componentes.add(jtfCidade);
		componentes.add(jtfUf);
		componentes.add(jtfCep);

		setResizable(false);
		setSize(707, 397);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarPainelNovoCorretor() {
		jlbSalario = criarLabel("Salário:", 10, 0, 80, 30, jlbSalario);
		jlbComissao = criarLabel("Comissão:", 105, 0, 80, 30, jlbComissao);

		jtfSalario = criarTextField(55, 4, 50, 27, jtfSalario);
		jtfComissao = criarTextField(167, 4, 35, 27, jtfComissao);

		jpnInfoCorretor = criarPanel("", 20, 325, 465, 35, jpnInfoCorretor, false);
		jpnInfoCorretor.add(jlbSalario);
		jpnInfoCorretor.add(jtfSalario);
		jpnInfoCorretor.add(jlbComissao);
		jpnInfoCorretor.add(jtfComissao);
		jpnInfoCorretor.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));

	}

	private void criarPainelNovoCliente() {
		jlbInteresses = criarLabel("INTERESSES DE IMÓVEIS:", 10, 0, 150, 30, jlbInteresses);

		jtfInteresse1 = criarTextField(160, 4, 90, 27, jtfInteresse1);
		jtfInteresse2  = criarTextField(251, 4, 90, 27, jtfInteresse2);
		jtfInteresse3 = criarTextField(324, 4, 90, 27, jtfInteresse3);
		
		jbtAjuda = criarBotao("", 434, 4, 27, 27, jbtAjuda);
		jbtAjuda.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjuda.setOpaque(false);
		jbtAjuda.setBorderPainted(false);
		jbtAjuda.setBackground(new Color(0, 0, 0, 0));

		jpnInteresses = criarPanel("", 20, 325, 465, 35, jpnInteresses, false);
		jpnInteresses.add(jlbInteresses);
		jpnInteresses.add(jtfInteresse1);
		jpnInteresses.add(jtfInteresse2);
		jpnInteresses.add(jtfInteresse3);
		jpnInteresses.add(jbtAjuda);
		jpnInteresses.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));

	}

	private void criarPainelCadastroPessoa() {
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

		jpnCadastroPessoa = criarPanel("Dados pessoais", 20, 50, 655, 182, jpnCadastroPessoa, true);
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
		
	}

	private void criarPainelEndereco() {
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

		jpnCadastroEndereco = criarPanel("Endereço", 20, 232, 655, 90, jpnCadastroEndereco, true);
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

	public static void main(String[] args) {
		new TelaAlterarPessoa();
	}

	private Boolean verificaCampos(List<JTextField> componentes) {
		Boolean passou = true;
		for (JTextField cp : componentes) {
			if (cp.getText().equals("")) {
				passou = false;
			}
		}
		return passou;
	}

	private Pessoa alteraPessoaEndereco() {
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(jtfDataNascimento.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Pessoa pessoa = pessoaDao.buscar(idPessoa);
		pessoa.setNome(jtfNome.getText());
		pessoa.setRg(jtfRg.getText());
		pessoa.setCpf(jtfCpf.getText());
		pessoa.setDataNascimento(data);
		pessoa.setGenero(jtfGenero.getText());
		pessoa.setEstadoCivil(jcbEstadoCivil.getSelectedItem().toString());
		pessoa.setTelefoneResidencial(jtfTelefoneResidencial.getText());
		pessoa.setTelefoneCelular(jtfTelefoneCelular.getText());
		pessoa.setEmail(jtfEmail.getText());

		Endereco endereco = enderecoDao.buscar(pessoa.getEndereco().getId());
		endereco.setRua(jtfRua.getText());
		endereco.setNumero(jtfNumero.getText());
		endereco.setBairro(jtfBairro.getText());
		endereco.setCidade(jtfCidade.getText());
		endereco.setUf(jtfUf.getText());
		endereco.setCep(jtfCep.getText());
		enderecoDao.alterar(endereco);

		pessoa.setEndereco(endereco);
		pessoaDao.alterar(pessoa);

		return pessoa;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSalvar) {
			ArrayList<JTextField> jtf = new ArrayList<>();
			jtf.add(jtfNome);
			jtf.add(jtfRg);
			jtf.add(jtfCpf);
			jtf.add(jtfDataNascimento);
			jtf.add(jtfGenero);
			jtf.add(jtfEmail);
			Boolean camposOk = verificaCampos(jtf);

			if (camposOk) {
				if (tipo.equals("CLIENTE")) {
					Pessoa pessoa = alteraPessoaEndereco();
					Cliente cliente = new Cliente();
					for (Cliente cliente1 : clienteDao.todos()) {
						if (cliente1.getPessoa().getId() == idPessoa) {
							cliente.setIdCliente(cliente1.getIdCliente());
							cliente.setInteresse1(jtfInteresse1.getText());
							cliente.setInteresse2(jtfInteresse2.getText());
							cliente.setInteresse3(jtfInteresse3.getText());
						}
					}
					clienteDao.alterar(cliente);
					JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso!",
							JOptionPane.PLAIN_MESSAGE);

				}
				if (tipo.equals("CORRETOR")) {
					Pessoa pessoa = alteraPessoaEndereco();
					Corretor corretor = new Corretor();
					for (Corretor corretor1 : corretorDao.todos()) {
						if (corretor1.getPessoa().getId() == idPessoa) {
							corretor.setIdCorretor(corretor1.getIdCorretor());
							corretor.setSalario(Double.valueOf(jtfSalario.getText()));
							corretor.setPorcentagemComissao(Double.valueOf(jtfComissao.getText()));
						}
					}
					corretorDao.alterar(corretor);
					JOptionPane.showMessageDialog(null, "Corretor alterado com sucesso!", "Sucesso!",
							JOptionPane.PLAIN_MESSAGE);
				}
				telaPrincipal.getTlPrincipal().getTlAlterarPessoa().setVisible(false);
				telaPrincipal.getTlPrincipal().getTlListaPessoas().setVisible(true);
				telaPrincipal.getTlPrincipal().getTlListaPessoas().atualizarPessoas();
			}
		}
		if (e.getSource() == jbtAjuda) {
			JOptionPane.showMessageDialog(null,
					"Sempre que adicionar um novo cliente, você pode atribuir 3 interesses a ele.\nEsses interesses definem o que seu cliente procura nos imóveis.\nPor exemplo: barato, grande, mansão.\nNÃO É OBRIGATÓRIO!",
					"Ajuda", JOptionPane.PLAIN_MESSAGE);
		}
		if (e.getSource() == jbtCancelar) {
			telaPrincipal.getTlPrincipal().getTlAlterarPessoa().setVisible(false);
			telaPrincipal.getTlPrincipal().getTlListaPessoas().setVisible(true);
		}

	}

	public void preencherCampos(Integer idPessoa, String tipo) {
		this.idPessoa = idPessoa;
		this.tipo = tipo;
		Pessoa pessoa = pessoaDao.buscar(idPessoa);
		jtfNome.setText(pessoa.getNome());
		jtfRg.setText(pessoa.getRg());
		jtfCpf.setText(pessoa.getCpf());
		jtfDataNascimento.setText(pessoa.getDataNascimento().toString());
		jtfGenero.setText(pessoa.getGenero());
		jtfTelefoneResidencial.setText(pessoa.getTelefoneResidencial());
		jtfTelefoneCelular.setText(pessoa.getTelefoneCelular());
		jtfEmail.setText(pessoa.getEmail());
		jtfRua.setText(pessoa.getEndereco().getRua());
		jtfNumero.setText(pessoa.getEndereco().getNumero());
		jtfBairro.setText(pessoa.getEndereco().getBairro());
		jtfCidade.setText(pessoa.getEndereco().getCidade());
		jtfUf.setText(pessoa.getEndereco().getUf());
		jtfCidade.setText(pessoa.getEndereco().getCidade());
		jtfCep.setText(pessoa.getEndereco().getCep());

		if (pessoa.getEstadoCivil().equals("Solteiro(a)")) {
			jcbEstadoCivil.setSelectedIndex(0);
		}
		if (pessoa.getEstadoCivil().equals("Casado(a)")) {
			jcbEstadoCivil.setSelectedIndex(1);
		}
		if (pessoa.getEstadoCivil().equals("Divorciado(a)")) {
			jcbEstadoCivil.setSelectedIndex(2);
		}
		if (pessoa.getEstadoCivil().equals("Viúvo(a)")) {
			jcbEstadoCivil.setSelectedIndex(3);
		}
		if (pessoa.getEstadoCivil().equals("Separado(a) Judicialmente")) {
			jcbEstadoCivil.setSelectedIndex(4);
		}

		if (tipo.equals("CORRETOR")) {
			jpnInfoCorretor.setVisible(true);
			jpnInteresses.setVisible(false);
			for (Corretor corretor : corretorDao.todos()) {
				if (corretor.getPessoa().getId() == idPessoa) {
					jtfSalario.setText(corretor.getSalario().toString());
					jtfComissao.setText(corretor.getPorcentagemComissao().toString());
				}
			}
		} else if (tipo.equals("CLIENTE")) {
			jpnInteresses.setVisible(true);
			jpnInfoCorretor.setVisible(false);
			for (Cliente cliente : clienteDao.todos()) {
				if (cliente.getPessoa().getId() == idPessoa) {
					jtfInteresse1.setText(cliente.getInteresse1());
					jtfInteresse2.setText(cliente.getInteresse2());
					jtfInteresse3.setText(cliente.getInteresse3());
				}
			}
		}
	}

}
