package tela;

import java.awt.Color;
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
	/**
	 * 
	 */
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

		jbtSalvar = new JButton("SALVAR");
		jbtSalvar.setBounds(497, 330, 81, 25);
		jbtSalvar.addActionListener(this);
		jbtSalvar.setBackground(new Color(23, 20, 21));
		jbtSalvar.setForeground(Color.green);
		jbtSalvar.setVisible(true);
		getContentPane().add(jbtSalvar);

		jbtCancelar = new JButton("CANCELAR");
		jbtCancelar.setBounds(579, 330, 97, 25);
		jbtCancelar.addActionListener(this);
		jbtCancelar.setBackground(new Color(23, 20, 21));
		jbtCancelar.setForeground(Color.white);
		jbtCancelar.setVisible(true);
		getContentPane().add(jbtCancelar);

		setResizable(false);
		setSize(707, 397);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
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

		jpnInfoCorretor = new JPanel();
		jpnInfoCorretor.setBounds(20, 325, 465, 35);
		jpnInfoCorretor.setVisible(false);
		jpnInfoCorretor.setLayout(null);
		jpnInfoCorretor.add(jlbSalario);
		jpnInfoCorretor.add(jtfSalario);
		jpnInfoCorretor.add(jlbComissao);
		jpnInfoCorretor.add(jtfComissao);
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
		jpnInteresses.setBounds(20, 325, 465, 35);
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
		new TelaAlterarPessoa();
	}

	private Boolean verificaCampos() {
		Boolean passou = false;
		if (jtfNome.getText().equals("") || jtfRg.getText().equals("") || jtfCpf.getText().equals("")
				|| jtfDataNascimento.getText().equals("") || jtfGenero.getText().equals("")
				|| jcbEstadoCivil.getSelectedIndex() == -1 || jtfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Todos os campos são obrigatórios e um pareçe estar vazio!\nRevise-os e tente novamente!",
					"Ops! Erro ao cadastrar uma nova pessoa", JOptionPane.WARNING_MESSAGE);
			passou = true;
		} else {
			passou = true;
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
			Boolean camposOk = verificaCampos();
			if (camposOk == true) {
				if (tipo.equals("CLIENTE")) {
					Pessoa pessoa = alteraPessoaEndereco();
					Cliente cliente = clienteDao.buscar(pessoa.getId());
					cliente.setInteresse1(jtfInteresse1.getText());
					cliente.setInteresse2(jtfInteresse2.getText());
					cliente.setInteresse3(jtfInteresse3.getText());
					clienteDao.alterar(cliente);
					JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso!",
							JOptionPane.PLAIN_MESSAGE);

				}
				if (tipo.equals("CORRETOR")) {
					Pessoa pessoa = alteraPessoaEndereco();
					Corretor corretor = corretorDao.buscar(pessoa.getId());
					corretor.setSalario(Double.valueOf(jtfSalario.getText()));
					corretor.setPorcentagemComissao(Double.valueOf(jtfComissao.getText()));
					corretorDao.alterar(corretor);
					JOptionPane.showMessageDialog(null, "Corretor alterado com sucesso!", "Sucesso!",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		if (e.getSource() == jbtAjuda) {
			JOptionPane.showMessageDialog(null,
					"Sempre que adicionar um novo cliente, você pode atribuir 3 interesses a ele.\nEsses interesses definem o que seu cliente procura nos imóveis.\nPor exemplo: barato, grande, mansão.\nNÃO É OBRIGATÓRIO!",
					"Ajuda", JOptionPane.PLAIN_MESSAGE);
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
			Corretor corretor = corretorDao.buscar(idPessoa);
			jtfSalario.setText(corretor.getSalario().toString());
			jtfComissao.setText(corretor.getPorcentagemComissao().toString());
		} else if (tipo.equals("CLIENTE")) {
			jpnInteresses.setVisible(true);
			jpnInfoCorretor.setVisible(false);
			Cliente cliente = clienteDao.buscar(idPessoa);
			jtfInteresse1.setText(cliente.getInteresse1());
			jtfInteresse2.setText(cliente.getInteresse2());
			jtfInteresse3.setText(cliente.getInteresse3());
		}
	}

}
