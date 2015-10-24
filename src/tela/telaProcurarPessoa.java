package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
import dao.PessoaDAO;
import pessoa.Pessoa;

public class telaProcurarPessoa extends JFrame {

	private JPanel jpnFiltro;
	private JLabel jlbNome;
	private JLabel jlbRG;
	private JLabel jlbCpf;
	private JButton jbtDetalharPessoa;
	private JButton jbtEditarPessoa;
	private JButton jbtRemoverPessoa;
	private JButton jbtAtualizarPessoas;
	private JButton jbtCriarPessoa;
	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();

	public telaProcurarPessoa() {
		setTitle("Pesquisar pessoa física");
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
		jspPessoas.setBounds(1, 35, 793, 300);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);

		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(450);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(4).setPreferredWidth(80);

		jbtDetalharPessoa = new JButton("Detalhar selecionado");
		jbtDetalharPessoa.setFont(new Font("Arial", Font.PLAIN, 14));
		jbtDetalharPessoa.setBackground(new Color(255, 255, 240));
		jbtDetalharPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"ID: " + dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 0) + "\nNome: "
								+ dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 1) + "\nRG: "
								+ dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 2)

				);
			}
		});

		jbtAtualizarPessoas = new JButton("Atualizar");
		jbtAtualizarPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Atualizar");
			}
		});

		jbtEditarPessoa = new JButton("Alterar selecionado");

		jbtRemoverPessoa = new JButton("Remover selecionado");

		jbtCriarPessoa = new JButton("Criar novo");

		jbtCriarPessoa.setFont(new Font("Arial", Font.PLAIN, 14));
		jbtCriarPessoa.setBackground(new Color(255, 255, 240));
		jbtAtualizarPessoas.setFont(new Font("Arial", Font.PLAIN, 14));
		jbtAtualizarPessoas.setBackground(new Color(255, 255, 240));
		jbtEditarPessoa.setFont(new Font("Arial", Font.PLAIN, 14));
		jbtEditarPessoa.setBackground(new Color(255, 255, 240));
		jbtRemoverPessoa.setFont(new Font("Arial", Font.PLAIN, 14));
		jbtRemoverPessoa.setBackground(new Color(255, 255, 240));

		jtbBarra = new JToolBar();
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setBounds(0, 0, 800, 30);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtDetalharPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtAtualizarPessoas);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtEditarPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtRemoverPessoa);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtCriarPessoa);
		getContentPane().add(jtbBarra);

		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void alimentarDtb() {
		for(Pessoa pessoa: pessoaDao.todos()){
			dtbPessoas.addRow(new String[] {String.valueOf(pessoa.getId()), pessoa.getNome(), pessoa.getRg(), pessoa.getCpf(), "ARRUMAR"});
		}
		
	}

	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
}
