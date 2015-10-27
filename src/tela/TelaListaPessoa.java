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
import dao.PessoaDAO;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Pessoa;

public class TelaListaPessoa extends JFrame implements ActionListener{
	private JPanel jpnFiltro;
	private JLabel jlbNome;
	private JLabel jlbRG;
	private JLabel jlbCpf;
	private JButton jbtEditarPessoa;
	private JButton jbtRemoverPessoa;
	private JButton jbtAtualizarPessoas;
	private JButton jbtCriarPessoa;
	private JButton jbtMenu;
	private JButton jbtFiltrarCliente;
	private JButton jbtFiltraCorretor;
	private JButton jbtPesquisarRg;
	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;
	private Boolean menuVisivel = false;
	private JLabel jlbTitulo;
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();

	public TelaListaPessoa() {
		setTitle("Registro de pessoas");
		setLayout(null);

		criarLabelTitulo();
		criarTabela();
		criarMenu();

		setResizable(false);
		setSize(707, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void criarMenu() {
		jbtMenu = new JButton();
		jbtMenu.setBounds(0, 0, 110, 44);
		jbtMenu.setVisible(true);
		jbtMenu.addActionListener(this);
		jbtMenu.setIcon(new ImageIcon("botoes_png/menu.png"));
		getContentPane().add(jbtMenu);
		
		jbtCriarPessoa = new JButton("NOVO");
		jbtEditarPessoa = new JButton("EDITAR");
		jbtRemoverPessoa = new JButton("REMOVER");
		jbtAtualizarPessoas = new JButton("ATUALIZAR");
		jbtFiltrarCliente = new JButton("CLIENTES");
		jbtFiltraCorretor = new JButton("CORRETORES");
		jbtPesquisarRg = new JButton("PROCURAR RG");
		
		jbtCriarPessoa.setBounds(0,0,110,30);
		jbtEditarPessoa.setBounds(0,30,110,30);
		jbtRemoverPessoa.setBounds(0,60,110,30);
		jbtAtualizarPessoas.setBounds(0,90,110,30);
		jbtFiltrarCliente.setBounds(0,120,110,30);
		jbtFiltraCorretor.setBounds(0,150, 110, 30);
		jbtPesquisarRg.setBounds(0,180,110,30);
		
		jbtCriarPessoa.addActionListener(this);
		jbtEditarPessoa.addActionListener(this);
		jbtRemoverPessoa.addActionListener(this);
		jbtAtualizarPessoas.addActionListener(this);
		jbtFiltrarCliente.addActionListener(this);
		jbtFiltraCorretor.addActionListener(this);
		jbtPesquisarRg.addActionListener(this);

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
		jtbBarra.add(jbtFiltrarCliente);
		jtbBarra.add(jbtFiltraCorretor);
		jtbBarra.add(jbtPesquisarRg);
		getContentPane().add(jtbBarra);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtMenu){
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
		
		if(e.getSource() == jbtCriarPessoa){
			
		}
		
		if(e.getSource() == jbtEditarPessoa){
			
		}
		
		if(e.getSource() == jbtRemoverPessoa){
			
		}
		
		if(e.getSource() == jbtAtualizarPessoas){
			dtbPessoas.setRowCount(0);
			alimentarTabela();	
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		}
		
		if(e.getSource() == jbtFiltrarCliente){
			dtbPessoas.setRowCount(0);
			for(Cliente cliente: clienteDao.todos()){
				dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf() , "CLIENTE"});
			}
		}
		
		if(e.getSource() == jbtFiltraCorretor){
			dtbPessoas.setRowCount(0);
			for(Corretor corretor: corretorDao.todos()){
				dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf() , "CORRETOR"});
			}
		}
		
		if(e.getSource() == jbtPesquisarRg){
			String rg = null;
			Boolean encontrou = false;
			rg = JOptionPane.showInputDialog("Insira o RG que deseja pesquisa.");
			if(rg == null || rg.equals("")){
				JOptionPane.showMessageDialog(null, "Impossível pesquisar por um RG vazio!", "Alerta!", JOptionPane.ERROR_MESSAGE);
			}else {
				for(Pessoa pessoa : pessoaDao.todos()){
					if(pessoa.getRg().equals(rg)){
						encontrou = true;
						Integer idPessoa = pessoa.getId();
						Corretor corretor = corretorDao.buscar(idPessoa);
						Cliente cliente = clienteDao.buscar(idPessoa);
						dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf() , "CORRETOR"});
						dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf() , "CLIENTE"});
					}
				}
			}
			if(encontrou == false){
				JOptionPane.showMessageDialog(null, "Nenhuma pessoa com o RG " + rg + "foi encontrado!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}else if(encontrou == true){
				JOptionPane.showMessageDialog(null, "Durante a pesquisa encontramos pessoa(as) com o RG informado\nO resultado está sendo exibido na tabela!", "Resultado", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		
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
	
	private void alimentarTabela() {
		for(Corretor corretor: corretorDao.todos()){
			dtbPessoas.addRow(new String[] {String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(), corretor.getPessoa().getRg(), corretor.getPessoa().getCpf() , "CORRETOR"});
		}
		
		for(Cliente cliente: clienteDao.todos()){
			dtbPessoas.addRow(new String[]{String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(), cliente.getPessoa().getRg(), cliente.getPessoa().getCpf() , "CLIENTE"});
		}
	
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
	
	public static void main(String[] args) {
		new TelaListaPessoa();
		
	}
	
}
