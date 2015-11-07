package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastroImovel extends JFrame implements ActionListener {
	private JLabel jlbTitulo, jlbRua, jlbNumero, jlbBairro, jlbCidade, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfBairro, jtfCidade, jtfUf, jtfCep;
	private JPanel jpnCadastroEndereco;
	private JLabel jlbProprietario;
	private JTextField jtfProprietario;
	private JPanel jpnProprietario;
	private JButton jbtProcurarCliente;
	
	public TelaCadastroImovel() {
		setTitle("Cadastrar pessoa");
		setLayout(null);

		jlbTitulo = new JLabel("CADASTRO DE IMÓVEL", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
		criarPainelEndereco();

		jlbProprietario = criarLabel("Proprietário:", 10, 5, 110, 30, jlbProprietario);
		jtfProprietario = criarTextField(90, 9, 420, 24, jtfProprietario);
		jtfProprietario.setEnabled(false);
		jbtProcurarCliente = criarBotao("PROCURAR", 520, 9, 100, 24, jbtProcurarCliente);
		
		jpnProprietario = criarPanel("", 22, 140, 651, 43, jpnProprietario, true);
		jpnProprietario.add(jlbProprietario);
		jpnProprietario.add(jtfProprietario);
		jpnProprietario.add(jbtProcurarCliente);
		
		setResizable(false);
		setSize(707, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		jpnCadastroEndereco = criarPanel("Endereço", 20, 50, 655, 90, jpnCadastroEndereco, true);
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

	public static void main(String[] args) {
		new TelaCadastroImovel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
