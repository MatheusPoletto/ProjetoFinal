package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
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
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class TelaCadastraCliente extends JFrame implements ActionListener{
	
	private JLabel jlbTitulo;
	private JPanel jpnCadastroCliente;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbGenero, jlbEstadoCivil, jlbTelefoneResidencial, jlbTelefoneCelular, jlbEmail;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular, jtfEmail, jtfDataNascimento;
	private JComboBox<String> jcbEstadoCivil;
	
	private JPanel jpnCadastroEndereco;
	private JLabel jlbRua, jlbNumero, jlbCidade, jlbBairro, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfCidade, jtfBairro, jtfUf, jtfCep;
	
	private JLabel jlbInteresses;
	private JTextField jtfInteresse1, jtfInteresse2, jtfInteresse3;
	private JButton jbtAjuda;
	private JPanel jpnInteresses;
	
	private JButton jbtSalvar, jbtLimpar;
	private JPanel jpnCadastrar;
	
	private ArrayList<JTextField> jtfsValidar = new ArrayList<>();
	
	
	
	public TelaCadastraCliente() {
		setTitle("Cadastro de cliente");
		setLayout(null);
		
		jlbTitulo = new JLabel("NOVO CLIENTE", SwingConstants.CENTER);
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
		
		jlbInteresses = criarLabel("INTERESSES DE IMÓVEIS:", 10, 2, 150, 30, jlbInteresses);

		jtfInteresse1 = criarTextField(160, 4, 150, 27, jtfInteresse1);
		jtfInteresse2 = criarTextField(311, 4, 150, 27, jtfInteresse2);
		jtfInteresse3 = criarTextField(461, 4, 150, 27, jtfInteresse3);

		jbtAjuda = criarBotao("", 630, 4, 27, 27, jbtAjuda);
		jbtAjuda.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjuda.setOpaque(false);
		jbtAjuda.setBorderPainted(false);
		jbtAjuda.setBackground(new Color(0, 0, 0, 0));

		jpnInteresses = criarPanel("", 0, 330, 684, 35, jpnInteresses, true);
		jpnInteresses.add(jlbInteresses);
		jpnInteresses.add(jtfInteresse1);
		jpnInteresses.add(jtfInteresse2);
		jpnInteresses.add(jtfInteresse3);
		jpnInteresses.add(jbtAjuda);
		jpnInteresses.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		
		
		
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
		
		jtfsValidar.add(jtfNome);
		jtfsValidar.add(jtfRg);
		jtfsValidar.add(jtfCpf);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 450);
		setVisible(true);
		setLocationRelativeTo(null);
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
		new TelaCadastraCliente();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSalvar){
			Boolean camposPreenchidos = verificaCampos(jtfsValidar);
			if(camposPreenchidos == true){
				JOptionPane.showMessageDialog(null, "vou cadastrar");
				
				
			}
		}
		
	}

}
