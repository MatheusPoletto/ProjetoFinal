package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.ImovelDAO;
import imovel.Imovel;
import utilitario.MensagemSucesso;

public class AlterarImovel {

	private ImovelDAO imovelDao = DaoFactoryJDBC.get().imovelDAO();
	private MensagemSucesso ms = new MensagemSucesso();
	
	public void alterarImovel(Integer idImovel, String metrosQuadrados, Double valorTotal, Double valorMensal, Integer mesesContrato,
		String imagem1, String imagem2, String imagem3, String imagem4, String descricao1,
			String descricao2, String descricao3, Integer possui) {

		if ((valorMensal > 0) && valorTotal < 1) {
			valorTotal = 0.0;
		} else if ((valorTotal > 0) && (valorMensal < 0)) {
			valorMensal = 0.0;
			mesesContrato = 0;
		}

		Imovel imovel = imovelDao.buscar(idImovel);
		imovel.setMetrosquadrados(metrosQuadrados);
		imovel.setValorTotal(valorTotal);
		imovel.setValorMensal(valorMensal);
		imovel.setMesesContrato(mesesContrato);
		imovel.setImagem1(imagem1);
		imovel.setImagem2(imagem2);
		imovel.setImagem3(imagem3);
		imovel.setImagem4(imagem4);
		imovel.setDescricao1(descricao1);
		imovel.setDescricao2(descricao2);
		imovel.setDescricao3(descricao3);
		imovel.setPossui(possui);	
		imovelDao.alterar(imovel);
		ms.sucessoCadastrarImovel();

	}
	
}
