package tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class telaCadastroPessoas extends JFrame {
	private JLabel jlbTitulo;
	private JPanel jpnCadastroPessoa, jpnCadastroEndereco, jpnTipoCadastro;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbEstadoCivil, jlbGenero, jlbTelefoneResidencial, jlbTelefoneCelular;	
	private JLabel jlbRua, jlbNumero, jlbBairro, jlbCidade, jlbUf, jlbCep;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfDataNascimento, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular;
	private JTextField jtfRua, jtfNumero, jtfBairro, jtfCidade, jtfUf, jtfCep;
	private JComboBox<String> jcbEstadoCivil;	
	private JToolBar jtbBarra;
	private JLabel jlbTipoRegistro;
	private JButton jbtRegistrarCliente, jbtRegistrarCorretor;
	
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
		
		jlbTipoRegistro = new JLabel("CADASTRAR COMO");
		jlbTipoRegistro.setBounds(7, 6, 150, 24);
		jlbTipoRegistro.setVisible(true);
		getContentPane().add(jlbTipoRegistro);
		
		jbtRegistrarCliente = new JButton("CLIENTE");
		jbtRegistrarCliente.setVisible(true);
		jbtRegistrarCliente.setBackground(new Color(23, 20, 20));
		jbtRegistrarCliente.setForeground(Color.white);
		jbtRegistrarCliente.setBounds(0, 0, 100, 30);
		
		jbtRegistrarCorretor = new JButton("CORRETOR");
		jbtRegistrarCorretor.setVisible(true);
		jbtRegistrarCorretor.setBackground(new Color(23, 20, 20));
		jbtRegistrarCorretor.setForeground(Color.white);
		jbtRegistrarCorretor.setBounds(100, 0, 100, 30);
		
		jtbBarra = new JToolBar();
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setLayout(null);
		jtbBarra.setBounds(123, 3, 200, 30);
		jtbBarra.setVisible(true);
		jtbBarra.add(jbtRegistrarCliente);
		jtbBarra.add(jbtRegistrarCorretor);
		
		jpnTipoCadastro = new JPanel();
		jpnTipoCadastro.setBounds(350, 292, 325, 35);
		jpnTipoCadastro.setVisible(true);
		jpnTipoCadastro.setLayout(null);
		jpnTipoCadastro.add(jlbTipoRegistro);
		jpnTipoCadastro.add(jtbBarra);
		jpnTipoCadastro.setBorder(
				BorderFactory.createLineBorder(new Color(23, 20, 20),1));
		getContentPane().add(jpnTipoCadastro);

		setResizable(false);
		setSize(707, 365);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		jtfNome = new JTextField();
		jtfNome.setBounds(80,24, 560,24);
		jtfNome.setVisible(true);
		
		jtfRg = new JTextField();
		jtfRg.setBounds(80,54,120,24);
		jtfRg.setVisible(true);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(280,54,120,24);
		jtfCpf.setVisible(true);
		
		jtfDataNascimento = new JTextField();
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
		
		jpnCadastroPessoa = new JPanel();
		jpnCadastroPessoa.setBounds(20, 50, 655, 148);
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
		jpnCadastroPessoa.add(jtfNome);
		jpnCadastroPessoa.add(jtfRg);
		jpnCadastroPessoa.add(jtfCpf);
		jpnCadastroPessoa.add(jtfDataNascimento);
		jpnCadastroPessoa.add(jtfGenero);
		jpnCadastroPessoa.add(jcbEstadoCivil);
		jpnCadastroPessoa.add(jtfTelefoneResidencial);
		jpnCadastroPessoa.add(jtfTelefoneCelular);
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
		jpnCadastroEndereco.setBounds(20, 200, 655, 90);
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

}
