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
	private JButton jbtMenu;
	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;
	private Boolean barraVisivel = false;
	private JLabel jlbTitulo;
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public telaProcurarPessoa() {
		setTitle("");
		setLayout(null);

		jlbNome = new JLabel("Nome:");

		jlbRG = new JLabel("RG");

		jlbCpf = new JLabel("CPF");

		jlbNome.setBounds(0, 0, 50, 30);
		jlbRG.setBounds(50, 0, 50, 30);
		jlbCpf.setBounds(100, 0, 50, 30);

		jlbTitulo = new JLabel("REGISTRO DE PESSOAS", SwingConstants.CENTER);
		jlbTitulo.setBounds(110, 0, 595, 44);
		//jlbTitulo.setIcon(new ImageIcon("img/titulo_registropessoas.png"));
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
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
		alimentarDtb();
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtbPessoas);
		jspPessoas = new JScrollPane(jtbPessoas);
		jspPessoas.setBounds(0, 45, 702, 500);
		//jspPessoas.setBounds(65, 0, 736, 500);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);
		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(310);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtbPessoas.getColumnModel().getColumn(3).setPreferredWidth(100);


		jbtEditarPessoa = new JButton("EDITAR");

		jbtRemoverPessoa = new JButton("REMOVER");

		jbtCriarPessoa = new JButton("NOVO");
		
		jbtAtualizarPessoas = new JButton("ATUALIZAR");

	
		jbtMenu = new JButton();
		jbtMenu.setBounds(0, 0, 110, 44);
		jbtMenu.setVisible(true);
		jbtMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(barraVisivel == false){
					jspPessoas.setBounds(100, 45, 600, 500);
					jtbBarra.setVisible(true);
					barraVisivel = true;
				}else {
					jspPessoas.setBounds(0, 45, 702, 500);
					jtbBarra.setVisible(false);
					barraVisivel = false;
				}
				
			}
		});
		jbtMenu.setIcon(new ImageIcon("botoes_png/menu.png"));
		getContentPane().add(jbtMenu);

		jtbBarra = new JToolBar();
		jtbBarra.setBackground(Color.white);
		jtbBarra.setOrientation(1);
		jtbBarra.setFloatable(false);
		jtbBarra.setLayout(null);
		jtbBarra.setBounds(0, 44, 100, 500);
		jtbBarra.setVisible(false);
		//jtbBarra.setBounds(0, 0, 65, 500);
		jtbBarra.add(jbtCriarPessoa);
		jbtCriarPessoa.setBounds(0,0,100,30);
		jtbBarra.add(jbtRemoverPessoa);
		jbtRemoverPessoa.setBounds(0,30,100,30);
		jtbBarra.add(jbtAtualizarPessoas);
		jbtAtualizarPessoas.setBounds(0,60,100,30);
		jtbBarra.add(jbtEditarPessoa);
		jbtEditarPessoa.setBounds(0,90,100,30);
		//jtbBarra.addSeparator();
		jtbBarra.add(jbtAtualizarPessoas);
		getContentPane().add(jtbBarra);

		setResizable(false);
		setSize(707, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void alimentarDtb() {
		for(Corretor corretor: corretorDao.todos()){
			dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf()});
		}
		
		for(Cliente cliente: clienteDao.todos()){
			dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf()});
		}
		
	}

	public static void main(String[] args) {
		new telaProcurarPessoa();
	}
}
