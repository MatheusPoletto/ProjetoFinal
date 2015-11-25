package tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TelaListaImovel extends JFrame {

	private JLabel jlbTitulo;
	private CriarCamponentes cp = new CriarCamponentes();
	
	private JRadioButton jrbCidade, jrbBairro, jrbValor, jrbMetros;
	private JPanel jpnProcurar;
	private JLabel jlbProcurarPor;
	private JTextField jtfPesquisa;
	private ButtonGroup btgFiltro;
	private JButton jbtFiltrar;
	
	private JTable jtbImovel;
	private DefaultTableModel dtbImovel;
	private JScrollPane jspImovel;
	
	private JPanel jpnImagem;
	private JLabel jlbImg1, jlbImg2, jlbImg3, jlbImg4;
	
	private JButton jbtInfo, jbtAlterar, jbtVender, jbtRemover;
	
	
	
	public TelaListaImovel(){
		setTitle("Meus imóveis");
		setLayout(null);

		jlbTitulo = new JLabel("Meus Imóveis", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 650, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		jlbProcurarPor = cp.criarLabel("Procurar por:", 20, 10, 100, 24, jlbProcurarPor);
		jrbCidade = cp.criarRadioButton("Cidade", 110, 10, 100, 24, jrbCidade);
		jrbBairro = cp.criarRadioButton("Bairro", 210, 10, 100, 24, jrbBairro);
		jrbMetros = cp.criarRadioButton("m²", 310, 10, 100, 24, jrbMetros);
		jrbValor = cp.criarRadioButton("Valor", 410, 10, 100, 24, jrbValor);
		jtfPesquisa = cp.criarTextField(237, 40, 150, 24, jtfPesquisa);
		jbtFiltrar = cp.criarBotao("Procurar", 380, 40, 100, 24, jbtFiltrar);
		
		btgFiltro = new ButtonGroup();
		btgFiltro.add(jrbCidade);
		btgFiltro.add(jrbBairro);
		btgFiltro.add(jrbMetros);
		btgFiltro.add(jrbValor);
		
		jpnProcurar = cp.criarPanel("Procurar", 10, 50, 625, 80, jpnProcurar, true);
		jpnProcurar.add(jlbProcurarPor);
		jpnProcurar.add(jrbCidade);
		jpnProcurar.add(jrbBairro);
		jpnProcurar.add(jrbMetros);
		jpnProcurar.add(jrbValor);
		jpnProcurar.add(jtfPesquisa);
		jpnProcurar.add(jbtFiltrar);
		getContentPane().add(jpnProcurar);
		
		jtbImovel = new JTable();
		getContentPane().add(jtbImovel);
		dtbImovel = new DefaultTableModel();

		dtbImovel.addColumn("Bairro");
		dtbImovel.addColumn("Cidade");
		dtbImovel.addColumn("M²");
		dtbImovel.addColumn("Valor");

		jtbImovel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbImovel.setModel(dtbImovel);
		jspImovel = new JScrollPane(jtbImovel);
		jspImovel.setBounds(10, 140, 500, 100);
		jspImovel.setVisible(true);
		getContentPane().add(jspImovel);

		jtbImovel.getColumnModel().getColumn(0).setPreferredWidth(170);
		jtbImovel.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtbImovel.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtbImovel.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		jbtInfo = cp.criarBotao("INFO.", 523, 140, 110, 24, jbtInfo);
		getContentPane().add(jbtInfo);
		jbtRemover = cp.criarBotao("REMOVER", 523, 164, 110, 24, jbtRemover);
		getContentPane().add(jbtRemover);
		jbtAlterar = cp.criarBotao("ALTERAR", 523, 188, 110, 24, jbtAlterar);
		getContentPane().add(jbtAlterar);
		jbtVender = cp.criarBotao("VENDER", 523, 212, 110, 24, jbtVender);
		getContentPane().add(jbtVender);
		
		
		jlbImg1 = cp.criarLabel("", 10, 10, 125, 125, jlbImg1);
		jlbImg2 = cp.criarLabel("", 140, 10, 125, 125, jlbImg2);
		jlbImg3 = cp.criarLabel("", 10, 140, 125, 125, jlbImg3);
		jlbImg4 = cp.criarLabel("", 140, 140, 125, 125, jlbImg4);
		
		jlbImg1.setOpaque(true);
		jlbImg1.setBackground(Color.red);
		jlbImg2.setOpaque(true);
		jlbImg2.setBackground(Color.yellow);
		jlbImg3.setOpaque(true);
		jlbImg3.setBackground(Color.green);
		jlbImg4.setOpaque(true);
		jlbImg4.setBackground(Color.blue);
		
		jpnImagem = cp.criarPanel("", 10, 245, 625, 275, jpnImagem, true);
		jpnImagem.add(jlbImg1);
		jpnImagem.add(jlbImg2);
		jpnImagem.add(jlbImg3);
		jpnImagem.add(jlbImg4);
		getContentPane().add(jpnImagem);

		setResizable(false);
		setSize(650, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaListaImovel();
	}
	
}
