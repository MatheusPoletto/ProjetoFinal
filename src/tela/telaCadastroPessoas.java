package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
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

public class telaCadastroPessoas extends JFrame {
	private JLabel jlbTitulo;
	private JPanel jpnCadastroPessoa, jpnCadastroEndereco, jpnTipoCadastro;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbEstadoCivil, jlbGenero, jlbTelefoneResidencial, jlbTelefoneCelular, jlbEmail;	
	private JLabel jlbRua, jlbNumero, jlbBairro, jlbCidade, jlbUf, jlbCep;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfDataNascimento, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular, jtfEmail;
	private JTextField jtfRua, jtfNumero, jtfBairro, jtfCidade, jtfUf, jtfCep;
	private JComboBox<String> jcbEstadoCivil;	
	private JToolBar jtbBarra;
	private JLabel jlbTipoRegistro;
	private JButton jbtRegistrarCliente, jbtRegistrarCorretor;
	private JTabbedPane jtbTipoRegistro;
	private JPanel jpnCliente, jpnCorretor;	
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	
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
		
		jtbTipoRegistro = new JTabbedPane();
		jtbTipoRegistro.add(jpnCliente, "Cliente");
		jtbTipoRegistro.add(jpnCorretor, "Corretor");
		jtbTipoRegistro.setBounds(20, 345, 655, 120);
		jtbTipoRegistro.setEnabled(false);
		//getContentPane().add(jtbTipoRegistro);
		//frame precisa ficar 707 x 503
		//tabbedpane fica 20, 345, 655, 120
		

		setResizable(false);
		setSize(707, 397);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		jbtRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean passou = verificaCampos();	
				if(passou == true){
					jbtRegistrarCliente.setBackground(Color.BLUE);
					jbtRegistrarCliente.setForeground(Color.WHITE);
					jbtRegistrarCorretor.setBackground(Color.black);
					jbtRegistrarCorretor.setForeground(Color.WHITE);
					
					jtbTipoRegistro.setEnabled(true);
					jtbTipoRegistro.setEnabledAt(1, false);
					jtbTipoRegistro.setEnabledAt(0, true);
					jtbTipoRegistro.setSelectedIndex(0);
					
					Pessoa pessoa = cadastrarPessoaEndereco();
					Cliente cliente = new Cliente(pessoa, clienteDao.maiorId()+1);
					clienteDao.inserir(cliente);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
					
				}
			}
		});
		
		jbtRegistrarCorretor = new JButton("CORRETOR");
		jbtRegistrarCorretor.setVisible(true);
		jbtRegistrarCorretor.setBackground(new Color(23, 20, 20));
		jbtRegistrarCorretor.setForeground(Color.white);
		jbtRegistrarCorretor.setBounds(100, 0, 100, 30);
		jbtRegistrarCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean passou = verificaCampos();	
				if(passou == true){
					jbtRegistrarCorretor.setBackground(Color.BLUE);
					jbtRegistrarCorretor.setForeground(Color.WHITE);
					jbtRegistrarCliente.setBackground(Color.black);
					jbtRegistrarCliente.setForeground(Color.WHITE);
					
					jtbTipoRegistro.setEnabled(true);
					jtbTipoRegistro.setEnabledAt(0, false);
					jtbTipoRegistro.setEnabledAt(1, true);
					jtbTipoRegistro.setSelectedIndex(1);
					
					Pessoa pessoa = cadastrarPessoaEndereco();
					Corretor corretor = new Corretor(pessoa, corretorDao.maiorId(), 1500.0, 10.0);
					corretorDao.inserir(corretor);
					JOptionPane.showMessageDialog(null, "Corretor cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
				}			
			}
		});
		
		jtbBarra = new JToolBar();
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setLayout(null);
		jtbBarra.setBounds(123, 3, 200, 30);
		jtbBarra.setVisible(true);
		jtbBarra.add(jbtRegistrarCliente);
		jtbBarra.add(jbtRegistrarCorretor);
		
		jpnTipoCadastro = new JPanel();
		jpnTipoCadastro.setBounds(350, 325, 325, 35);
		jpnTipoCadastro.setVisible(true);
		jpnTipoCadastro.setLayout(null);
		jpnTipoCadastro.add(jlbTipoRegistro);
		jpnTipoCadastro.add(jtbBarra);
		jpnTipoCadastro.setBorder(
				BorderFactory.createLineBorder(new Color(23, 20, 20),1));
		getContentPane().add(jpnTipoCadastro);
		
	}

	private void criarPainelCadastroPessoa() {		
		jlbNome = new JLabel("Nome:");
		jlbNome.setBounds(10,20,110, 30);
		jlbNome.setVisible(true);
		
		jlbRg = new JLabel("RG:");
		jlbRg.setBounds(10,50,110, 30);
		jlbRg.setVisible(true);
		
		jlbCpf = new JLabel("CPF:");
		jlbCpf.setBounds(210,50,110, 30);
		jlbCpf.setVisible(true);
		
		jlbDataNascimento = new JLabel("Data de nascimento:");
		jlbDataNascimento.setBounds(420,50,120, 30);
		jlbDataNascimento.setVisible(true);
		
		jlbGenero = new JLabel("Gênero:");
		jlbGenero.setBounds(10,80,110, 30);
		jlbGenero.setVisible(true);
		
		jlbEstadoCivil = new JLabel("Estado Civil:");
		jlbEstadoCivil.setBounds(210,80,110, 30);
		jlbEstadoCivil.setVisible(true);
		
		jlbTelefoneResidencial = new JLabel("Tel. fixo:");
		jlbTelefoneResidencial.setBounds(10,110,120, 30);
		jlbTelefoneResidencial.setVisible(true);
		
		jlbTelefoneCelular = new JLabel("Tel. celular:");
		jlbTelefoneCelular.setBounds(210,110,110, 30);
		jlbTelefoneCelular.setVisible(true);
		
		jlbEmail = new JLabel("E-mail:");
		jlbEmail.setBounds(10,140,110, 30);
		jlbEmail.setVisible(true);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(80,24, 560,24);
		jtfNome.setVisible(true);
		
		jtfRg = new JTextField();
		jtfRg.setBounds(80,54,120,24);
		jtfRg.setVisible(true);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(280,54,120,24);
		jtfCpf.setVisible(true);
		
		try {
			jtfDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jtfDataNascimento.setBounds(550,54,90,24);
		jtfDataNascimento.setVisible(true);
		
		jtfGenero = new JTextField();
		jtfGenero.setBounds(80,84,120,24);
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
		jtfTelefoneResidencial.setBounds(80,114,120,24);
		jtfTelefoneResidencial.setVisible(true);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setBounds(280,114,120,24);
		jtfTelefoneCelular.setVisible(true);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(80, 144,320,24);
		jtfEmail.setVisible(true);
		
		jpnCadastroPessoa = new JPanel();
		jpnCadastroPessoa.setBounds(20, 50, 655, 182);
		jpnCadastroPessoa.setVisible(true);
		jpnCadastroPessoa.setLayout(null);
		jpnCadastroPessoa.setBorder(
				BorderFactory.createTitledBorder("Dados pessoais"));
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
		jlbRua.setBounds(10,20,110, 30);
		jlbRua.setVisible(true);
		
		jlbNumero = new JLabel("Nº:");
		jlbNumero.setBounds(510, 20,110, 30);
		jlbNumero.setVisible(true);
		
		jlbBairro = new JLabel("Bairro:");
		jlbBairro.setBounds(10, 50,110, 30);
		jlbBairro.setVisible(true);
		
		jlbCidade = new JLabel("Cidade:");
		jlbCidade.setBounds(210,50,120, 30);
		jlbCidade.setVisible(true);
		
		jlbUf = new JLabel("UF:");
		jlbUf.setBounds(420,50,110, 30);
		jlbUf.setVisible(true);
		
		jlbCep = new JLabel("CEP:");
		jlbCep.setBounds(510,50,110, 30);
		jlbCep.setVisible(true);
		
		jtfRua = new JTextField();
		jtfRua.setBounds(80,24, 420,24);
		jtfRua.setVisible(true);
		
		jtfNumero = new JTextField();
		jtfNumero.setBounds(550,24,90,24);
		jtfNumero.setVisible(true);
		
		jtfBairro = new JTextField();
		jtfBairro.setBounds(80,54,120,24);
		jtfBairro.setVisible(true);
		
		jtfCidade = new JTextField();
		jtfCidade.setBounds(280,54,130,24);
		jtfCidade.setVisible(true);
		
		jtfUf = new JTextField();
		jtfUf.setBounds(450,54,50,24);
		jtfUf.setVisible(true);
		
		jtfCep = new JTextField();
		jtfCep.setBounds(550,54,90,24);
		jtfCep.setVisible(true);
		
		jpnCadastroEndereco = new JPanel();
		jpnCadastroEndereco.setBounds(20, 232, 655, 90);
		jpnCadastroEndereco.setVisible(true);
		jpnCadastroEndereco.setLayout(null);
		jpnCadastroEndereco.setBorder(
				BorderFactory.createTitledBorder("Endereço"));
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
	
	private Boolean verificaCampos(){
		Boolean passou = false;
		if(jtfNome.getText() .equals("") || jtfRg.getText() .equals("") || jtfCpf.getText() .equals("") || jtfDataNascimento.getText() .equals("") ||
				jtfGenero.getText() .equals("") || jcbEstadoCivil.getSelectedIndex() == -1 || jtfEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios e um pareçe estar vazio!\nRevise-os e tente novamente!", "Ops! Erro ao cadastrar uma nova pessoa", JOptionPane.WARNING_MESSAGE);
			passou = true;
		}else {
			passou = true;
		}
		return passou;
	}
	
	private Pessoa cadastrarPessoaEndereco(){
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(jtfDataNascimento.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDao.maiorId()+1);
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
		endereco.setId(enderecoDao.maiorId()+1);
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
}
