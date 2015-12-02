package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.CorretorDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import pessoa.Corretor;
import pessoa.Pessoa;
import pessoa.Usuario;

public class TelaListaUsuario extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 3808050315768550191L;

	private JTable jtbUsuarios;

	private DefaultTableModel dtbUsuarios;

	private JScrollPane jspUsuarios;

	private JLabel jlbTitulo, jlbSenha, jlbUsuario, jlbNivel;
	private JTextField jtfUsuario, jtfSenha;

	private JButton jbtEditar, jbtSalvar, jbtCancelar;

	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();

	private JComboBox<String> jcbNivel;

	private JPanel jpnAlterar, jpnOpcoes;

	private Integer idUsuario;

	public TelaListaUsuario() {
		setTitle("Registro de usuários");
		setLayout(null);

		jlbTitulo = new JLabel("Contas de usuário", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 520, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		criarTabela();

		criarComponentes();

		setResizable(false);
		setSize(520, 390);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarComponentes() {
		jbtEditar = criarBotao("EDITAR", 0, 324, 514, 30, jbtEditar);

		jbtEditar.setBackground(new Color(23, 20, 21));
		jbtEditar.setForeground(Color.white);

		jlbUsuario = criarLabel("Login:", 10, 0, 100, 30, jlbUsuario);
		jlbSenha = criarLabel("Senha:", 160, 0, 100, 30, jlbSenha);
		jlbNivel = criarLabel("Acesso:", 280, 0, 100, 30, jlbNivel);

		jtfUsuario = criarTextField(50, 6, 100, 24, jtfUsuario);
		jtfSenha = criarTextField(205, 6, 70, 24, jtfSenha);

		jcbNivel = new JComboBox<>();
		jcbNivel.setBounds(330, 6, 181, 24);
		jcbNivel.addItem("Nível 0-Gestor-Acesso total");
		jcbNivel.addItem("Nível 1-Corretor-Acesso parcial");
		jcbNivel.setVisible(true);
		getContentPane().add(jcbNivel);

		jpnAlterar = criarPanel("", 0, 324, 514, 35, jpnAlterar, false);
		jpnAlterar.add(jlbUsuario);
		jpnAlterar.add(jtfUsuario);
		jpnAlterar.add(jlbSenha);
		jpnAlterar.add(jtfSenha);
		jpnAlterar.add(jlbNivel);
		jpnAlterar.add(jcbNivel);
		jpnAlterar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));

		jbtSalvar = criarBotao("SALVAR", 5, 2, 100, 30, jbtSalvar);
		jbtCancelar = criarBotao("CANCELAR", 105, 2, 100, 30, jbtCancelar);

		jbtSalvar.setBackground(new Color(23, 20, 20));
		jbtSalvar.setForeground(Color.green);

		jbtCancelar.setBackground(new Color(23, 20, 20));
		jbtCancelar.setForeground(Color.white);

		jpnOpcoes = criarPanel("", 155, 360, 210, 35, jpnOpcoes, false);
		jpnOpcoes.add(jbtSalvar);
		jpnOpcoes.add(jbtCancelar);
		jpnOpcoes.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));

	}

	private void criarTabela() {
		jtbUsuarios = new JTable();
		getContentPane().add(jtbUsuarios);
		dtbUsuarios = new DefaultTableModel();

		dtbUsuarios.addColumn("ID");
		dtbUsuarios.addColumn("Login");
		dtbUsuarios.addColumn("Acesso");
		dtbUsuarios.addColumn("Corretor");

		jtbUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbUsuarios.setModel(dtbUsuarios);
		jspUsuarios = new JScrollPane(jtbUsuarios);
		jspUsuarios.setBounds(0, 44, 515, 280);
		jspUsuarios.setVisible(true);
		getContentPane().add(jspUsuarios);

		jtbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtbUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtbUsuarios.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtbUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);

		alimentaTable();

	}

	public void alimentaTable() {
		dtbUsuarios.setRowCount(0);
		for (Usuario usuario : usuarioDao.todos()) {
			Integer idCorretor = usuario.getCorretor().getIdCorretor();
			Corretor corretor = corretorDao.buscar(idCorretor);
			Pessoa pessoa = pessoaDao.buscar(corretor.getPessoa().getId());
			dtbUsuarios.addRow(new String[] { String.valueOf(usuario.getIdUsuario()), usuario.getLogin(),
					String.valueOf(usuario.getNivelAcesso()), pessoa.getNome() });
		}
	}

	public Boolean verificarCampos(List<JTextField> componentes) {
		Boolean passou = true;
		for (JTextField cp : componentes) {
			if (cp.getText().equals("")) {
				passou = false;
			}
		}
		return passou;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtEditar) {
			editar();
		}
		if (e.getSource() == jbtCancelar) {
			cancelar();
		}
		if (e.getSource() == jbtSalvar) {
			salvar();
		}

	}

	private void salvar() {
		Usuario usuario = usuarioDao.buscar(idUsuario);
		usuario.setLogin(jtfUsuario.getText());
		usuario.setSenha(jtfSenha.getText());
		usuario.setNivelAcesso(jcbNivel.getSelectedIndex());

		ArrayList<JTextField> jtf = new ArrayList<>();
		jtf.add(jtfUsuario);
		jtf.add(jtfSenha);
		Boolean camposOk = verificarCampos(jtf);

		if (camposOk) {
			usuarioDao.alterar(usuario);
			JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso");
			alimentaTable();
		} else {
			JOptionPane.showMessageDialog(null,
					"Verifique se os campos login e senha foram preenchidos corretamente e tente novamente.",
					"Erro ao salvar", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void cancelar() {
		setSize(520, 390);
		jpnAlterar.setVisible(false);
		jpnOpcoes.setVisible(false);
		jbtEditar.setVisible(true);

	}

	private void editar() {
		if (jtbUsuarios.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			setSize(520, 431);
			jpnAlterar.setVisible(true);
			jpnOpcoes.setVisible(true);
			jbtEditar.setVisible(false);

			idUsuario = Integer.valueOf(dtbUsuarios.getValueAt(jtbUsuarios.getSelectedRow(), 0).toString());
			Usuario usuario = usuarioDao.buscar(idUsuario);
			jtfUsuario.setText(usuario.getLogin());
			jtfSenha.setText(usuario.getSenha());
			jcbNivel.setSelectedIndex(usuario.getNivelAcesso());

		}

	}

	private JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.addActionListener(this);
		button.setVisible(true);
		getContentPane().add(button);
		return button;

	}

	private JLabel criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label) {
		label = new JLabel(texto);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		getContentPane().add(label);
		return label;

	}

	private JTextField criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		getContentPane().add(textField);
		return textField;

	}

	private JPanel criarPanel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JPanel panel,
			Boolean visibilidade) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(texto));
		panel.setBounds(col, lin, lar, alt);
		panel.setVisible(visibilidade);
		getContentPane().add(panel);
		return panel;

	}

	public static void main(String[] args) {
		new TelaListaUsuario();
	}

}
