package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.ImovelDAO;
import imovel.Imovel;
import utilitario.CriarCamponentes;

public class TelaListaImovel extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel jlbTitulo;
	private CriarCamponentes cp = new CriarCamponentes();
	private JRadioButton jrbCidade, jrbBairro, jrbValor, jrbMetros;
	private JPanel jpnProcurar;
	private JTextField jtfPesquisa;
	private ButtonGroup btgFiltro;
	private JButton jbtFiltrar;
	private JTable jtbImovel;
	private DefaultTableModel dtbImovel;
	private JScrollPane jspImovel;
	private JPanel jpnImagem;
	private JLabel jlbImg1, jlbImg2, jlbImg3, jlbImg4;
	private JButton jbtInfo, jbtAlterar, jbtVender, jbtRemover, jbtTodos;
	private ImovelDAO imovelDao = DaoFactoryJDBC.get().imovelDAO();
	private Imovel imovelSelecionado;
	private JPanel jpnTipoVenda;
	private JLabel jlbVenda;
	private JLabel jlbVendaPreco;
	private JLabel jlbVendaRua, jlbVendaNumero, jlbVendaBairro, jlbVendaCidade, jlbVendaCep;

	public TelaListaImovel() {
		setTitle("Meus imóveis");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("Meus Imóveis", 0, 0, 650, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);

		criarPanelProcurar();

		criarTableImoveis();

		criarMenuBotoes();

		criarParteInferior();

		alimentaTable();
		
		setClosable(true);
		setResizable(false);
		setSize(650, 550);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	private void criarParteInferior() {
		jlbImg1 = cp.criarLabel("", 10, 10, 125, 125, jlbImg1);
		jlbImg2 = cp.criarLabel("", 140, 10, 125, 125, jlbImg2);
		jlbImg3 = cp.criarLabel("", 10, 140, 125, 125, jlbImg3);
		jlbImg4 = cp.criarLabel("", 140, 140, 125, 125, jlbImg4);

		jlbImg1.setOpaque(true);
		jlbImg1.setBackground(Color.white);
		jlbImg2.setOpaque(true);
		jlbImg2.setBackground(Color.white);
		jlbImg3.setOpaque(true);
		jlbImg3.setBackground(Color.white);
		jlbImg4.setOpaque(true);
		jlbImg4.setBackground(Color.white);

		jbtVender = cp.criarBotao("VENDER", 270, 240, 345, 24, jbtVender);
		jbtVender = cp.alterarCorBotoes(jbtVender);
		jbtVender.addActionListener(this);
		getContentPane().add(jbtVender);

		jpnTipoVenda = cp.criarPanel("", 270, 10, 345, 230, jpnTipoVenda, true);
		
		jlbVenda = cp.criarLabelCentralizada("", 10, 5, 325, 24, jlbVenda);
		jlbVendaPreco = cp.criarLabelCentralizada("", 10, 30, 325, 24, jlbVendaPreco);
		jlbVendaRua = cp.criarLabelCentralizada("", 10, 70, 325, 24, jlbVendaPreco);
		jlbVendaNumero = cp.criarLabelCentralizada("", 10, 95, 325, 24, jlbVendaNumero);
		jlbVendaBairro = cp.criarLabelCentralizada("", 10, 120, 325, 24, jlbVendaBairro);
		jlbVendaCidade = cp.criarLabelCentralizada("", 10, 145, 325, 24, jlbVendaCidade);
		jlbVendaCep = cp.criarLabelCentralizada("", 10, 170, 325, 24, jlbVendaCep);

		jlbVenda.setForeground(new Color(30, 144, 255));
		jlbVenda.setFont(new Font("Dialog", Font.BOLD, 16));
		jlbVendaPreco.setFont(new Font("Dialog", Font.PLAIN, 12));
		jlbVendaRua.setFont(new Font("Dialog", Font.PLAIN, 14));
		jlbVendaNumero.setFont(new Font("Dialog", Font.PLAIN, 14));
		jlbVendaBairro.setFont(new Font("Dialog", Font.PLAIN, 14));
		jlbVendaCidade.setFont(new Font("Dialog", Font.PLAIN, 14));
		jlbVendaCep.setFont(new Font("Dialog", Font.PLAIN, 14));

		jpnTipoVenda.add(jlbVenda);
		jpnTipoVenda.add(jlbVendaPreco);
		jpnTipoVenda.add(jlbVendaRua);
		jpnTipoVenda.add(jlbVendaNumero);
		jpnTipoVenda.add(jlbVendaBairro);
		jpnTipoVenda.add(jlbVendaCidade);
		jpnTipoVenda.add(jlbVendaCep);

		jpnImagem = cp.criarPanel("", 10, 245, 625, 275, jpnImagem, true);
		jpnImagem.add(jlbImg1);
		jpnImagem.add(jlbImg2);
		jpnImagem.add(jlbImg3);
		jpnImagem.add(jlbImg4);
		jpnImagem.add(jbtVender);
		jpnImagem.add(jpnTipoVenda);
		getContentPane().add(jpnImagem);

	}

	private void criarMenuBotoes() {
		jbtInfo = cp.criarBotao("INFO.", 523, 140, 110, 24, jbtInfo);
		jbtRemover = cp.criarBotao("REMOVER", 523, 164, 110, 24, jbtRemover);
		jbtAlterar = cp.criarBotao("ALTERAR", 523, 188, 110, 24, jbtAlterar);
		jbtTodos = cp.criarBotao("TODOS", 523, 212, 110, 24, jbtTodos);
		
		jbtInfo = cp.alterarCorBotoes(jbtInfo);
		jbtRemover = cp.alterarCorBotoes(jbtRemover);
		jbtAlterar = cp.alterarCorBotoes(jbtAlterar);
		jbtTodos = cp.alterarCorBotoes(jbtTodos);
		
		jbtInfo.addActionListener(this);
		jbtRemover.addActionListener(this);
		jbtAlterar.addActionListener(this);
		jbtTodos.addActionListener(this);
		
		getContentPane().add(jbtInfo);
		getContentPane().add(jbtRemover);
		getContentPane().add(jbtAlterar);
		getContentPane().add(jbtTodos);

	}

	private void criarTableImoveis() {
		jtbImovel = new JTable();
		getContentPane().add(jtbImovel);
		dtbImovel = new DefaultTableModel();

		dtbImovel.addColumn("ID");
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

		jtbImovel.getColumnModel().getColumn(1).setPreferredWidth(30);
		jtbImovel.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtbImovel.getColumnModel().getColumn(2).setPreferredWidth(170);
		jtbImovel.getColumnModel().getColumn(3).setPreferredWidth(50);
		jtbImovel.getColumnModel().getColumn(4).setPreferredWidth(120);

	}

	private void criarPanelProcurar() {
		jrbCidade = cp.criarRadioButton("Cidade", 150, 10, 100, 24, jrbCidade);
		jrbBairro = cp.criarRadioButton("Bairro", 250, 10, 100, 24, jrbBairro);
		jrbMetros = cp.criarRadioButton("m²", 350, 10, 100, 24, jrbMetros);
		jrbValor = cp.criarRadioButton("Valor", 450, 10, 100, 24, jrbValor);
		
		jtfPesquisa = cp.criarTextField(185, 40, 250, 24, jtfPesquisa);
		
		jbtFiltrar = cp.criarBotao("Procurar", 435, 40, 100, 24, jbtFiltrar);
		jbtFiltrar = cp.alterarCorBotoes(jbtFiltrar);
		jbtFiltrar.addActionListener(this);

		btgFiltro = new ButtonGroup();
		btgFiltro.add(jrbCidade);
		btgFiltro.add(jrbBairro);
		btgFiltro.add(jrbMetros);
		btgFiltro.add(jrbValor);

		jpnProcurar = cp.criarPanel("", 10, 50, 625, 80, jpnProcurar, true);
		jpnProcurar.add(jrbCidade);
		jpnProcurar.add(jrbBairro);
		jpnProcurar.add(jrbMetros);
		jpnProcurar.add(jrbValor);
		jpnProcurar.add(jtfPesquisa);
		jpnProcurar.add(jbtFiltrar);
		getContentPane().add(jpnProcurar);

	}

	private void alimentaTable() {
		dtbImovel.setRowCount(0);
		for (Imovel imovel : imovelDao.todos()) {
			if (imovel.getPossui() == 1) {
				if (imovel.getValorTotal() > 0) {
					dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
							imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
							imovel.getMetrosquadrados(), String.valueOf(imovel.getValorTotal()) + " [Venda]" });
				} else if (imovel.getValorMensal() > 0) {
					if (imovel.getPossui() == 1) {
						dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
								imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
								imovel.getMetrosquadrados(), String.valueOf(imovel.getValorMensal()) + " [Alugar]" });
					}
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtFiltrar) {
			filtrar();
		}
		if (e.getSource() == jbtInfo) {
			mostrarInformações();
		}

		if (e.getSource() == jbtRemover) {
			remover();
		}

		if (e.getSource() == jbtTodos) {
			alimentaTable();
			JOptionPane.showMessageDialog(null, "Tabela de imóveis atualizada com sucesso!");
		}

		if (e.getSource() == jbtAlterar) {
			alterar();
		}
		
		if(e.getSource() == jbtVender){
			if (jtbImovel.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um imóvel para vender!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String id = String.valueOf(dtbImovel.getValueAt(jtbImovel.getSelectedRow(), 0));
				Imovel imovel = imovelDao.buscar(Integer.valueOf(id));
				telaPrincipal.getTlPrincipal().esconderTelas();
				telaPrincipal.getTlPrincipal().getTlCadastrarVenda().setVisible(true);
				telaPrincipal.getTlPrincipal().getTlCadastrarVenda().preencherCampos(imovel);
				
			}
		}
	}

	private void alterar() {
		if (jtbImovel.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um imóvel para alterar!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String id = String.valueOf(dtbImovel.getValueAt(jtbImovel.getSelectedRow(), 0));
			Imovel imovel = imovelDao.buscar(Integer.valueOf(id));
			telaPrincipal.getTlPrincipal().esconderTelas();
			telaPrincipal.getTlPrincipal().getTlAlterarImovel().setVisible(true);
			telaPrincipal.getTlPrincipal().getTlAlterarImovel().preencherCampos(imovel);			
		}
		
	}

	private void remover() {
		if (jtbImovel.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um imóvel para remover!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String id = String.valueOf(dtbImovel.getValueAt(jtbImovel.getSelectedRow(), 0));
			Imovel imovel = imovelDao.buscar(Integer.valueOf(id));
			imovelDao.excluir(imovel);
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			alimentaTable();
		}
		
	}

	private void mostrarInformações() {
		if (jtbImovel.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um imóvel da tabela!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String id = String.valueOf(dtbImovel.getValueAt(jtbImovel.getSelectedRow(), 0));
			Imovel imovel = imovelDao.buscar(Integer.valueOf(id));
			imovelSelecionado = imovel;

			if ((imovelSelecionado.getValorTotal() > 0) && (imovelSelecionado.getValorMensal() == 0)) {
				jlbVenda.setText("DISPONÍVEL PARA VENDER");
				jlbVendaPreco.setText("R$ " + imovelSelecionado.getValorTotal() + " EM ATÉ 12X SEM JUROS!");
				jbtVender.setEnabled(true);
			} else if ((imovelSelecionado.getValorMensal() > 0) && (imovelSelecionado.getValorTotal() == 0)) {
				jlbVenda.setText("DISPONÍVEL PARA ALUGAR");
				jlbVendaPreco.setText("R$ " + imovelSelecionado.getValorMensal() + " MENSAIS! "
						+ imovelSelecionado.getMesesContrato() + " MESES DE CONTRATO!");
				jbtVender.setEnabled(true);
			}

			jlbVendaRua.setText("Rua " + imovelSelecionado.getEndereco().getRua());
			jlbVendaNumero.setText("Número " + imovelSelecionado.getEndereco().getNumero());
			jlbVendaBairro.setText("Bairro " + imovelSelecionado.getEndereco().getBairro());
			jlbVendaCidade.setText("Cidade " + imovelSelecionado.getEndereco().getCidade());
			jlbVendaCep.setText("CEP " + imovelSelecionado.getEndereco().getCep());

			BufferedImage img1 = cp.redimensionarImagem(imovel.getImagem1(), 125, 125);
			jlbImg1.setIcon(new ImageIcon(img1));

			BufferedImage img2 = cp.redimensionarImagem(imovel.getImagem2(), 125, 125);
			jlbImg2.setIcon(new ImageIcon(img2));

			BufferedImage img3 = cp.redimensionarImagem(imovel.getImagem3(), 125, 125);
			jlbImg3.setIcon(new ImageIcon(img3));

			BufferedImage img4 = cp.redimensionarImagem(imovel.getImagem4(), 125, 125);
			jlbImg4.setIcon(new ImageIcon(img4));
		}
		
	}

	private void filtrar() {
		dtbImovel.setRowCount(0);
		if (jrbBairro.isSelected()) {
			for (Imovel imovel : imovelDao.todos()) {
				if (imovel.getEndereco().getBairro().toString().toLowerCase().contains(jtfPesquisa.getText())) {
					if (imovel.getPossui() == 1) {
						if (imovel.getValorTotal() > 0) {
							dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
									imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
									imovel.getMetrosquadrados(),
									String.valueOf(imovel.getValorTotal()) + " [Venda]" });
						} else if (imovel.getValorMensal() > 0) {
							if (imovel.getPossui() == 1) {
								dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
										imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
										imovel.getMetrosquadrados(),
										String.valueOf(imovel.getValorMensal()) + " [Alugar]" });
							}
						}
					}
				}
			}
		}

		if (jrbCidade.isSelected()) {
			for (Imovel imovel : imovelDao.todos()) {
				if (imovel.getEndereco().getCidade().toString().toLowerCase().contains(jtfPesquisa.getText())) {
					if (imovel.getPossui() == 1) {
						if (imovel.getValorTotal() > 0) {
							dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
									imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
									imovel.getMetrosquadrados(),
									String.valueOf(imovel.getValorTotal()) + " [Venda]" });
						} else if (imovel.getValorMensal() > 0) {
							if (imovel.getPossui() == 1) {
								dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
										imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
										imovel.getMetrosquadrados(),
										String.valueOf(imovel.getValorMensal()) + " [Alugar]" });
							}
						}
					}
				}
			}
		}

		if (jrbMetros.isSelected()) {
			for (Imovel imovel : imovelDao.todos()) {
				if (imovel.getMetrosquadrados().toString().toLowerCase().contains(jtfPesquisa.getText())) {
					if (imovel.getPossui() == 1) {
						if (imovel.getValorTotal() > 0) {
							dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
									imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
									imovel.getMetrosquadrados(),
									String.valueOf(imovel.getValorTotal()) + " [Venda]" });
						} else if (imovel.getValorMensal() > 0) {
							if (imovel.getPossui() == 1) {
								dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
										imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
										imovel.getMetrosquadrados(),
										String.valueOf(imovel.getValorMensal()) + " [Alugar]" });
							}
						}
					}
				}
			}
		}

		if (jrbValor.isSelected()) {
			for (Imovel imovel : imovelDao.todos()) {
				if (imovel.getValorTotal().toString().toLowerCase().contains(jtfPesquisa.getText())
						|| imovel.getValorMensal().toString().toLowerCase().contains(jtfPesquisa.getText())) {
					if (imovel.getPossui() == 1) {
						if (imovel.getValorTotal() > 0) {
							dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
									imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
									imovel.getMetrosquadrados(),
									String.valueOf(imovel.getValorTotal()) + " [Venda]" });
						} else if (imovel.getValorMensal() > 0) {
							if (imovel.getPossui() == 1) {
								dtbImovel.addRow(new String[] { String.valueOf(imovel.getIdImovel()),
										imovel.getEndereco().getBairro(), imovel.getEndereco().getCidade(),
										imovel.getMetrosquadrados(),
										String.valueOf(imovel.getValorMensal()) + " [Alugar]" });
							}
						}
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new TelaListaImovel();
	}

}
