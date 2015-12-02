package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.NotaFiscalDAO;
import dao.VendaDAO;
import model.NotaFiscal;
import model.Venda;

public class AlterarNota {

	private NotaFiscalDAO nfDao = DaoFactoryJDBC.get().notaFiscalDAO();
	private VendaDAO vendaoDao = DaoFactoryJDBC.get().vendaDAO();

	public void excluirNota(NotaFiscal nf, Venda venda) {
		nfDao.excluir(nf);
		vendaoDao.excluir(venda);
	}

}
