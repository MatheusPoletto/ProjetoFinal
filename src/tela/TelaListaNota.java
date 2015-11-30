package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.NotaFiscalDAO;
import dao.VendaDAO;
import model.NotaFiscal;
import utilitario.CriarCamponentes;

public class TelaListaNota extends JInternalFrame implements ActionListener{
	private CriarCamponentes cp = new CriarCamponentes();
	private JTable jtbNotas;
	private DefaultTableModel dtbNotas;
	private JScrollPane jspNotas;
	private JButton jbtVer;
	private JLabel jlbTitulo;
	private NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
	private JLabel jlbTotalVendas;
	
	public TelaListaNota() {
		setTitle("Notas Fiscais");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("VENDAS GERADAS", 0, 0, 400, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);
		
		jtbNotas = new JTable();
		getContentPane().add(jtbNotas);
		dtbNotas = new DefaultTableModel();

		dtbNotas.addColumn("ID");
		dtbNotas.addColumn("Data");
		dtbNotas.addColumn("Valor");
		dtbNotas.addColumn("Corretor");

		jtbNotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbNotas.setModel(dtbNotas);
		jspNotas = new JScrollPane(jtbNotas);
		jspNotas.setBounds(3, 44, 379, 395);
		jspNotas.setVisible(true);
		getContentPane().add(jspNotas);

		jtbNotas.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtbNotas.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtbNotas.getColumnModel().getColumn(2).setPreferredWidth(130);
		jtbNotas.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		jbtVer = cp.criarBotao("VISUALIZAR", 250, 443, 130, 24, jbtVer);
		getContentPane().add(jbtVer);
		
		jlbTotalVendas = cp.criarLabel("", 3, 443, 250, 24, jlbTotalVendas);
		getContentPane().add(jlbTotalVendas);
		
		jbtVer.addActionListener(this);
		
		alimentarTabela();

		setSize(400, 510);
		setVisible(true);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TelaListaNota();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtVer){
			NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
			String id =  String.valueOf(dtbNotas.getValueAt(jtbNotas.getSelectedRow(), 0));
			NotaFiscal nf = nfDao.buscar(Integer.valueOf(id));
			telaPrincipal.getTlPrincipal().getTlAlterarNota().setVisible(true);
			telaPrincipal.getTlPrincipal().getTlAlterarNota().preencherCampos(nf.getVenda(), nf, nf.getValorTotal());
		}
		
	}
	
	public void alimentarTabela(){
		Double total = 0.0;
		dtbNotas.setRowCount(0);
		for(NotaFiscal nf : nfDao.todos()){
			total += Double.valueOf(String.format(Locale.US, "%.2g", Math.floor(nf.getValorTotal())));
			dtbNotas.addRow(new String[]{String.valueOf(nf.getIdNotaFiscal()), nf.getDataEmissao(), String.valueOf(nf.getValorTotal()), nf.getVenda().getCorretor().getPessoa().getNome()});
		}
		
		jlbTotalVendas.setText("TOTAL DE VENDAS: R$ "+total);
	}
}
