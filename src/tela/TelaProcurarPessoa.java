package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import pessoa.Cliente;
import pessoa.Corretor;

public class TelaProcurarPessoa extends JFrame {

	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JLabel jlbTitulo;
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public TelaProcurarPessoa() {
		setTitle("Registro de pessoas");
		setLayout(null);

		criarLabelTitulo();
		criarTabela();
		

		setResizable(false);
		setSize(707, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarTabela() {
		jtbPessoas = new JTable();
		getContentPane().add(jtbPessoas);
		dtbPessoas = new DefaultTableModel();
		
		dtbPessoas.addColumn("ID");
		dtbPessoas.addColumn("NOME");
		dtbPessoas.addColumn("RG");
		
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtbPessoas);
		jspPessoas = new JScrollPane(jtbPessoas);
		jspPessoas.setBounds(0, 45, 500, 200);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);
		
		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(210);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(80);
		
		alimentarTabela();
		
	}
	
	private void criarLabelTitulo() {
		jlbTitulo = new JLabel("SELECIONAR PESSOA", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 500, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
	}
	

	private void alimentarTabela() {
		for(Corretor corretor: corretorDao.todos()){
			dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf() , "CORRETOR"});
		}
		
		for(Cliente cliente: clienteDao.todos()){
			dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf() , "CLIENTE"});
		}
	
	}
	

	public static void main(String[] args) {
		new TelaProcurarPessoa();
		
	}
	
}
