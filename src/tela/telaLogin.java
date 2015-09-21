package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class telaLogin extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField jtfUsuario;
	private JPasswordField jpfSenha;
	private JLabel jlbUsuario, jlbSenha;
	private JButton jbtEntrar;
	private JLabel jlbIcon1;
	private String nomeUsuario, senhaUsuario, tipoUsuario;

	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	telaLogin(){
		setTitle("Login");
		setLayout(null);
		
		adicionaComponentes();
		jtfUsuario.setText("Poletto");
		jpfSenha.setText("123456");
		setLocation(250, 130);
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
		if(e.getSource() == jbtEntrar){
			if(jtfUsuario.getText().equals("Poletto") && jpfSenha.getText().equals("123456")){
				nomeUsuario = jtfUsuario.getText();
				senhaUsuario = jpfSenha.getText();
				tipoUsuario = "gestor";
				this.dispose();
				JOptionPane.showMessageDialog(null, "Autenticado com sucesso");
				telaPrincipal.getTlPrincipal().alteraVisibilidade();
			}else {
				JOptionPane.showMessageDialog(null, "Falha ao autenticar");
			}
		}

	}
}
