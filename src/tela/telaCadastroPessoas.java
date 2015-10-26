package tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class telaCadastroPessoas extends JFrame {
	private JLabel jlbTitulo;
	private JPanel jpnCadastroPessoa;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbEstadoCivil, jlbGenero, jlbTelefoneResidencial, jlbTelefoneCelular;	
	private JTextField jtfNome, jtfRg, jtfCpf, jtfDataNascimento, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular;
	private JComboBox<String> jcbEstadoCivil;	
	
	public telaCadastroPessoas() {
		setTitle("Cadastrar pessoa");
		setLayout(null);
		
		jlbTitulo = new JLabel("CADASTRO DE PESSOA FÍSICA", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 800, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
		jlbNome = new JLabel("Nome:");
		jlbNome.setBounds(10,10,110, 30);
		jlbNome.setVisible(true);
		getContentPane().add(jlbNome);
		
		jlbRg = new JLabel("RG:");
		jlbRg.setBounds(10,40,110, 30);
		jlbRg.setVisible(true);
		getContentPane().add(jlbRg);
		
		jlbCpf = new JLabel("CPF:");
		jlbCpf.setBounds(210,40,110, 30);
		jlbCpf.setVisible(true);
		getContentPane().add(jlbCpf);
		
		jlbDataNascimento = new JLabel("Data de nascimento:");
		jlbDataNascimento.setBounds(420,40,120, 30);
		jlbDataNascimento.setVisible(true);
		getContentPane().add(jlbDataNascimento);
		
		jlbGenero = new JLabel("Gênero:");
		jlbGenero.setBounds(10,70,110, 30);
		jlbGenero.setVisible(true);
		getContentPane().add(jlbGenero);
		
		jlbEstadoCivil = new JLabel("Estado Civil:");
		jlbEstadoCivil.setBounds(210,70,110, 30);
		jlbEstadoCivil.setVisible(true);
		getContentPane().add(jlbEstadoCivil);
		
		jlbTelefoneResidencial = new JLabel("Telefone residencial:");
		jlbTelefoneResidencial.setBounds(420,70,120, 30);
		jlbTelefoneResidencial.setVisible(true);
		getContentPane().add(jlbTelefoneResidencial);
		
		jlbTelefoneCelular = new JLabel("Telefone celular:");
		jlbTelefoneCelular.setBounds(420,100,110, 30);
		jlbTelefoneCelular.setVisible(true);
		getContentPane().add(jlbTelefoneCelular);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(80,14, 560,24);
		jtfNome.setVisible(true);
		getContentPane().add(jtfNome);
		
		jtfRg = new JTextField();
		jtfRg.setBounds(80,44,120,24);
		jtfRg.setVisible(true);
		getContentPane().add(jtfRg);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(280,44,120,24);
		jtfCpf.setVisible(true);
		getContentPane().add(jtfCpf);
		
		jtfDataNascimento = new JTextField();
		jtfDataNascimento.setBounds(550,44,90,24);
		jtfDataNascimento.setVisible(true);
		getContentPane().add(jtfDataNascimento);
		
		jtfGenero = new JTextField();
		jtfGenero.setBounds(80,74,120,24);
		jtfGenero.setVisible(true);
		getContentPane().add(jtfGenero);
		
		jcbEstadoCivil = new JComboBox<>();
		jcbEstadoCivil.setBounds(280, 74, 120, 24);
		jcbEstadoCivil.addItem("Solteiro(a)");
		jcbEstadoCivil.addItem("Casado(a)");
		jcbEstadoCivil.addItem("Divorciado(a)");
		jcbEstadoCivil.addItem("Viúvo(a)");
		jcbEstadoCivil.addItem("Separado(a) Judicialmente");
		jcbEstadoCivil.setSelectedIndex(-1);
		getContentPane().add(jcbEstadoCivil);
		
		jtfTelefoneResidencial = new JTextField();
		jtfTelefoneResidencial.setBounds(540,74,100,24);
		jtfTelefoneResidencial.setVisible(true);
		getContentPane().add(jtfTelefoneResidencial);
		
		jtfTelefoneCelular = new JTextField();
		jtfTelefoneCelular.setBounds(540,104,100,24);
		jtfTelefoneCelular.setVisible(true);
		getContentPane().add(jtfTelefoneCelular);
		
		jpnCadastroPessoa = new JPanel();
		jpnCadastroPessoa.setBounds(20, 50, 655, 265);
		jpnCadastroPessoa.setVisible(true);
		jpnCadastroPessoa.setLayout(null);
		jpnCadastroPessoa.setBorder(
				BorderFactory.createTitledBorder(""));
		getContentPane().add(jpnCadastroPessoa);
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

		setResizable(true);
		setSize(707, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new telaCadastroPessoas();
	}

}
