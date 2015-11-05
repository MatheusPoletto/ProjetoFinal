package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAOFactory.DaoFactoryJDBC;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;

public class telaLogin extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField jtfUsuario;
	private JPasswordField jpfSenha;
	private JLabel jlbUsuario, jlbSenha;
	private JButton jbtEntrar;
	private JLabel jlbIcon1;
	private Integer idUsuario;
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	telaLogin(){
		setTitle("Login");
		setLayout(null);
		
		adicionaComponentes();
		jtfUsuario.setText("login91");
		jpfSenha.setText("senha91");
		setResizable(false);
		setSize(400, 300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	private void adicionaComponentes() {
		jlbUsuario = new JLabel("Nome de usuário", SwingConstants.CENTER);
		jlbSenha = new JLabel("Senha", SwingConstants.CENTER);
		jtfUsuario = new JTextField();
		jpfSenha = new JPasswordField();
		jbtEntrar = new JButton("ENTRAR");
		jlbIcon1 = new JLabel();

		jlbUsuario.setBounds(135, 100, 130, 25);
		jlbSenha.setBounds(135, 160, 130, 25);
		jtfUsuario.setBounds(125, 130, 150, 25);
		jpfSenha.setBounds(125, 190, 150, 25);
		jbtEntrar.setBounds(120, 220, 160, 25);
		jlbIcon1.setBounds(168, 15, 64, 64);

		jlbUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		jlbSenha.setFont(new Font("Arial", Font.BOLD, 14));
		jbtEntrar.addActionListener(this);
		jbtEntrar.setBackground(Color.GREEN);
		jlbIcon1.setIcon(new ImageIcon("img/house158.png"));

		jlbUsuario.setVisible(true);
		jlbSenha.setVisible(true);
		jtfUsuario.setVisible(true);
		jpfSenha.setVisible(true);
		jbtEntrar.setVisible(true);
		jlbIcon1.setVisible(true);

		getContentPane().add(jlbUsuario);
		getContentPane().add(jlbSenha);
		getContentPane().add(jtfUsuario);
		getContentPane().add(jpfSenha);	
		getContentPane().add(jbtEntrar);
		getContentPane().add(jlbIcon1);
	}

	public static void main(String[] args) {
		new telaLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean autenticou = false;
		if(e.getSource() == jbtEntrar){
			for(Usuario usuarios : usuarioDao.todos()){
				if(jtfUsuario.getText().equals(usuarios.getLogin()) && jpfSenha.getText().equals(usuarios.getSenha())){
					idUsuario = usuarios.getIdUsuario();
					telaPrincipal.getTlPrincipal().alteraVisibilidade();
					autenticou = true;
					this.dispose();
				}
			}
			if(autenticou == false){
				JOptionPane.showMessageDialog(null, "Falha ao autenticar");
			}
		}
	}
}

