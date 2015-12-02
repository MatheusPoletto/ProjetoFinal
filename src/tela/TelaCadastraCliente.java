package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import metodos.CadastrarCliente;
import metodos.CadastrarEndereco;
import metodos.CadastrarPessoa;
import pessoa.Cliente;
import pessoa.Endereco;
import pessoa.Pessoa;
import utilitario.CriarCamponentes;
import utilitario.MensagemAjuda;
import utilitario.MensagemSucesso;
import utilitario.MetodosCheck;

public class TelaCadastraCliente extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = -9105026681880593106L;
	private JLabel jlbTitulo;
	private JPanel jpnCadastroCliente;
	private JLabel jlbNome, jlbRg, jlbCpf, jlbDataNascimento, jlbGenero, jlbEstadoCivil, jlbTelefoneResidencial,
			jlbTelefoneCelular, jlbEmail;
	private JTextField jtfNome, jtfRg, jtfCpf, jtfGenero, jtfTelefoneResidencial, jtfTelefoneCelular, jtfEmail,
			jtfDataNascimento;
	private JComboBox<String> jcbEstadoCivil;
	private JPanel jpnCadastroEndereco;
	private JLabel jlbRua, jlbNumero, jlbCidade, jlbBairro, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfCidade, jtfBairro, jtfUf, jtfCep;
	private JPanel jpnInteresses;
	private JLabel jlbInteresses;
	private JTextField jtfInteresse1, jtfInteresse2, jtfInteresse3;
	private JButton jbtAjuda;
	private JPanel jpnCadastrar;
	private JButton jbtSalvar, jbtLimpar;
	private ArrayList<JTextField> jtfsValidar = new ArrayList<>();
	private CriarCamponentes cp = new CriarCamponentes();
	private MetodosCheck mc = new MetodosCheck();
	private MensagemSucesso ms = new MensagemSucesso();
	private MensagemAjuda ma= new MensagemAjuda();

	public TelaCadastraCliente() {
		setTitle("Cadastro de cliente");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("NOVO CLIENTE", 0, 0, 707, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);

		criarPanelCadastroCliente();

		criarPanelCadastroEndereco();

		criarPanelInteresses();

		criarPanelCadastrar();

		setResizable(false);
		setSize(700, 450);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarPanelCadastrar() {
		jbtSalvar = cp.criarBotao("SALVAR", 110, 2, 100, 30, jbtSalvar);
		jbtSalvar.setBackground(new Color(23, 20, 20));
		jbtSalvar.setForeground(Color.white);
		jbtSalvar.addActionListener(this);

		jbtLimpar = cp.criarBotao("LIMPAR", 10, 2, 100, 30, jbtLimpar);
		jbtLimpar.setBackground(new Color(23, 20, 20));
		jbtLimpar.setForeground(Color.white);
		jbtSalvar.addActionListener(this);
		
		jpnCadastrar = cp.criarPanel("", 463, 372, 220, 34, jpnCadastrar, true);
		jpnCadastrar.add(jbtSalvar);
		jpnCadastrar.add(jbtLimpar);
		jpnCadastrar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnCadastrar);

	}

	private void criarPanelInteresses() {
		jlbInteresses = cp.criarLabel("INTERESSES DE IMÓVEIS:", 10, 2, 150, 30, jlbInteresses);

		jtfInteresse1 = cp.criarTextField(160, 4, 150, 27, jtfInteresse1);
		jtfInteresse2 = cp.criarTextField(311, 4, 150, 27, jtfInteresse2);
		jtfInteresse3 = cp.criarTextField(461, 4, 150, 27, jtfInteresse3);

		jbtAjuda = cp.criarBotao("", 630, 4, 27, 27, jbtAjuda);
		jbtAjuda.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjuda.setOpaque(false);
		jbtAjuda.setBorderPainted(false);
		jbtAjuda.setBackground(new Color(0, 0, 0, 0));

		jpnInteresses = cp.criarPanel("", 0, 330, 684, 35, jpnInteresses, true);
		jpnInteresses.add(jlbInteresses);
		jpnInteresses.add(jtfInteresse1);
		jpnInteresses.add(jtfInteresse2);
		jpnInteresses.add(jtfInteresse3);
		jpnInteresses.add(jbtAjuda);
		jpnInteresses.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnInteresses);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSalvar) {
			salvarCliente();
		}
		if (e.getSource() == jbtAjuda) {
			botaoAjuda();
		}
		if(e.getSource() == jbtLimpar){
			limparCampos();
		}
	}	
	
	private void limparCampos() {
		jtfNome.setText(" ");
		jtfRua.setText(" ");
		jtfBairro.setText(" ");
		jtfNumero.setText(" ");
		jtfCidade.setText(" ");
		jtfUf.setText(" ");
		jtfCep.setText("");
		jtfDataNascimento.setText(" ");
		jtfEmail.setText(" ");
		jtfGenero.setText(" ");
		jtfInteresse1.setText(" ");
		jtfInteresse2.setText(" ");
		jtfInteresse3.setText(" ");
		jtfTelefoneCelular.setText(" ");
		jtfTelefoneResidencial.setText(" ");
		jtfDataNascimento.setText("2015-10-10");
		
	}

	private void botaoAjuda() {
		ma.ajudaCadastroClienteInteresses();
	}

	public static void main(String[] args) {
		new TelaCadastraCliente();
	}
	
	private void salvarCliente() {
		jtfsValidar.add(jtfNome);
		jtfsValidar.add(jtfRg);
		jtfsValidar.add(jtfCpf);		
		Boolean camposPreenchidos = mc.verificaCampos(jtfsValidar, "cadastro_cliente");
		if (camposPreenchidos == true) {
			try {
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
				String interesse1 = jtfInteresse1.getText();
				String interesse2 = jtfInteresse2.getText();
				String interesse3 = jtfInteresse3.getText();
				
				CadastrarEndereco ce = new CadastrarEndereco();
				Endereco endereco = ce.salvarEndereco(rua, numero, bairro, cidade, uf, cep);
				CadastrarPessoa cp = new CadastrarPessoa();
				Pessoa pessoa = cp.salvarPessoa(nome, rg, cpf, dataNascimento, genero, estadoCivil, telefoneResidencial, telefoneCelular, email,  endereco);
				CadastrarCliente cc = new CadastrarCliente();
				Cliente cliente = cc.salvarCliente(pessoa, interesse1, interesse2, interesse3);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}

}
