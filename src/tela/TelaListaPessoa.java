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
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.CorretorDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import pessoa.Cliente;
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.Usuario;

public class TelaListaPessoa extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton jbtEditarPessoa, jbtRemoverPessoa, jbtAtualizarPessoas, jbtCriarPessoa, jbtMenu, jbtFiltrarCliente,
			jbtFiltraCorretor, jbtPesquisarRg;
	private JTable jtbPessoas;
	private DefaultTableModel dtbPessoas;
	private JScrollPane jspPessoas;
	private JToolBar jtbBarra;
	private Boolean menuVisivel = false;
	private JLabel jlbTitulo;
	private PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
	private CorretorDAO corretorDao = DaoFactoryJDBC.get().corretorDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private UsuarioDAO usuarioDao = DaoFactoryJDBC.get().usuarioDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();

	public TelaListaPessoa() {
		setTitle("Registro de pessoas");
		setLayout(null);

		criarLabelTitulo();
		criarTabela();
		criarMenu();

		setResizable(false);
		setSize(707, 500);
		setLocation(97, 10);
		setClosable(true);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void criarMenu() {
		jbtCriarPessoa = criarBotao("NOVO", 0, 0, 110, 30, jbtCriarPessoa);
		jbtEditarPessoa = criarBotao("EDITAR", 0, 30, 110, 30, jbtEditarPessoa);
		jbtRemoverPessoa = criarBotao("REMOVER", 0, 60, 110, 30, jbtRemoverPessoa);
		jbtAtualizarPessoas = criarBotao("ATUALIZAR", 0, 90, 110, 30, jbtAtualizarPessoas);
		jbtFiltrarCliente = criarBotao("CLIENTES", 0, 120, 110, 30, jbtFiltraCorretor);
		jbtFiltraCorretor = criarBotao("CORRETORES", 0, 150, 110, 30, jbtFiltraCorretor);
		jbtPesquisarRg = criarBotao("PROCURAR RG", 0, 180, 110, 30, jbtPesquisarRg);

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
		jspPessoas.setBounds(0, 45, 702, 422);
		jspPessoas.setVisible(true);
		getContentPane().add(jspPessoas);

		jtbPessoas.getColumnModel().getColumn(0).setPreferredWidth(46);
		jtbPessoas.getColumnModel().getColumn(1).setPreferredWidth(210);
		jtbPessoas.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtbPessoas.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtbPessoas.getColumnModel().getColumn(4).setPreferredWidth(100);

		alimentarTabela();
	}

	public void alimentarTabela() {
		for (Corretor corretor : corretorDao.todos()) {
			dtbPessoas
					.addRow(new String[] { String.valueOf(corretor.getPessoa().getId()), corretor.getPessoa().getNome(),
							corretor.getPessoa().getRg(), corretor.getPessoa().getCpf(), "CORRETOR" });
		}

		for (Cliente cliente : clienteDao.todos()) {
			dtbPessoas.addRow(new String[] { String.valueOf(cliente.getPessoa().getId()), cliente.getPessoa().getNome(),
					cliente.getPessoa().getRg(), cliente.getPessoa().getCpf(), "CLIENTE" });
		}

	}

	private void criarPessoa() {
		telaPrincipal.getTlPrincipal().esconderTelas();
		telaPrincipal.getTlPrincipal().getTlCadastroPessoa().setVisible(true);

	}

	private void editarPessoa() {
		telaPrincipal.getTlPrincipal().esconderTelas();
		telaPrincipal.getTlPrincipal().getTlAlterarPessoa().setVisible(true);
		telaPrincipal.getTlPrincipal().getTlAlterarPessoa().preencherCampos(
				Integer.valueOf(dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 0).toString()),
				String.valueOf(dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 4)));
	}

	private void removerPessoa() {
		if (jtbPessoas.getSelectedRow() >= 0) {
			Integer id = Integer.valueOf(dtbPessoas.getValueAt(jtbPessoas.getSelectedRow(), 0).toString());
			for (Cliente cliente : clienteDao.todos()) {
				if (cliente.getPessoa().getId() == id) {
					clienteDao.excluir(cliente);
				}
			}
			for (Usuario usuario : usuarioDao.todos()) {
				if (usuario.getCorretor().getPessoa().getId() == id) {
					usuarioDao.excluir(usuario);
				}
			}
			for (Corretor corretor : corretorDao.todos()) {
				if (corretor.getPessoa().getId() == id) {
					corretorDao.excluir(corretor);
				}
			}
			for (Pessoa pessoa : pessoaDao.todos()) {
				if (pessoa.getId() == id) {
					pessoaDao.excluir(pessoa);
					for (Endereco endereco : enderecoDao.todos()) {
						if (endereco.getId() == pessoa.getEndereco().getId()) {
							enderecoDao.excluir(endereco);
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
			atualizarPessoas();
		} else {
			JOptionPane.showMessageDialog(null, "Clique sobre a pessoa/corretor que deseja remover.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void pesquisarRg() {
		String rg = null;
		Boolean encontrou = false;
		rg = JOptionPane.showInputDialog("Insira o RG que deseja pesquisa.");
		if (rg == null || rg.equals("")) {
			JOptionPane.showMessageDialog(null, "Impossível pesquisar por um RG vazio!", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			for (Pessoa pessoa : pessoaDao.todos()) {
				if (pessoa.getRg().toString().equals(rg)) {
					encontrou = true;
					dtbPessoas.setRowCount(0);
					for (Corretor corretor1 : corretorDao.todos()) {
						if (corretor1.getPessoa().getId() == pessoa.getId()) {
							dtbPessoas.addRow(new String[] { String.valueOf(corretor1.getIdCorretor()),
									corretor1.getPessoa().getNome(), corretor1.getPessoa().getRg(),
									corretor1.getPessoa().getCpf(), "CORRETOR" });
						}
					}
					for (Cliente cliente1 : clienteDao.todos()) {
						if (cliente1.getPessoa().getId() == pessoa.getId()) {
							dtbPessoas.addRow(new String[] { String.valueOf(cliente1.getIdCliente()),
									cliente1.getPessoa().getNome(), cliente1.getPessoa().getRg(),
									cliente1.getPessoa().getCpf(), "CLIENTE" });
						}
					}
				}
			}
			if (encontrou == false) {
				JOptionPane.showMessageDialog(null, "Nenhuma pessoa com o RG [" + rg + "] foi encontrado!", "Aviso!",
						JOptionPane.WARNING_MESSAGE);
			} else if (encontrou == true) {
				JOptionPane.showMessageDialog(null,
						"Durante a pesquisa foram encontradas [" + dtbPessoas.getRowCount() + "] pessoa(as) com o RG ["
								+ rg + "]\nO resultado está sendo exibido na tabela!",
						"Resultado", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	public void atualizarPessoas() {
		dtbPessoas.setRowCount(0);
		alimentarTabela();
		JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
	}

	private void filtrarCorretor() {
		dtbPessoas.setRowCount(0);
		for (Corretor corretor : corretorDao.todos()) {
			dtbPessoas.addRow(new String[] { String.valueOf(corretor.getIdCorretor()), corretor.getPessoa().getNome(),
					corretor.getPessoa().getRg(), corretor.getPessoa().getCpf(), "CORRETOR" });
		}
	}

	private void filtrarCliente() {
		dtbPessoas.setRowCount(0);
		for (Cliente cliente : clienteDao.todos()) {
			dtbPessoas.addRow(new String[] { String.valueOf(cliente.getIdCliente()), cliente.getPessoa().getNome(),
					cliente.getPessoa().getRg(), cliente.getPessoa().getCpf(), "CLIENTE" });
		}
	}

	private void abrirMenu() {
		if (menuVisivel == false) {
			jspPessoas.setBounds(110, 45, 590, 422);
			jtbBarra.setVisible(true);
			menuVisivel = true;
		} else {
			jspPessoas.setBounds(0, 45, 702, 422);
			jtbBarra.setVisible(false);
			menuVisivel = false;
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtMenu) {
			abrirMenu();
		}

		if (e.getSource() == jbtCriarPessoa) {
			criarPessoa();
		}

		if (e.getSource() == jbtEditarPessoa) {
			editarPessoa();
		}

		if (e.getSource() == jbtRemoverPessoa) {
			removerPessoa();
		}

		if (e.getSource() == jbtAtualizarPessoas) {
			atualizarPessoas();
		}

		if (e.getSource() == jbtFiltrarCliente) {
			filtrarCliente();
		}

		if (e.getSource() == jbtFiltraCorretor) {
			filtrarCorretor();
		}

		if (e.getSource() == jbtPesquisarRg) {
			pesquisarRg();
		}

	}

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.addActionListener(this);
		button.setVisible(true);
		getContentPane().add(button);
		return button;

	}

	public static void main(String[] args) {
		new TelaListaPessoa();
	}

}
