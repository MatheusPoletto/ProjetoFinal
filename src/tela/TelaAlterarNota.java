package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAOFactory.DaoFactoryJDBC;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import model.Imobiliaria;
import model.NotaFiscal;
import model.Venda;
import utilitario.CriarCamponentes;

public class TelaAlterarNota extends JInternalFrame implements ActionListener{
	
	private JLabel jlbLogo, jlbNomeFantasia, jlbRazaoSocial, jlbCnpj;
	private CriarCamponentes cp = new CriarCamponentes();
	private JPanel jpnTodo, jpnImobiliaria;
	private JPanel jpnClienteComprador;
	private JLabel jlbNome, jlbEndereco, jlbCpf, jlbFone;
	private JTextField jtfNome, jtfEndereco, jtfCpf, jtfFone;
	private JLabel jlbEmissao;
	private JTextField jtfDataEmissao;
	private JTable jtbProdutos;
	private DefaultTableModel dtbProdutos;
	private JScrollPane jspProdutos;
	private JLabel jlbValorTotal;
	private JTextField jtfValorTotal;
	private JButton jbtImprimir, jbtEstorno;
	private JLabel jlbCodigo;
	private JTextField jtfCodigo;
	
	private JPanel jpnEnderecoImo;
	private JLabel jlbEnderecoImo;
	
	public TelaAlterarNota() {
		setTitle("NOTA FISCAL");
		setLayout(null);

		jlbLogo = cp.criarLabelCentralizada("", 3, 1, 175, 75, jlbLogo);
		jlbLogo.setIcon(new ImageIcon("img/logo_imo.png"));
		jlbLogo.setBorder(BorderFactory.createBevelBorder(1));
		
		jlbNomeFantasia = cp.criarLabelCentralizada("M&M Sistema Imobili�rio", 0, 1, 285, 24, jlbNomeFantasia);
		jlbNomeFantasia.setFont(new Font("Dialog", Font.BOLD, 16));
		
		jlbRazaoSocial = cp.criarLabelCentralizada("Matheus e matheus sistema de corretores", 0, 20, 285, 24, jlbRazaoSocial);
		jlbRazaoSocial.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		jlbCnpj = cp.criarLabelCentralizada("CNPJ: 057.6598/578.65-64", 0, 40, 285, 24, jlbCnpj);
		jlbCnpj.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		jpnImobiliaria = cp.criarPanel("", 180, 1, 285, 75, jpnImobiliaria, true);
		jpnImobiliaria.add(jlbNomeFantasia);
		jpnImobiliaria.add(jlbRazaoSocial);
		jpnImobiliaria.add(jlbCnpj);
		
		jlbEmissao = cp.criarLabel("Data de emiss�o:", 185, 78, 150, 24, jlbEmissao);
		jtfDataEmissao = cp.criarTextField(290, 78, 173, 24, jtfDataEmissao);
		
		jlbCodigo = cp.criarLabel("C�digo nota fiscal:", 3, 78, 150, 24, jlbCodigo);
		jtfCodigo = cp.criarTextField(120, 78, 60, 24, jtfCodigo);
		
		
		jlbNome = cp.criarLabel("Nome:", 3, 1, 100, 24, jlbNome);
		jlbEndereco = cp.criarLabel("Endere�o:", 3, 31, 100, 24, jlbEndereco);
		jlbCpf = cp.criarLabel("CPF:", 3, 61, 100, 24, jlbCpf);
		jlbFone = cp.criarLabel("Fone:", 250, 61, 100, 24, jlbFone);
		
		jtfNome = cp.criarTextField(60, 2, 400, 24, jtfNome);
		jtfEndereco = cp.criarTextField(80, 31, 380, 24, jtfEndereco);
		jtfCpf = cp.criarTextField(60, 61, 170, 24, jtfCpf);
		jtfFone = cp.criarTextField(295, 61, 164, 24, jtfCpf);
		
		jpnClienteComprador = cp.criarPanel("", 3, 105, 460, 100, jpnClienteComprador, true);
		jpnClienteComprador.add(jlbNome);
		jpnClienteComprador.add(jlbEndereco);
		jpnClienteComprador.add(jlbCpf);
		jpnClienteComprador.add(jlbFone);
		jpnClienteComprador.add(jtfNome);
		jpnClienteComprador.add(jtfEndereco);
		jpnClienteComprador.add(jtfCpf);
		jpnClienteComprador.add(jtfFone);

		jtbProdutos = new JTable();
		getContentPane().add(jtbProdutos);
		dtbProdutos = new DefaultTableModel();

		dtbProdutos.addColumn("ID");
		dtbProdutos.addColumn("Descri��o");
		dtbProdutos.addColumn("Valor");

		jtbProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtbProdutos.setModel(dtbProdutos);
		jspProdutos = new JScrollPane(jtbProdutos);
		jspProdutos.setBounds(3, 210, 461, 71);
		jspProdutos.setVisible(true);
		getContentPane().add(jspProdutos);

		jtbProdutos.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtbProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
		jtbProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		jtbProdutos.setEnabled(false);
		
		jlbValorTotal  = cp.criarLabel("TOTAL R$:", 320, 282, 100, 24, jlbValorTotal);
		jtfValorTotal = cp.criarTextField(385, 283, 78, 24, jtfValorTotal);
		
		jlbEnderecoImo = cp.criarLabelCentralizada("", 0, 0, 460, 40, jlbEnderecoImo);
		ImobiliariaDAO imobiliariaDao = DaoFactoryJDBC.get().imobiliariaDAO();
		Imobiliaria imobiliaria = imobiliariaDao.buscar(1);
		jlbEnderecoImo.setText("<html><p align = 'center'>Rua: "+imobiliaria.getEndereco().getRua()+" | N�: "+imobiliaria.getEndereco().getNumero()+" | Bairro: "+imobiliaria.getEndereco().getBairro()+" <br> Cidade: "+imobiliaria.getEndereco().getCidade()+" | CEP: "+imobiliaria.getEndereco().getCep()+" | Telefone: "+imobiliaria.getTelefone()+"</p></html>");
		jpnEnderecoImo = cp.criarPanel("", 3, 310, 460, 40, jpnEnderecoImo, true);
		jpnEnderecoImo.setFont(new Font("Dialog", Font.PLAIN, 12));
		jpnEnderecoImo.add(jlbEnderecoImo);
		
		
		jpnTodo = cp.criarPanel("", 10, 10, 465, 353, jpnTodo, true);
		jpnTodo.add(jlbLogo);
		jpnTodo.add(jpnImobiliaria);
		jpnTodo.add(jpnClienteComprador);
		jpnTodo.add(jlbCodigo);
		jpnTodo.add(jtfCodigo);
		jpnTodo.add(jlbEmissao);
		jpnTodo.add(jtfDataEmissao);
		jpnTodo.add(jspProdutos);
		jpnTodo.add(jlbValorTotal);
		jpnTodo.add(jtfValorTotal);
		jpnTodo.add(jpnEnderecoImo);
		
		
		getContentPane().add(jpnTodo);
		
		jtfDataEmissao.setEnabled(false);
		jtfNome.setEnabled(false);
		jtfCpf.setEnabled(false);
		jtfFone.setEnabled(false);
		jtfEndereco.setEnabled(false);
		jtfValorTotal.setEnabled(false);
		jtfCodigo.setEnabled(false);
		
		jbtImprimir = cp.criarBotao("IMPRIMIR", 375, 370, 100, 24, jbtImprimir);
		getContentPane().add(jbtImprimir);
		
		jbtEstorno = cp.criarBotao("ESTORNAR", 10, 370, 100, 24, jbtEstorno);
		getContentPane().add(jbtEstorno);

		setSize(500, 430);
		setVisible(true);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TelaAlterarNota();

	}

	public void preencherCampos(Venda venda, NotaFiscal nf, Double valorTotal){
		jtfCodigo.setText(String.valueOf(nf.getIdNotaFiscal()));
		jtfNome.setText(venda.getCliente().getPessoa().getNome());
		jtfEndereco.setText(venda.getCliente().getPessoa().getEndereco().getRua() + " - " + venda.getCliente().getPessoa().getEndereco().getNumero() + " - " + venda.getCliente().getPessoa().getEndereco().getBairro() + " - " + venda.getCliente().getPessoa().getEndereco().getCidade() + " - " + venda.getCliente().getPessoa().getEndereco().getUf() + " - " + venda.getCliente().getPessoa().getEndereco().getCep());
		jtfCpf.setText(venda.getCliente().getPessoa().getCpf());
		jtfFone.setText(venda.getCliente().getPessoa().getTelefoneResidencial());
		jtfDataEmissao.setText(nf.getDataEmissao());
		jtfValorTotal.setText(String.valueOf(valorTotal));
		
		if(venda.getImovel().getValorTotal() > 0){
		dtbProdutos.addRow(new String[]{"1", "Venda de im�vel - ID IM�VEL: " + String.valueOf(venda.getImovel().getIdImovel()), String.valueOf(venda.getImovel().getValorTotal())});
		}else if(venda.getImovel().getMesesContrato() > 1){
			dtbProdutos.addRow(new String[]{"1", "Aluguel de im�vel - ID IM�VEL: " + String.valueOf(venda.getImovel().getIdImovel()), String.valueOf(venda.getImovel().getValorMensal() * venda.getImovel().getMesesContrato())});	
		}
		dtbProdutos.addRow(new String[]{"2", "Comiss�o corretor - ID CORRETOR:" + venda.getCorretor().getIdCorretor(), String.valueOf(venda.getComissaoCorretor())});
		dtbProdutos.addRow(new String[]{"3", "Comiss�o imobili�ria - ID IMOBILI�RIA: " + String.valueOf(nf.getImobiliaria().getIdImobiliaria()), String.valueOf(venda.getComissaoImobiliaria())});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
}
