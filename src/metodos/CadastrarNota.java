package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.ImobiliariaDAO;
import dao.ImovelDAO;
import dao.NotaFiscalDAO;
import dao.VendaDAO;
import imovel.Imovel;
import model.Imobiliaria;
import model.NotaFiscal;
import model.Venda;
import pessoa.Cliente;
import pessoa.Corretor;

public class CadastrarNota {

	private VendaDAO vendaDao = DaoFactoryJDBC.get().vendaDAO();
	private ImovelDAO imoveldao = DaoFactoryJDBC.get().imovelDAO();
	private NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
	private ImobiliariaDAO imoDao = DaoFactoryJDBC.get().imobiliariaDAO();

	public Venda salvarVenda(String horaAgora, Double comissaoImobiliaria, Double comissaoCorretor, Imovel imovelVenda, Cliente clienteProprietario, Corretor corretorResponsavel){
  	Venda venda = new Venda(vendaDao.maiorId()+1, horaAgora, comissaoImobiliaria, comissaoCorretor, imovelVenda, clienteProprietario, corretorResponsavel); 
  	vendaDao.inserir(venda);
	
  	imovelVenda.setPossui(0);
    imoveldao.alterar(imovelVenda);
	
  	return venda; 

	}

	public NotaFiscal gerarNota(Double total, String horaAgora, Venda venda) {
		Imobiliaria imobiliaria = imoDao.buscar(1);
		NotaFiscal nf = new NotaFiscal(nfDao.maiorId() + 1, horaAgora, total, imobiliaria, venda);
		nfDao.inserir(nf);
		return nf;
	}

}
