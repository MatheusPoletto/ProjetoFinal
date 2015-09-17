package tela;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private JTable jtbPessoas;
	private JButton jbtVerSelecionado;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	
	public telaProcurarPessoa() {
		setTitle("Pesquisar pessoa física");
		setLayout(null);
		
		jlbNome = new JLabel("Nome:");
		jlbNome.setVisible(true);
		
		jlbRG = new JLabel("RG");
		jlbRG.setVisible(true);
		
		jlbCpf = new JLabel("CPF");
		jlbCpf.setVisible(true);
		
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
		jtbPessoas.setBounds(10,180,560,170);
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
		jspPessoas.setBounds(1,50, 793, 390);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);
		
		jbtVerSelecionado = new JButton("Ver selecionado");
		jbtVerSelecionado.setVisible(true);
		jbtVerSelecionado.setBounds(0, 440, 200, 30);
		getContentPane().add(jbtVerSelecionado);
		
		jbtMostrarTodos = new JButton("Mostrar todos");
		jbtMostrarTodos.setVisible(true);
		jbtMostrarTodos.setBounds(200, 440, 200, 30);
		getContentPane().add(jbtMostrarTodos);
		
		jbtEditarSelecionado = new JButton("Editar selecionado");
		jbtEditarSelecionado.setVisible(true);
		jbtEditarSelecionado.setBounds(400, 440, 200, 30);
		getContentPane().add(jbtEditarSelecionado);
		
		jbtRemoverSelecionado = new JButton("Remover selecionado");
		jbtRemoverSelecionado.setVisible(true);
		jbtRemoverSelecionado.setBounds(600, 440, 200, 30);
		getContentPane().add(jbtRemoverSelecionado);
		
		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
	
}
