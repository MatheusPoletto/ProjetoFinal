package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

public class TelaListaUsuario extends JFrame implements ActionListener{
	private JTable jtbUsuarios;
	private JLabel jlbTitulo;
	private DefaultTableModel dtbUsuarios;
	private JScrollPane jspUsuarios;
	private JButton jbtEditar, jbtSalvar, jbtCancelar;
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private JLabel jlbSenha, jlbUsuario, jlbNivel;
	private JTextField jtfUsuario, jtfSenha;
	private JComboBox<String> jcbNivel;
	private JPanel jpnAlterar, jpnOpcoes;
	
	public TelaListaUsuario() {
		setTitle("Registro de usuarios");
		setLayout(null);

		jlbTitulo = new JLabel("Contas de usuário", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 400, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
		criarTabela();
		
		jbtEditar = new JButton("EDITAR");
		jbtEditar.setBounds(0, 320, 400, 30);
		jbtEditar.setVisible(true);
		jbtEditar.addActionListener(this);
		jbtEditar.setBackground(new Color(23, 20, 21));
		jbtEditar.setForeground(Color.white);
		getContentPane().add(jbtEditar);
		
		jlbUsuario = new JLabel("Login:");
		jlbUsuario.setBounds(10,0,100,30);
		jlbUsuario.setVisible(true);
		getContentPane().add(jlbUsuario);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(50, 6, 100, 24);
		jtfUsuario.setVisible(true);
		getContentPane().add(jtfUsuario);
		
		jlbSenha = new JLabel("Senha:");
		jlbSenha.setBounds(160,0,100,30);
		jlbSenha.setVisible(true);
		getContentPane().add(jlbSenha);
		
		jtfSenha = new JTextField();
		jtfSenha.setBounds(205, 6, 70, 24);
		jtfSenha.setVisible(true);
		getContentPane().add(jtfSenha);
		
		jlbNivel = new JLabel("Acesso:");
		jlbNivel.setBounds(280,0,100,30);
		jlbNivel.setVisible(true);
		getContentPane().add(jlbNivel);
		
		jcbNivel = new JComboBox<>();
		jcbNivel.setBounds(330, 6, 181, 24);
		jcbNivel.addItem("Nível 0-Gestor-Acesso total");
		jcbNivel.addItem("Nível 1-Corretor-Acesso parcial");
		jcbNivel.setVisible(true);
		getContentPane().add(jcbNivel);
		
		jpnAlterar = new JPanel();
		jpnAlterar.setBounds(0, 324, 514, 35);
		jpnAlterar.setVisible(false);
		jpnAlterar.setLayout(null);
		jpnAlterar.add(jlbUsuario);
		jpnAlterar.add(jtfUsuario);
		jpnAlterar.add(jlbSenha);
		jpnAlterar.add(jtfSenha);
		jpnAlterar.add(jlbNivel);
		jpnAlterar.add(jcbNivel);
		jpnAlterar.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnAlterar);
		
		jbtSalvar = new JButton("SALVAR");
		jbtSalvar.setVisible(true);
		jbtSalvar.setBackground(new Color(23, 20, 20));
		jbtSalvar.setForeground(Color.green);
		jbtSalvar.setBounds(5, 2, 100, 30);
		jbtSalvar.addActionListener(this);
		
		jbtCancelar = new JButton("CANCELAR");
		jbtCancelar.setVisible(true);
		jbtCancelar.setBackground(new Color(23, 20, 20));
		jbtCancelar.setForeground(Color.white);
		jbtCancelar.setBounds(105, 2, 100, 30);
		jbtCancelar.addActionListener(this);
		
		jpnOpcoes = new JPanel();
		jpnOpcoes.setBounds(155, 360, 210, 35);
		jpnOpcoes.setVisible(false);
		jpnOpcoes.setLayout(null);
		jpnOpcoes.add(jbtSalvar);
		jpnOpcoes.add(jbtCancelar);
		jpnOpcoes.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 20), 1));
		getContentPane().add(jpnOpcoes);
		

		setResizable(false);
		setSize(400, 378);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		jspUsuarios.setBounds(0, 44, 397, 280);
		jspUsuarios.setVisible(true);
		getContentPane().add(jspUsuarios);

		jtbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtbUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtbUsuarios.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtbUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
		alimentaTable();
	}
	
	public void alimentaTable() {
		for(Usuario usuario : usuarioDao.todos()){
			Integer idCorretor = usuario.getCorretor().getIdCorretor();
			Corretor corretor = corretorDao.buscar(idCorretor);
			Pessoa pessoa = pessoaDao.buscar(corretor.getPessoa().getId());
			dtbUsuarios.addRow(new String[]{String.valueOf(usuario.getIdUsuario()), usuario.getLogin(), String.valueOf(usuario.getNivelAcesso()), pessoa.getNome()});
		}
	}

	public static void main(String[] args) {
		 new TelaListaUsuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtEditar){
			if(jtbUsuarios.getSelectedRow() == -1){
				JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
			}else{
				setSize(520, 421);
				jlbTitulo.setSize(520,44);
				jspUsuarios.setSize(515, 280);
				jpnAlterar.setVisible(true);
				jpnOpcoes.setVisible(true);
				jbtEditar.setVisible(false);
				
				Usuario usuario = usuarioDao.buscar(Integer.valueOf(dtbUsuarios.getValueAt(jtbUsuarios.getSelectedRow(), 0).toString()));
				jtfUsuario.setText(usuario.getLogin());
				jtfSenha.setText(usuario.getSenha());
				jcbNivel.setSelectedIndex(usuario.getNivelAcesso());
				
			}
		}
		if(e.getSource() == jbtCancelar){
			setSize(400, 378);
			jlbTitulo.setSize(400,44);
			jspUsuarios.setSize(397, 280);
			jpnAlterar.setVisible(false);
			jpnOpcoes.setVisible(false);
			jbtEditar.setVisible(true);
		}
		
	}
	
}
