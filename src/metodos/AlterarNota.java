package metodos;

public class AlterarNota {

//CORRIGIR!
  private NotaFiscalDAO nfDao = DAOFACTORYJDBC.get().notaFiscalDAO;

  public excluirNota(NotaFiscal nf, Venda venda){
  	nfDao.excluir(nf);
	  vendaDao.excluir(venda);
  }

}
