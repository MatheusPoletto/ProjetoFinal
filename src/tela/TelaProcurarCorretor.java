package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import pessoa.Cliente;
import pessoa.Corretor;
import utilitario.CriarCamponentes;

public class TelaProcurarCorretor extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = -4879493420031527614L;
	private JTable jtbCorretores;
	private DefaultTableModel dbtCorretores;
	private JScrollPane jspCorretores;
	private JLabel jlbTitulo;
	private JButton jbtSelecionar, jbtPesquisar, jbtAtualizar;
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private CriarCamponentes cp = new CriarCamponentes();

	public TelaProcurarCorretor() {
		setTitle("Selecione o proprietário");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("LOCALIZAR UM CORRETOR", 0, 0, 465, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);

		criarTabela();

		jbtPesquisar = cp.criarBotao("PESQUISAR", 0, 493, 155, 30, jbtPesquisar);
		jbtPesquisar = cp.alterarCorBotoes(jbtPesquisar);
		jbtPesquisar.addActionListener(this);
		getContentPane().add(jbtPesquisar);

		jbtAtualizar = cp.criarBotao("ATUALIZAR", 155, 493, 155, 30, jbtPesquisar);
		jbtAtualizar = cp.alterarCorBotoes(jbtAtualizar);
		jbtAtualizar.addActionListener(this);
		getContentPane().add(jbtAtualizar);

		jbtSelecionar = cp.criarBotao("SELECIONAR", 310, 493, 155, 30, jbtSelecionar);
		jbtSelecionar = cp.alterarCorBotoes(jbtSelecionar);
		jbtSelecionar.addActionListener(this);
		getContentPane().add(jbtSelecionar);

		setResizable(false);
		setClosable(true);
		setSize(475, 560);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarTabela() {
		jtbCorretores = new JTable();
		getContentPane().add(jtbCorretores);
		dbtCorretores = new DefaultTableModel();

		dbtCorretores.addColumn("ID");
		dbtCorretores.addColumn("NOME");
		dbtCorretores.addColumn("RG");

		jtbCorretores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbCorretores.setModel(dbtCorretores);
		jspCorretores = new JScrollPane(jtbCorretores);
		jspCorretores.setBounds(0, 44, 465, 450);
		jspCorretores.setVisible(true);
		getContentPane().add(jspCorretores);

		jtbCorretores.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbCorretores.getColumnModel().getColumn(1).setPreferredWidth(210);
		jtbCorretores.getColumnModel().getColumn(2).setPreferredWidth(80);

		alimentarTable();
	}
	public static void main(String[] args) {
		new TelaProcurarCorretor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtPesquisar) {
			String nome = null;
			Boolean encontrou = false;
			nome = JOptionPane.showInputDialog("Insira  o nome do corretor.");
			if (nome == null || nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Impossivel procurar por um nome vazio.", "Alerta",
						JOptionPane.ERROR_MESSAGE);
			} else {
				dbtCorretores.setRowCount(0);
				for (Corretor corretor : corretorDao.todos()) {
					if (corretor.getPessoa().getNome().toLowerCase().contains(nome.toLowerCase())) {
						encontrou = true;
						dbtCorretores.addRow(new String[] { String.valueOf(corretor.getIdCorretor()),
								corretor.getPessoa().getNome(), String.valueOf(corretor.getPessoa().getRg()) });
					}
				}
				if (encontrou == false) {
					JOptionPane.showMessageDialog(null,
							"Não foi encontrado nenhum nome parecido com [" + nome.toLowerCase() + "].", "Alerta!",
							JOptionPane.WARNING_MESSAGE);
				} else if (encontrou == true) {
					int resultados = dbtCorretores.getRowCount() + 1;
					JOptionPane.showMessageDialog(null,
							"Durante a pesquisa foram encontradas [" + resultados + "] pessoa(as) com o nome [" + nome
									+ "]\nO resultado está sendo exibido na tabela!",
							"Resultado", JOptionPane.PLAIN_MESSAGE);
				}
			}

		}
		if (e.getSource() == jbtAtualizar) {
			alimentarTable();
		}
		if (e.getSource() == jbtSelecionar) {
			if (jtbCorretores.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!", "Alerta!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String id = String.valueOf(dbtCorretores.getValueAt(jtbCorretores.getSelectedRow(), 0));
				Corretor corretor = corretorDao.buscar(Integer.valueOf(id));
				telaPrincipal.getTlPrincipal().getTlCadastrarVenda().selecionouCorretor(corretor);
				this.setVisible(false);
			}
		}

	}

	private void alimentarTable() {
		dbtCorretores.setRowCount(0);
		for (Corretor corretor : corretorDao.todos()) {
			dbtCorretores.addRow(new String[] { String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(),
					corretor.getPessoa().getRg() });
		}

	}

}

