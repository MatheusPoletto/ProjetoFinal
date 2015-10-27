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

public class TelaListaPessoa extends JFrame{
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
	private Boolean menuVisivel = false;
	private JLabel jlbTitulo;
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public TelaListaPessoa() {
		setTitle("Registro de pessoas");
		setLayout(null);

		criarLabelTitulo();
		criarTabela();
		criarMenu();
		
		cliqueBotao();

		setResizable(false);
		setSize(707, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void cliqueBotao() {
		//Abrir barra com menu
		jbtMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(menuVisivel == false){
					jspPessoas.setBounds(110, 45, 590, 500);
					jtbBarra.setVisible(true);
					menuVisivel = true;
				}else {
					jspPessoas.setBounds(0, 45, 702, 500);
					jtbBarra.setVisible(false);
					menuVisivel = false;
				}
			}
		});
		
		jbtAtualizarPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtbPessoas.setRowCount(0);
				alimentarTabela();	
				JOptionPane.showMessageDialog(null, "Seu registro de pessoas foi atualizado com sucesso!");
			}
		});
		
	}

	private void criarMenu() {
		jbtMenu = new JButton();
		jbtMenu.setBounds(0, 0, 110, 44);
		jbtMenu.setVisible(true);
		jbtMenu.setIcon(new ImageIcon("botoes_png/menu.png"));
		getContentPane().add(jbtMenu);
		
		jbtCriarPessoa = new JButton("NOVO");
		jbtEditarPessoa = new JButton("EDITAR");
		jbtRemoverPessoa = new JButton("REMOVER");
		jbtAtualizarPessoas = new JButton("ATUALIZAR");
		
		jbtCriarPessoa.setBounds(0,0,110,30);
		jbtEditarPessoa.setBounds(0,90,110,30);
		jbtRemoverPessoa.setBounds(0,30,110,30);
		jbtAtualizarPessoas.setBounds(0,60,110,30);

		jtbBarra = new JToolBar();
		jtbBarra.setBackground(Color.white);
		jtbBarra.setOrientation(1);
		jtbBarra.setFloatable(false);
		jtbBarra.setLayout(null);
		jtbBarra.setBounds(0, 44, 110, 500);
		jtbBarra.setVisible(false);
		jtbBarra.add(jbtCriarPessoa);
		jtbBarra.add(jbtEditarPessoa);
		jtbBarra.add(jbtRemoverPessoa);
		jtbBarra.add(jbtAtualizarPessoas);
		getContentPane().add(jtbBarra);
		
	}

	private void criarTabela() {
		jtbPessoas = new JTable();
		getContentPane().add(jtbPessoas);
		dtbPessoas = new DefaultTableModel();
		
		dtbPessoas.addColumn("ID");
		dtbPessoas.addColumn("NOME");
		dtbPessoas.addColumn("RG");
		dtbPessoas.addColumn("CPF");
		dtbPessoas.addColumn("TIPO");
		
		jtbPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbPessoas.setModel(dtbPessoas);
		jspPessoas = new JScrollPane(jtbPessoas);
		jspPessoas.setBounds(0, 45, 702, 500);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);
		
		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(210);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtbPessoas.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		alimentarTabela();
		
	}
	
	private void criarLabelTitulo() {
		jlbTitulo = new JLabel("REGISTRO DE PESSOAS", SwingConstants.CENTER);
		jlbTitulo.setBounds(110, 0, 595, 44);
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
		new TelaListaPessoa();
		
	}
	

}
