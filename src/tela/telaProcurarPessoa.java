package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class telaProcurarPessoa extends JFrame{

	private JPanel jpnFiltro;	
	private JLabel jlbNome;
	private JLabel jlbRG;
	private JLabel jlbCpf;
	private JButton jbtEditarSelecionado;
	private JButton jbtRemoverSelecionado;
	private JButton jbtMostrarTodos;
	private JButton jbtCriarNovo;
	private JTable jtbPessoas;
	private JButton jbtVerSelecionado;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;

	public telaProcurarPessoa() {
		setTitle("Pesquisar pessoa física");
		setLayout(null);

		jlbNome = new JLabel("Nome:");

		jlbRG = new JLabel("RG");

		jlbCpf = new JLabel("CPF");

		jlbNome.setBounds(0,0,50,30);
		jlbRG.setBounds(50,0,50,30);
		jlbCpf.setBounds(100,0,50,30);

		jpnFiltro = new JPanel ();
		jpnFiltro.setBounds(200, 3, 400, 40);
		jpnFiltro.setVisible(true);
		jpnFiltro.setLayout(null);
		jpnFiltro.add(jlbNome);
		jpnFiltro.add(jlbRG);
		jpnFiltro.add(jlbCpf);
		jpnFiltro.setBorder(
				BorderFactory.createTitledBorder(""));
		getContentPane().add(jpnFiltro);

		jtbPessoas = new JTable();
		getContentPane().add(jtbPessoas);
		dtbPessoas = new DefaultTableModel();
		dtbPessoas.addColumn("ID");
		dtbPessoas.addColumn("Nome");
		dtbPessoas.addColumn("RG");
		dtbPessoas.addColumn("CPF");
		dtbPessoas.addColumn("Tipo");
		dtbPessoas.addRow(new String[]{"1","Matheus Otavio Poletto", "5.326.968","087.698.198-98","CORRETOR"});
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtbPessoas);
		jspPessoas = new JScrollPane(jtbPessoas);
		jspPessoas.setBounds(1,81, 793, 390);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);

		jbtVerSelecionado = new JButton("Detalhar selecionado");
		jbtVerSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, dtbPessoas.getValueAt(1, jtbPessoas.getSelectedRow()));
			}				
		});

		jbtMostrarTodos = new JButton("Atualizar");

		jbtEditarSelecionado = new JButton("Alterar selecionado");

		jbtRemoverSelecionado = new JButton("Remover selecionado");
		
		jbtCriarNovo = new JButton("Criar novo");
		
		jtbBarra = new JToolBar();
		jtbBarra.setOrientation(0);
		jtbBarra.setFloatable(false);
		jtbBarra.setBounds(0, 50, 800, 30);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtVerSelecionado);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtMostrarTodos);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtEditarSelecionado);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtRemoverSelecionado);
		jtbBarra.addSeparator();
		jtbBarra.add(jbtCriarNovo);
		getContentPane().add(jtbBarra);

		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
}
