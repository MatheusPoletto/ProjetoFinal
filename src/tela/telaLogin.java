package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import DAOFactory.DaoFactoryJDBC;
import dao.UsuarioDAO;
import pessoa.Usuario;

public class telaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6804972754057030926L;

	private JTextField jtfUsuario;

	private JPasswordField jpfSenha;

	private JLabel jlbUsuario, jlbSenha, jlbIcon1;

	private JButton jbtEntrar;

	private Usuario usuario;

	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();

	telaLogin() {
		setTitle("ImoSoft - Login");
		setLayout(null);

		adicionaComponentes();

		jtfUsuario.setText("login91");
		jpfSenha.setText("senha91");

		setResizable(false);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void adicionaComponentes() {
		jtfUsuario = new JTextField();
		jpfSenha = new JPasswordField();
		jbtEntrar = new JButton("ENTRAR");
		jlbIcon1 = new JLabel();

		jtfUsuario.setBounds(125, 130, 150, 25);
		jpfSenha.setBounds(125, 190, 150, 25);
		jbtEntrar.setBounds(120, 220, 160, 25);
		jlbIcon1.setBounds(113, 15, 175, 75);

		jbtEntrar.addActionListener(this);
		jbtEntrar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					autenticarUsuario();
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {

			}
		});
		jbtEntrar.setBackground(new Color(144, 230, 158));
		jlbIcon1.setIcon(new ImageIcon("img/logo_imo.png"));

		jtfUsuario.setVisible(true);
		jpfSenha.setVisible(true);
		jbtEntrar.setVisible(true);
		jlbIcon1.setVisible(true);

		getContentPane().add(jtfUsuario);
		getContentPane().add(jpfSenha);
		getContentPane().add(jbtEntrar);
		getContentPane().add(jlbIcon1);

		criarLabel("Usuário", 135, 100, 130, 25, jlbUsuario);
		criarLabel("Senha", 135, 160, 130, 25, jlbSenha);

	}

	public void criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label) {
		label = new JLabel(texto, SwingConstants.CENTER);
		label.setBounds(col, lin, lar, alt);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setVisible(true);
		getContentPane().add(label);

	}

	public void criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		getContentPane().add(textField);

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtEntrar) {
			autenticarUsuario();
		}
	}

	public void autenticarUsuario() {
		Boolean autenticou = false;
		for (Usuario usuarios : usuarioDao.todos()) {
			if (jtfUsuario.getText().equals(usuarios.getLogin()) && jpfSenha.getText().equals(usuarios.getSenha())) {
				usuario = usuarios;
				telaPrincipal.getTlPrincipal().alteraVisibilidade();
				autenticou = true;
				this.dispose();
			}
		}
		if (autenticou == false) {
			JOptionPane.showMessageDialog(null, "Falha ao autenticar");
		}
	}
}
