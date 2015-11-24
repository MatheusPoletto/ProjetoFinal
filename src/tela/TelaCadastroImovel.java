package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		jpnImovel.add(jlbValorMensal);
		jpnImovel.add(jtfValorMensal);
		jpnImovel.add(jlbValorTotal);
		jpnImovel.add(jtfValorTotal);
		jpnImovel.add(jlbMetrosQuadrados);
		jpnImovel.add(jtfMetrosQuadrados);
		
		
		
		jpnTab1 = cp.criarPanel("", 0, 0, 700, 300, jpnTab1, true);
		jpnTab1.add(jpnLocalizador);
		jpnTab1.add(jpnCadastroEndereco);
		jpnTab1.add(jpnImovel);
		
		jbtProcurar1 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar1);
		jbtProcurar1.addActionListener(this);
		
		jlbImagem1 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem1);
		
		jfcProcurar = new JFileChooser();
		
		jpnTab2 = cp.criarPanel("", 0, 0, 700, 420, jpnTab2, true);
		jpnTab2.add(jbtProcurar1);
		jpnTab2.add(jlbImagem1);
		
		jbtProcurar2 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar2);
		jbtProcurar2.addActionListener(this);
		
		jlbImagem2 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem2);
		
		jpnTab3 = cp.criarPanel("", 0, 0, 700, 420, jpnTab3, true);
		jpnTab3.add(jbtProcurar2);
		jpnTab3.add(jlbImagem2);
		
		jbtProcurar3 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar3);
		jbtProcurar3.addActionListener(this);
		
		jlbImagem3 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem3);
		
		jpnTab4 = cp.criarPanel("", 0, 0, 700, 420, jpnTab4, true);
		jpnTab4.add(jbtProcurar3);
		jpnTab4.add(jlbImagem3);
		
		jbtProcurar4 = cp.criarBotao("PROCURAR", 590, 0, 100, 24, jbtProcurar4);
		jbtProcurar4.addActionListener(this);
		
		jlbImagem4 = cp.criarLabel("", 0, 0, 700, 420, jlbImagem4);
		
		jpnTab5 = cp.criarPanel("", 0, 0, 700, 420, jpnTab5, true);
		jpnTab5.add(jbtProcurar4);
		jpnTab5.add(jlbImagem4);
		
		jtbPrincipal = new JTabbedPane();
		jtbPrincipal.add("Principal", jpnTab1);
		jtbPrincipal.add("Imagem 1", jpnTab2);
		jtbPrincipal.add("Imagem 2", jpnTab3);
		jtbPrincipal.add("Imagem 3", jpnTab4);
		jtbPrincipal.add("Imagem 4", jpnTab5);
		jtbPrincipal.setBounds(0,50,693,420);
		getContentPane().add(jtbPrincipal);


		setResizable(false);
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		if(e.getSource() == jrbAlugar){
			rbAlugar();
		}
		if(e.getSource() == jrbVender){
			rbVender();
		}
		if(e.getSource() == jbtProcurar1){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				File arquivo = jfcProcurar.getSelectedFile();
				try {
					BufferedImage bi = ImageIO.read(arquivo);
					BufferedImage aux= new BufferedImage(700, 420, bi.getType());
					Graphics2D g = aux.createGraphics();
					AffineTransform at = AffineTransform.getScaleInstance((double) 700 / bi.getWidth(), (double) 420 / bi.getHeight());
					g.drawRenderedImage(bi, at);
					jlbImagem1.setIcon(new ImageIcon(aux));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar2){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				File arquivo = jfcProcurar.getSelectedFile();
				try {
					BufferedImage bi = ImageIO.read(arquivo);
					BufferedImage aux= new BufferedImage(700, 420, bi.getType());
					Graphics2D g = aux.createGraphics();
					AffineTransform at = AffineTransform.getScaleInstance((double) 700 / bi.getWidth(), (double) 420 / bi.getHeight());
					g.drawRenderedImage(bi, at);
					jlbImagem2.setIcon(new ImageIcon(aux));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar3){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				File arquivo = jfcProcurar.getSelectedFile();
				try {
					BufferedImage bi = ImageIO.read(arquivo);
					BufferedImage aux= new BufferedImage(700, 420, bi.getType());
					Graphics2D g = aux.createGraphics();
					AffineTransform at = AffineTransform.getScaleInstance((double) 700 / bi.getWidth(), (double) 420 / bi.getHeight());
					g.drawRenderedImage(bi, at);
					jlbImagem3.setIcon(new ImageIcon(aux));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == jbtProcurar4){
			jfcProcurar.showOpenDialog(null);
			if(jfcProcurar.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")){				
				File arquivo = jfcProcurar.getSelectedFile();
				try {
					BufferedImage bi = ImageIO.read(arquivo);
					BufferedImage aux= new BufferedImage(700, 420, bi.getType());
					Graphics2D g = aux.createGraphics();
					AffineTransform at = AffineTransform.getScaleInstance((double) 700 / bi.getWidth(), (double) 420 / bi.getHeight());
					g.drawRenderedImage(bi, at);
					jlbImagem4.setIcon(new ImageIcon(aux));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}else{
				JOptionPane.showMessageDialog(null, "Permitido somente imagens com extensão .JPG!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
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
