package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.NotaFiscalDAO;
import model.NotaFiscal;
import utilitario.CriarCamponentes;

public class TelaListaNota extends JFrame implements ActionListener{
	private CriarCamponentes cp = new CriarCamponentes();
	private JTable jtbNotas;
	private DefaultTableModel dtbNotas;
	private JScrollPane jspNotas;
	private JButton jbtVer;
	private JLabel jlbTitulo;
	private NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
	
	public TelaListaNota() {
		setTitle("Notas Fiscais");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("NOTAS FISCAIS GERADAS", 0, 0, 400, 44, jlbTitulo);
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
		
		jbtVer.addActionListener(this);
		
		alimentarTabela();

		setSize(400, 510);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TelaListaNota();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtVer){
			
		}
		
	}
	
	private void alimentarTabela(){
		for(NotaFiscal nf : nfDao.todos()){
		dtbNotas.addRow(new String[]{String.valueOf(nf.getIdNotaFiscal()), nf.getDataEmissao(), String.valueOf(nf.getValorTotal()), nf.getVenda().getCorretor().getPessoa().getNome()});
		}
	}
}
