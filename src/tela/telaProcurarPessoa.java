package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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

import com.mysql.jdbc.log.Log;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.PessoaDAO;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Pessoa;

public class telaProcurarPessoa extends JFrame {

	private JPanel jpnFiltro;
	private JLabel jlbNome;
	private JLabel jlbRG;
	private JLabel jlbCpf;
	private JButton jbtEditarPessoa;
	private JButton jbtRemoverPessoa;
	private JButton jbtAtualizarPessoas;
	private JButton jbtCriarPessoa;
	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public telaProcurarPessoa() {
		setTitle("PESSOAS CADASTRADAS");
		setLayout(null);

		jlbNome = new JLabel("Nome:");

		jlbRG = new JLabel("RG");

		jlbCpf = new JLabel("CPF");

		jlbNome.setBounds(0, 0, 50, 30);
		jlbRG.setBounds(50, 0, 50, 30);
		jlbCpf.setBounds(100, 0, 50, 30);

		jpnFiltro = new JPanel();
		jpnFiltro.setBounds(200, 3, 400, 40);
		jpnFiltro.setVisible(false);
		jpnFiltro.setLayout(null);
		jpnFiltro.add(jlbNome);
		jpnFiltro.add(jlbRG);
		jpnFiltro.add(jlbCpf);
		jpnFiltro.setBorder(BorderFactory.createTitledBorder(""));
		getContentPane().add(jpnFiltro);

		jtbPessoas = new JTable();
		getContentPane().add(jtbPessoas);
		dtbPessoas = new DefaultTableModel();
		dtbPessoas.addColumn("ID");
		dtbPessoas.addColumn("Nome");
		dtbPessoas.addColumn("RG");
		dtbPessoas.addColumn("CPF");
		dtbPessoas.addColumn("Tipo");
		alimentarDtb();
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtbPessoas);
		jspPessoas = new JScrollPane(jtbPessoas);
		jspPessoas.setBounds(1, 75, 793, 300);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);

		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(450);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(4).setPreferredWidth(80);


		jbtEditarPessoa = new JButton();

		jbtRemoverPessoa = new JButton();

		jbtCriarPessoa = new JButton();
		
		jbtAtualizarPessoas = new JButton();

		jbtCriarPessoa.setBackground(Color.white);
		jbtAtualizarPessoas.setBackground(Color.white);
		jbtEditarPessoa.setBackground(Color.white);
		jbtRemoverPessoa.setBackground(Color.white);
		
		jbtCriarPessoa.setIcon(new ImageIcon("botoes_png/adicionar.png"));
		jbtAtualizarPessoas.setIcon(new ImageIcon("botoes_png/atualizar.png"));
		jbtEditarPessoa.setIcon(new ImageIcon("botoes_png/editar.png"));
		jbtRemoverPessoa.setIcon(new ImageIcon("botoes_png/remover.png"));
		
		jbtCriarPessoa.setFocusable(false);
		jbtAtualizarPessoas.setFocusable(false);
		jbtEditarPessoa.setFocusable(false);
		jbtRemoverPessoa.setFocusable(false);

		jtbBarra = new JToolBar();
		jtbBarra.setBackground(Color.white);
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setBounds(0, 0, 800, 60);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtCriarPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtRemoverPessoa);
		jtbBarra.add(jbtEditarPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtEditarPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtAtualizarPessoas);
		getContentPane().add(jtbBarra);

		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void alimentarDtb() {
		for(Corretor corretor: corretorDao.todos()){
			dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf(), "CORRETOR"});
		}
		
		for(Cliente cliente: clienteDao.todos()){
			dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf(), "CLIENTE"});
		}
		
	}

	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
}
