package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.EnderecoDAO;
import dao.ImovelDAO;
import imovel.Imovel;
import pessoa.Cliente;
import pessoa.Endereco;

public class TelaCadastroImovel extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 4319035476296494897L;

	private JLabel jlbTitulo;
	
	private JPanel jpnLocalizador, jpnTab1;
	private JLabel jlbNovo, jlbRG, jlbNome, jlbCpf;
	private JButton jbtProcurar, jbtNovo;
	private JTextField jtfRg, jtfNome, jtfCpf;
	private JTabbedPane jtbPrincipal;
	
	private JPanel jpnTab2;
	private JButton jbtProcurar1;
	private JLabel jlbImagem1;
	private JFileChooser jfcProcurar;
	
	private JPanel jpnTab3;
	private JButton jbtProcurar2;
	private JLabel jlbImagem2;
	
	private JPanel jpnTab4;
	private JButton jbtProcurar3;
	private JLabel jlbImagem3;
	
	private JPanel jpnTab5;
	private JButton jbtProcurar4;
	private JLabel jlbImagem4;
	
	private JPanel jpnImovel;
	private JRadioButton jrbAlugar, jrbVender;
	private ButtonGroup btgTipoVenda;
	private JLabel jlbMetrosQuadrados, jlbValorTotal, jlbValorMensal, jlbMesesContrato;
	private JTextField jtfMetrosQuadrados, jtfMesesContrato, jtfValorTotal, jtfValorMensal;
	
	private CriarCamponentes cp = new CriarCamponentes();
	
	private JPanel jpnCadastroEndereco;
	private JLabel jlbRua, jlbNumero, jlbCidade, jlbBairro, jlbUf, jlbCep;
	private JTextField jtfRua, jtfNumero, jtfCidade, jtfBairro, jtfUf, jtfCep;
	
	private File arquivo1, arquivo2, arquivo3, arquivo4;
	
	private JButton jbtSalvar;
	
	private JLabel jlbPossui;
	private JComboBox<String> jcbPossui;
	
	private JButton jbtAjudaDescricao;
	
	private JLabel jlbDescricao1, jlbDescricao2, jlbDescricao3;
	private JTextField jtfDescricao1, jtfDescricao2, jtfDescricao3;
	private JPanel jpnTab6;
	
	private ImovelDAO imovelDao = DaoFactoryJDBC.get().imovelDAO();
	private EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private Cliente clienteEncontrado;
	
	public TelaCadastroImovel() {
		setTitle("CADASTRO DE IMOVEL");
		setLayout(null);

		jlbTitulo = new JLabel("CADASTRO DE IMÓVEL", SwingConstants.CENTER);
		jlbTitulo.setBounds(0, 0, 707, 44);
		jlbTitulo.setVisible(true);
		jlbTitulo.setFont(new Font("ARIAL", Font.PLAIN, 18));
		jlbTitulo.setOpaque(true);
		jlbTitulo.setBackground(new Color(23, 20, 20));
		jlbTitulo.setForeground(Color.white);
		getContentPane().add(jlbTitulo);
		
		criarPanelCadastroEndereco();
		criarPanelLocalizadorProprietario();
		
		jlbMetrosQuadrados = cp.criarLabel("METROS QUADRADOS:", 10, 20, 200, 24, jlbMetrosQuadrados);
		jtfMetrosQuadrados = cp.criarTextField(170, 20, 150, 24, jtfMetrosQuadrados);
		
		jlbPossui = cp.criarLabel("DISPONÍVEL:", 465, 20, 200, 24, jlbPossui);
		jcbPossui = new JComboBox<>();
		jcbPossui.addItem("NÃO");
		jcbPossui.addItem("SIM");
		jcbPossui.setBounds(550, 20, 90, 24);
		jcbPossui.setVisible(true);
		getContentPane().add(jcbPossui);
		
		jrbAlugar = cp.criarRadioButton("IMÓVEL PARA ALUGAR", 10, 60, 200, 24, jrbAlugar);
		jrbAlugar.addActionListener(this);
		jlbMesesContrato = cp.criarLabel("MESES DE CONTRATO:", 30, 90, 200, 24, jlbMesesContrato);
		jtfMesesContrato = cp.criarTextField(170, 90, 50, 24, jtfMesesContrato);
		jtfMesesContrato.setEnabled(false);
		jlbValorMensal = cp.criarLabel("VALOR MENSAL:", 230, 90, 200, 24, jlbValorMensal);
		jtfValorMensal = cp.criarTextField(335, 90, 150, 24, jtfValorMensal);
		jtfValorMensal.setEnabled(false);
		
		jrbVender = cp.criarRadioButton("IMÓVEL PARA VENDER", 10, 125, 200, 24, jrbVender);
		jrbVender.addActionListener(this);
		jlbValorTotal = cp.criarLabel("VALOR TOTAL:", 30, 155, 200, 24, jlbValorTotal);
		jtfValorTotal = cp.criarTextField(130, 155, 150, 24, jtfValorTotal);
		jtfValorTotal.setEnabled(false);
		
		
		btgTipoVenda = new ButtonGroup();
		btgTipoVenda.add(jrbAlugar);
		btgTipoVenda.add(jrbVender);
		
		
		jpnImovel = cp.criarPanel("Imóvel", 0, 110, 684, 190, jpnImovel, true);
		jpnImovel.add(jrbAlugar);
		jpnImovel.add(jrbVender);
		jpnImovel.add(jlbMesesContrato);
		jpnImovel.add(jtfMesesContrato);
		jpnImovel.add(jlbPossui);
		jpnImovel.add(jcbPossui);
		jpnImovel.add(jlbValorMensal);
		jpnImovel.add(jtfValorMensal);
		jpnImovel.add(jlbValorTotal);
		jpnImovel.add(jtfValorTotal);
		jpnImovel.add(jlbMetrosQuadrados);
		jpnImovel.add(jtfMetrosQuadrados);
		
		jbtProcurar1 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar1);
		jbtProcurar2 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar2);
		jbtProcurar3 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar3);
		jbtProcurar4 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar4);
	
		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);
		
		jbtProcurar1.addActionListener(this);
		jbtProcurar2.addActionListener(this);
		jbtProcurar3.addActionListener(this);
		jbtProcurar4.addActionListener(this);	
		
		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);
		
		jlbDescricao1 = cp.criarLabel("Descrição 1:", 10, 10, 100, 24, jlbDescricao1);
		jlbDescricao2 = cp.criarLabel("Descrição 2:", 10, 40, 100, 24, jlbDescricao2);
		jlbDescricao3 = cp.criarLabel("Descrição 3:", 10, 70, 100, 24, jlbDescricao3);
		
		jtfDescricao1 = cp.criarTextField(100, 10, 470, 24, jtfDescricao1);
		jtfDescricao2 = cp.criarTextField(100, 40, 470, 24, jtfDescricao2);
		jtfDescricao3 = cp.criarTextField(100, 70, 470, 24, jtfDescricao3);

		jbtAjudaDescricao = cp.criarBotao("", 660, 4, 27, 27, jbtAjudaDescricao);
		jbtAjudaDescricao.setIcon(new ImageIcon("img/question_item_24.png"));
		jbtAjudaDescricao.setOpaque(false);
		jbtAjudaDescricao.setBorderPainted(false);
		jbtAjudaDescricao.setBackground(new Color(0, 0, 0, 0));
		jbtAjudaDescricao.addActionListener(this);
		
		jpnTab1 = cp.criarPanel("", 0, 0, 700, 300, jpnTab1, true);
		jpnTab1.add(jpnLocalizador);
		jpnTab1.add(jpnCadastroEndereco);
		jpnTab1.add(jpnImovel);
		
		jpnTab2 = cp.criarPanel("", 0, 0, 700, 420, jpnTab2, true);
		jpnTab2.add(jbtProcurar1);
		jpnTab2.add(jlbImagem1);
		
		jpnTab3 = cp.criarPanel("", 0, 0, 700, 420, jpnTab3, true);
		jpnTab3.add(jbtProcurar2);
		jpnTab3.add(jlbImagem2);
		
		jpnTab4 = cp.criarPanel("", 0, 0, 700, 420, jpnTab4, true);
		jpnTab4.add(jbtProcurar3);
		jpnTab4.add(jlbImagem3);
		
		jpnTab5 = cp.criarPanel("", 0, 0, 700, 420, jpnTab5, true);
		jpnTab5.add(jbtProcurar4);
		jpnTab5.add(jlbImagem4);
		
		jpnTab6 = cp.criarPanel("", 0, 0, 700, 420, jpnTab6, true);
		jpnTab6.add(jlbDescricao1);
		jpnTab6.add(jlbDescricao2);
		jpnTab6.add(jlbDescricao3);
		jpnTab6.add(jtfDescricao1);
		jpnTab6.add(jtfDescricao2);
		jpnTab6.add(jtfDescricao3);
		jpnTab6.add(jbtAjudaDescricao);
		
		jtbPrincipal = new JTabbedPane();
		jtbPrincipal.add("Principal", jpnTab1);
		jtbPrincipal.add("Imagem 1", jpnTab2);
		jtbPrincipal.add("Imagem 2", jpnTab3);
		jtbPrincipal.add("Imagem 3", jpnTab4);
		jtbPrincipal.add("Imagem 4", jpnTab5);
		jtbPrincipal.add("Descrição do Imóvel", jpnTab6);
		jtbPrincipal.setBounds(0,50,693,420);
		getContentPane().add(jtbPrincipal);
		
		jfcProcurar = new JFileChooser();

		criarBotoesInferiores();
		
		setResizable(false);
		setSize(700, 530);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarBotoesInferiores() {
		jbtSalvar = cp.criarBotao("CADASTRAR", 540, 473, 150, 27, jbtSalvar);
		jbtSalvar = cp.alterarCorBotoes(jbtSalvar);
		jbtSalvar.addActionListener(this);
		getContentPane().add(jbtSalvar);
	}
	
	private void criarPanelCadastroEndereco() {
		jlbRua = cp.criarLabel("Rua:", 10, 20, 110, 30, jlbRua);
		jlbNumero = cp.criarLabel("Nº:", 510, 20, 110, 30, jlbNumero);
		jlbBairro = cp.criarLabel("Bairro:", 10, 50, 110, 30, jlbBairro);
		jlbCidade = cp.criarLabel("Cidade:", 210, 50, 120, 30, jlbCidade);
		jlbUf = cp.criarLabel("UF:", 420, 50, 110, 30, jlbUf);
		jlbCep = cp.criarLabel("CEP:", 510, 50, 110, 30, jlbCep);

		jtfRua = cp.criarTextField(80, 24, 420, 24, jtfRua);
		jtfNumero = cp.criarTextField(550, 24, 90, 24, jtfNumero);
		jtfBairro = cp.criarTextField(80, 54, 120, 24, jtfBairro);
		jtfCidade = cp.criarTextField(280, 52, 130, 24, jtfCidade);
		jtfUf = cp.criarTextField(450, 54, 50, 24, jtfUf);
		jtfCep = cp.criarTextField(550, 54, 90, 24, jtfCep);

		jpnCadastroEndereco = cp.criarPanel("Endereço", 0, 10, 684, 90, jpnCadastroEndereco, true);
		jpnCadastroEndereco.add(jlbRua);
		jpnCadastroEndereco.add(jlbNumero);
		jpnCadastroEndereco.add(jlbBairro);
		jpnCadastroEndereco.add(jlbCidade);
		jpnCadastroEndereco.add(jlbUf);
		jpnCadastroEndereco.add(jlbCep);
		jpnCadastroEndereco.add(jtfRua);
		jpnCadastroEndereco.add(jtfNumero);
		jpnCadastroEndereco.add(jtfBairro);
		jpnCadastroEndereco.add(jtfCidade);
		jpnCadastroEndereco.add(jtfUf);
		jpnCadastroEndereco.add(jtfCep);

	}
	
	private void criarPanelLocalizadorProprietario() {
		jlbNovo = cp.criarLabel("CADASTRAR:", 20, 20, 105, 24, jlbNovo);
		jlbRG = cp.criarLabel("OU PESQUISAR POR RG:", 220, 20, 150, 24, jlbRG);
		jlbNome = cp.criarLabel("NOME:", 20, 50, 50, 24, jlbNome);
		jlbCpf = cp.criarLabel("CPF:", 330, 50, 50, 24, jlbCpf);			
		
		jtfRg = cp.criarTextField(370, 20, 100, 24, jtfRg);
		jtfNome = cp.criarTextField(65, 50, 250, 24, jtfNome);
		jtfNome.setEnabled(false);
		jtfCpf = cp.criarTextField(360, 50, 150, 24, jtfCpf);
		jtfCpf.setEnabled(false);
		
		jbtProcurar = cp.criarBotao("LOCALIZAR", 500, 20, 100, 24, jbtProcurar);
		jbtNovo = cp.criarBotao("CLIENTE", 100, 20, 105, 24, jbtNovo);

		jbtProcurar.addActionListener(this);
		jbtNovo.addActionListener(this);
		
		jpnLocalizador = cp.criarPanel("PROPRIETÁRIO", 0, 310, 684, 80, jpnLocalizador, true);
		jpnLocalizador.add(jlbNovo);
		jpnLocalizador.add(jlbRG);
		jpnLocalizador.add(jtfRg);
		jpnLocalizador.add(jbtProcurar);
		jpnLocalizador.add(jbtNovo);
		jpnLocalizador.add(jlbNome);
		jpnLocalizador.add(jtfNome);
		jpnLocalizador.add(jlbCpf);
		jpnLocalizador.add(jtfCpf);
		
	}

	public static void main(String[] args) {
		new TelaCadastroImovel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSalvar){
			Imovel imovel = new Imovel();
			Endereco endereco = new Endereco();
			Cliente cliente = clienteEncontrado;
			
			endereco.setId(enderecoDao.maiorId()+1);
			endereco.setRua(jtfRua.getText());
			endereco.setNumero(jtfNumero.getText());
			endereco.setBairro(jtfBairro.getText());
			endereco.setCidade(jtfCidade.getText());
			endereco.setUf(jtfUf.getText());
			endereco.setCep(jtfCep.getText());
			enderecoDao.inserir(endereco);
			
			imovel.setIdImovel(imovelDao.maiorId()+1);
			imovel.setMetrosquadrados(jtfMetrosQuadrados.getText());
			imovel.setCliente(cliente);
			if(jrbVender.isSelected()){
				imovel.setValorTotal(Double.valueOf(jtfValorTotal.getText()));
				imovel.setValorMensal(0.0);
				imovel.setMesesContrato(0);
			}else if(jrbAlugar.isSelected()){
				imovel.setValorMensal(Double.valueOf(jtfValorMensal.getText()));
				imovel.setMesesContrato(Integer.valueOf(jtfMesesContrato.getText()));
				imovel.setValorTotal(0.0);
			}
			imovel.setEndereco(endereco);
			imovel.setImagem1(arquivo1.getAbsolutePath());
			imovel.setImagem2(arquivo2.getAbsolutePath());
			imovel.setImagem3(arquivo3.getAbsolutePath());
			imovel.setImagem4(arquivo4.getAbsolutePath());
			imovel.setDescricao1(jtfDescricao1.getText());
			imovel.setDescricao2(jtfDescricao2.getText());
			imovel.setDescricao3(jtfDescricao3.getText());
			imovel.setPossui(jcbPossui.getSelectedIndex());
			imovelDao.inserir(imovel);
		}
		if(e.getSource() == jbtProcurar){
			for(Cliente cliente : clienteDao.todos()){
				if(cliente.getPessoa().getRg().equals(jtfRg.getText())){
					this.clienteEncontrado = cliente;
					jtfNome.setText(cliente.getPessoa().getNome());
					jtfCpf.setText(cliente.getPessoa().getCpf());
				}
			}
			
		}
		if(e.getSource() == jrbAlugar){
			rbAlugar();
		}
		if(e.getSource() == jrbVender){
			rbVender();
		}
		if(e.getSource() == jbtProcurar1){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				arquivo1 = jfcProcurar.getSelectedFile();
				BufferedImage img1 = cp.redimensionarImagem(arquivo1.getAbsolutePath(), 700, 420);
				jlbImagem1.setIcon(new ImageIcon(img1));
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar2){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				arquivo2 = jfcProcurar.getSelectedFile();
				BufferedImage img2 = cp.redimensionarImagem(arquivo2.getAbsolutePath(), 700, 420);
				jlbImagem2.setIcon(new ImageIcon(img2));			
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar3){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				arquivo3 = jfcProcurar.getSelectedFile();
				BufferedImage img3 = cp.redimensionarImagem(arquivo3.getAbsolutePath(), 700, 420);
				jlbImagem3.setIcon(new ImageIcon(img3));	
				
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar4){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				arquivo4 = jfcProcurar.getSelectedFile();
				BufferedImage img4 = cp.redimensionarImagem(arquivo4.getAbsolutePath(), 700, 420);
				jlbImagem4.setIcon(new ImageIcon(img4));	
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtAjudaDescricao){
			JOptionPane.showMessageDialog(null,
					"Sempre que adicionar um imóvel, você pode atribuir 3 descrições a ele.\nEssas descrições definem o que seu imóvel possui.\nPor exemplo: Luxo, Imobiliado, Confortável.\nNÃO É OBRIGATÓRIO!",
					"Ajuda", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	private void rbVender(){
		jtfValorTotal.setEnabled(true);
		
		jtfValorMensal.setEnabled(false);
		jtfMesesContrato.setEnabled(false);
	}

	private void rbAlugar(){
		jtfValorMensal.setEnabled(true);
		jtfMesesContrato.setEnabled(true);
		
		jtfValorTotal.setEnabled(false);
	}
	
}
