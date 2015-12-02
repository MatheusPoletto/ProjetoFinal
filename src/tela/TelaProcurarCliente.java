package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
import pessoa.Cliente;
import utilitario.CriarCamponentes;

public class TelaProcurarCliente extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = -4879493420031527614L;
	private JTable jtbClientes;
	private DefaultTableModel dtbClientes;
	private JScrollPane jspClientes;
	private JLabel jlbTitulo;
	private JButton jbtSelecionar, jbtPesquisar, jbtAtualizar;
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private Integer isVenda;
	private CriarCamponentes cp = new CriarCamponentes();

	public TelaProcurarCliente() {
		setTitle("Selecione o proprietário");
		setLayout(null);

		jlbTitulo = new JLabel("LOCALIZAR UM CLIENTE", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 465, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);

		criarTabela();

		jbtPesquisar = cp.criarBotao("PESQUISAR", 0, 493, 155, 30, jbtPesquisar);
		jbtPesquisar.setBackground(new Color(23, 20, 21));
		jbtPesquisar.setForeground(Color.white);
		getContentPane().add(jbtPesquisar);

		jbtAtualizar = cp.criarBotao("ATUALIZAR", 155, 493, 155, 30, jbtPesquisar);
		jbtAtualizar.setBackground(new Color(23, 20, 21));
		jbtAtualizar.setForeground(Color.white);
		getContentPane().add(jbtAtualizar);

		jbtSelecionar = cp.criarBotao("SELECIONAR", 310, 493, 155, 30, jbtSelecionar);
		jbtSelecionar.setBackground(new Color(23, 20, 21));
		jbtSelecionar.setForeground(Color.white);
		getContentPane().add(jbtSelecionar);

		setResizable(false);
		setClosable(true);
		setSize(475, 560);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarTabela() {
		jtbClientes = new JTable();
		getContentPane().add(jtbClientes);
		dtbClientes = new DefaultTableModel();

		dtbClientes.addColumn("ID");
		dtbClientes.addColumn("NOME");
		dtbClientes.addColumn("RG");

		jtbClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbClientes.setModel(dtbClientes);
		jspClientes = new JScrollPane(jtbClientes);
		jspClientes.setBounds(0, 44, 465, 450);
		jspClientes.setVisible(true);
		getContentPane().add(jspClientes);

		jtbClientes.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbClientes.getColumnModel().getColumn(1).setPreferredWidth(210);
		jtbClientes.getColumnModel().getColumn(2).setPreferredWidth(80);

		alimentarTable();
	}

	public static void main(String[] args) {
		new TelaProcurarCliente();
	}

	public Integer getIsVenda() {
		return isVenda;
	}

	public void setIsVenda(Integer isVenda) {
		this.isVenda = isVenda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtPesquisar) {
			String nome = null;
			Boolean encontrou = false;
			nome = JOptionPane.showInputDialog("Insira  o nome do cliente.");
			if (nome == null || nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Impossivel procurar por um nome vazio.", "Alerta",
						JOptionPane.ERROR_MESSAGE);
			} else {
				dtbClientes.setRowCount(0);
				for (Cliente cliente : clienteDao.todos()) {
					if (cliente.getPessoa().getNome().toLowerCase().contains(nome.toLowerCase())) {
						encontrou = true;
						dtbClientes.addRow(new String[] { String.valueOf(cliente.getIdCliente()),
								cliente.getPessoa().getNome(), String.valueOf(cliente.getPessoa().getRg()) });
					}
				}
				if (encontrou == false) {
					JOptionPane.showMessageDialog(null,
							"Não foi encontrado nenhum nome parecido com [" + nome.toLowerCase() + "].", "Alerta!",
							JOptionPane.WARNING_MESSAGE);
				} else if (encontrou == true) {
					int resultados = dtbClientes.getRowCount() + 1;
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
			if (jtbClientes.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para continuar!", "Alerta!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (isVenda == 1) {
					String id = String.valueOf(dtbClientes.getValueAt(jtbClientes.getSelectedRow(), 0));
					Cliente cliente = clienteDao.buscar(Integer.valueOf(id));
					telaPrincipal.getTlPrincipal().getTlCadastrarVenda().selecionouProprietario(cliente);
					this.setVisible(false);
				} else if (isVenda == 0) {
					String id = String.valueOf(dtbClientes.getValueAt(jtbClientes.getSelectedRow(), 0));
					Cliente cliente = clienteDao.buscar(Integer.valueOf(id));
					telaPrincipal.getTlPrincipal().getTlCadastroImovel().selecionouProprietario(cliente);
					this.setVisible(false);
				}
			}
		}

	}

	private void alimentarTable() {
		dtbClientes.setRowCount(0);
		for (Cliente cliente : clienteDao.todos()) {
			dtbClientes.addRow(new String[] { String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(),
					cliente.getPessoa().getRg() });
		}

	}

}
