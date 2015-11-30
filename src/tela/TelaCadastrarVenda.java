package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAOFactory.DaoFactoryJDBC;
import dao.ClienteDAO;
import dao.ImobiliariaDAO;
import dao.NotaFiscalDAO;
import dao.VendaDAO;
import imovel.Imovel;
import model.Imobiliaria;
import model.NotaFiscal;
import model.Venda;
import pessoa.Cliente;
import pessoa.Corretor;
import utilitario.CriarCamponentes;

public class TelaCadastrarVenda extends JInternalFrame implements ActionListener{
	private CriarCamponentes cp = new CriarCamponentes();
	private JPanel jpnImovel;
	private JLabel jlbTitulo;
	private JTextArea jtaImovel;
	private JPanel jpnProprietarioImovel;
	private JTextArea jtaProprietario;
	private JPanel jpnObservacao;
	private JTextArea jtaObservacao;
	private JLabel jlbNovo, jlbRG, jlbNome, jlbCpf;
	private JTextField jtfRg, jtfNome, jtfCpf;
	private JButton jbtProcurar, jbtNovo;
	private JPanel jpnLocalizador;
	private JLabel jlbValorImovel, jlbComissaoCorretor, jlbComissaoImobiliaria, jlbCorretorNome;
	private JTextField jtfValorImovel, jtfComissaoCorretor, jtfComissaoImobiliaria, jtfNomeCorretor;
	private JButton jbtProcurarCorretor;
	private JButton jbtRegistrarNota;
	private JPanel jpnValores;
	private Imovel imovelVenda;
	private ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
	private VendaDAO vendaDao = DaoFactoryJDBC.get().vendaDAO();
	private Cliente ClienteComprador, clienteProprietario;
	private Corretor CorretorResponsavel;

	
	public TelaCadastrarVenda() {
		setTitle("CADASTRO DE VENDA");
		setLayout(null);

		jlbTitulo = cp.criarLabelTitulo("CADASTRO DE VENDA", 0, 0, 850, 44, jlbTitulo);
		getContentPane().add(jlbTitulo);
		
		criarPanelLocalizadorProprietario();
		
		jtaImovel = new JTextArea();
		jtaImovel.setBounds(10, 20, 390, 60);
		jtaImovel.setVisible(true);
		jtaImovel.setLineWrap(true);
		jtaImovel.setWrapStyleWord(true);
		jtaImovel.setEnabled(true);
			
		
		
		jpnImovel = cp.criarPanel("IMÓVEL", 10, 50, 410, 95, jpnImovel, true);
		jpnImovel.add(jtaImovel);
		//jpnImovel.add(jtfPreco);
		getContentPane().add(jpnImovel);
		
		jtaProprietario = new JTextArea();
		jtaProprietario.setBounds(10, 20, 390, 60);
		jtaProprietario.setVisible(true);
		jtaProprietario.setLineWrap(true);
		jtaProprietario.setWrapStyleWord(true);
		jtaProprietario.setEnabled(true);
		
		jpnProprietarioImovel = cp.criarPanel("PROPRIETÁRIO DO IMÓVEL", 430, 50, 410, 95, jpnProprietarioImovel, true);
		jpnProprietarioImovel.add(jtaProprietario);
		getContentPane().add(jpnProprietarioImovel);
		
		jtaObservacao = new JTextArea();
		jtaObservacao.setBounds(10, 20, 810, 60);
		jtaObservacao.setVisible(true);
		jtaObservacao.setLineWrap(true);
		jtaObservacao.setWrapStyleWord(true);
		jtaObservacao.setEnabled(true);
		
		jtaObservacao.setText("Agents os shield é um bom seriado!");
		
		jpnObservacao = cp.criarPanel("OBSERVAÇÃO", 10, 150, 830, 95, jpnObservacao, true);
		jpnObservacao.add(jtaObservacao);
		getContentPane().add(jpnObservacao);
		
		jtaImovel.setText("Rua: Irineu Bornhausen - Número: 150 \nBairro: Antonio Paglia - Cidade: Ponte Serrada - Cep: 89683-000");
		jtaProprietario.setText("Nome: Matheus Otavio Poletto - RG: 6.516.358\nTel. Residencial: +55 (049) 3435-0904 - Tel. Celular: +55 (049) 9954-9681 - Email: motaviop@gmail.com");
		
		jlbValorImovel = cp.criarLabel("PREÇO DO IMÓVEL:", 10, 20, 120, 24, jlbValorImovel);
		jtfValorImovel = cp.criarTextField(130, 20, 100, 24, jtfValorImovel);
		jtfValorImovel.setEnabled(false);
		
		jlbComissaoImobiliaria = cp.criarLabel("COMISSÃO DA IMOBILIÁRIA COM A VENDA: ", 240, 20, 250, 24, jlbComissaoImobiliaria);
		jtfComissaoImobiliaria = cp.criarTextField(490, 20, 100, 24, jtfComissaoImobiliaria);
		
		jlbCorretorNome = cp.criarLabel("CORRETOR RESPONSÁVEL: ", 10, 50, 200, 24, jlbCorretorNome);
		jtfNomeCorretor = cp.criarTextField(180, 50, 300, 24, jtfNomeCorretor);
		jbtProcurarCorretor = cp.criarBotao("PROCURAR", 490, 50, 100, 24, jbtProcurarCorretor);
		jbtProcurarCorretor = cp.alterarCorBotoes(jbtProcurarCorretor);
		jbtProcurarCorretor.addActionListener(this);
		
		jlbComissaoCorretor = cp.criarLabel("COMISSÃO DO CORRETOR RESPONSÁVEL PELA A VENDA: ", 10, 80, 340, 24, jlbComissaoImobiliaria);
		jtfComissaoCorretor = cp.criarTextField(350, 80, 130, 24, jtfComissaoImobiliaria);
		
		jpnValores = cp.criarPanel("VALORES", 10, 350, 600, 110, jpnValores, true);
		jpnValores.add(jlbValorImovel);
		jpnValores.add(jtfValorImovel);
		jpnValores.add(jlbComissaoImobiliaria);
		jpnValores.add(jtfComissaoImobiliaria);
		jpnValores.add(jlbCorretorNome);
		jpnValores.add(jtfNomeCorretor);
		jpnValores.add(jbtProcurarCorretor);
		jpnValores.add(jlbComissaoCorretor);
		jpnValores.add(jtfComissaoCorretor);
		getContentPane().add(jpnValores);
		
		jbtRegistrarNota = cp.criarBotao("SALVAR E GERAR NOTA FISCAL", 617, 430, 220, 24, jbtRegistrarNota);
		jbtRegistrarNota.addActionListener(this);
		jbtRegistrarNota = cp.alterarCorBotoes(jbtRegistrarNota);
		getContentPane().add(jbtRegistrarNota);
		
		setSize(865, 500);
		setVisible(true);
		setClosable(true);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaCadastrarVenda();
	}
	
	public void preencherCampos(Imovel imovel){	
		this.imovelVenda = imovel;
		Cliente proprietario = imovel.getCliente();
		jtaImovel.setText("Rua:" + imovel.getEndereco().getRua() + " - Número: " +imovel.getEndereco().getRua());
		jtaImovel.setText("Bairro: " + imovel.getEndereco().getBairro() + " - Cidade: " + imovel.getEndereco().getCidade() + " - CEP: " + imovel.getEndereco().getCep());
		
		if(imovel.getValorTotal() > 1){
			jtfValorImovel.setText(String.valueOf(imovel.getValorTotal()));
		}else if(imovel.getValorMensal() > 1){
			jtfValorImovel.setText(String.valueOf(imovel.getValorMensal() * imovel.getMesesContrato()));
		}
		
		jtaProprietario.setText("Nome: " + proprietario.getPessoa().getNome() + " - RG: " +proprietario.getPessoa().getRg());
		jtaProprietario.setText("Tel. Residencial: "+ proprietario.getPessoa().getTelefoneResidencial() + " - Tel. Celular: "+proprietario.getPessoa().getTelefoneCelular() + " - Email: "+proprietario.getPessoa().getEmail());
	}

	private void criarPanelLocalizadorProprietario() {
		jlbNovo = cp.criarLabel("CADASTRAR:", 20, 20, 105, 24, jlbNovo);
		jlbRG = cp.criarLabel("OU PESQUISAR POR RG:", 220, 20, 150, 24, jlbRG);
		jlbNome = cp.criarLabel("NOME:", 20, 55, 50, 24, jlbNome);
		jlbCpf = cp.criarLabel("CPF:", 330, 55, 50, 24, jlbCpf);

		jtfRg = cp.criarTextField(370, 20, 100, 24, jtfRg);
		jtfNome = cp.criarTextField(65, 55, 250, 24, jtfNome);
		jtfNome.setEnabled(false);
		jtfCpf = cp.criarTextField(360, 55, 150, 24, jtfCpf);
		jtfCpf.setEnabled(false);

		jbtProcurar = cp.criarBotao("LOCALIZAR", 500, 20, 100, 24, jbtProcurar);
		jbtProcurar = cp.alterarCorBotoes(jbtProcurar);
		jbtNovo = cp.criarBotao("NOVO", 100, 20, 105, 24, jbtNovo);
		jbtNovo = cp.alterarCorBotoes(jbtNovo);
		jbtProcurar.addActionListener(this);
		jbtNovo.addActionListener(this);

		jpnLocalizador = cp.criarPanel("COMPRADOR", 10, 250, 830, 95, jpnLocalizador, true);
		jpnLocalizador.add(jlbNovo);
		jpnLocalizador.add(jlbRG);
		jpnLocalizador.add(jtfRg);
		jpnLocalizador.add(jbtProcurar);
		jpnLocalizador.add(jbtNovo);
		jpnLocalizador.add(jlbNome);
		jpnLocalizador.add(jtfNome);
		jpnLocalizador.add(jlbCpf);
		jpnLocalizador.add(jtfCpf);
		getContentPane().add(jpnLocalizador);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtNovo){
			telaPrincipal.getTlPrincipal().getTlCadastraCliente().setVisible(true);
		}
		
		if(e.getSource() == jbtProcurar){
			if(jtfRg.getText().equals("") || (jtfRg.getText().isEmpty())){
				telaPrincipal.getTlPrincipal().getTlProcurarCliente().setVisible(true);
				telaPrincipal.getTlPrincipal().getTlProcurarCliente().setLocation(telaPrincipal.getTlPrincipal().getTlProcurarCliente().getX(), 10);
				telaPrincipal.getTlPrincipal().getTlProcurarCliente().setIsVenda(1);
			}else{
			for (Cliente cliente : clienteDao.todos()) {
				if (cliente.getPessoa().getRg().equals(jtfRg.getText())) {
					this.ClienteComprador = cliente;
					jtfNome.setText(cliente.getPessoa().getNome());
					jtfCpf.setText(cliente.getPessoa().getCpf());
				}
			}
			}
		}
		
		if(e.getSource() == jbtProcurarCorretor){
			telaPrincipal.getTlPrincipal().getTlProcurarCorretor().setVisible(true);
			telaPrincipal.getTlPrincipal().getTlProcurarCorretor().setLocation(telaPrincipal.getTlPrincipal().getTlProcurarCorretor().getX(), 10);
		}
		
		if(e.getSource() == jbtRegistrarNota){
			java.util.Date dt = new java.util.Date();
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String horaAgora = sdf.format(dt);
			Venda venda = new Venda(vendaDao.maiorId()+1, horaAgora, Double.valueOf(jtfComissaoImobiliaria.getText()), Double.valueOf(jtfComissaoCorretor.getText()), imovelVenda, clienteProprietario, CorretorResponsavel);
			vendaDao.inserir(venda);
			
				NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
				ImobiliariaDAO imoDao = DaoFactoryJDBC.get().imobiliariaDAO();
				Imobiliaria imobiliaria = imoDao.buscar(1);
				Double total = Double.valueOf(String.format(Locale.US, "%.2f", Math.floor(Double.valueOf(jtfValorImovel.getText()) + Double.valueOf(jtfComissaoCorretor.getText()) + Double.valueOf(jtfComissaoImobiliaria.getText()))));
				NotaFiscal nf = new NotaFiscal(nfDao.maiorId()+1, horaAgora, total, imobiliaria, venda);
				nfDao.inserir(nf);
				
				telaPrincipal.getTlPrincipal().esconderTelas();
				telaPrincipal.getTlPrincipal().getTlAlterarNota().preencherCampos(venda, nf, total);
				telaPrincipal.getTlPrincipal().getTlAlterarNota().setVisible(true);
			
			
		}
	}
	
	public void selecionouCorretor(Corretor corretor){
		this.CorretorResponsavel = corretor;
		jtfNomeCorretor.setText(CorretorResponsavel.getPessoa().getNome() + " - RG:" + CorretorResponsavel.getPessoa().getRg());
	}
	
	public void selecionouProprietario(Cliente cliente){
		this.clienteProprietario = cliente;
		jtfNome.setText(cliente.getPessoa().getNome());
		jtfCpf.setText(cliente.getPessoa().getCpf());
		jtfRg.setText(cliente.getPessoa().getRg());
	}
	
	

}
