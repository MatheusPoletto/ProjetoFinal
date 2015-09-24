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
		dtbPessoas.addRow(new String[] { "1", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "2", "MATHEUS ARILTON RIBAK", "6.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "3", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "4", "MATHEUS OTAVIO POLETTO", "9.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "5", "MATHEUS ARILTON RIBAK", "6.789.190", "123.432.133-95", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "6", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "7", "MATHEUS OTAVIO POLETTO", "7.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "8", "MATHEUS ARILTON RIBAK", "6.789.190", "123.432.133-95", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "9", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "10", "GELSO FARIA NOME GRANDE ENROLACAO TESTE BEM CHARS PENTA KILL YASUO",
				"5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "11", "MATHEUS ARILTON RIBAK", "8.789.190", "123.432.133-95", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "12", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "13", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "14", "MATHEUS ARILTON RIBAK", "2.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "15", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "16", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "17", "MATHEUS ARILTON RIBAK", "3.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "18", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "19", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "20", "MATHEUS ARILTON RIBAK", "4.789.190", "123.432.133-95", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "21", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "22", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "23", "MATHEUS ARILTON RIBAK", "8.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "24", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "25", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "26", "MATHEUS ARILTON RIBAK", "9.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "27", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "28", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "29", "MATHEUS ARILTON RIBAK", "7.789.190", "123.432.133-95", "GESTOR" });
		dtbPessoas.addRow(new String[] { "30", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "31", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "32", "MATHEUS ARILTON RIBAK", "3.789.190", "123.432.133-95", "GESTOR" });
		dtbPessoas.addRow(new String[] { "33", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "34", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "35", "MATHEUS ARILTON RIBAK", "2.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "36", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "37", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CORRETOR" });
		dtbPessoas.addRow(new String[] { "38", "MATHEUS ARILTON RIBAK", "6.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "39", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "GESTOR" });
		dtbPessoas.addRow(new String[] { "40", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "41", "MATHEUS ARILTON RIBAK", "3.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "42", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "43", "MATHEUS OTAVIO POLETTO", "5.326.968", "087.698.198-98", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "44", "MATHEUS ARILTON RIBAK", "2.789.190", "123.432.133-95", "CLIENTE" });
		dtbPessoas.addRow(new String[] { "45", "BRUNA DA CRUZ", "5.359.478", "897.548.451-98", "CLIENTE" });
	}

	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
}
