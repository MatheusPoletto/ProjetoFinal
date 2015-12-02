package metodos;

import DAOFactory.DaoFactoryJDBC;
import dao.ImovelDAO;
import imovel.Imovel;
import pessoa.Cliente;
import pessoa.Endereco;
import utilitario.MensagemSucesso;

public class CadastrarImovel {
	private ImovelDAO imovelDao = DaoFactoryJDBC.get().imovelDAO();
	private MensagemSucesso ms = new MensagemSucesso();

	public void salvarImovel(String rua, String numero, String bairro, String cidade, String uf, String cep,
			String metrosQuadrados, Cliente cliente, Double valorTotal, Double valorMensal, Integer mesesContrato,
			Endereco endereco, String imagem1, String imagem2, String imagem3, String imagem4, String descricao1,
			String descricao2, String descricao3, Integer possui) {

		if ((valorMensal > 0) && valorTotal < 1) {
			valorTotal = 0.0;
		} else if ((valorTotal > 0) && (valorMensal < 0)) {
			valorMensal = 0.0;
			mesesContrato = 0;
		}

		Imovel imovel = new Imovel(imovelDao.maiorId(), metrosQuadrados, valorTotal, valorMensal, mesesContrato,
				endereco, cliente, imagem1, imagem2, imagem3, descricao1, descricao2, descricao3, imagem4, possui);
		imovelDao.inserir(imovel);
		ms.sucessoCadastrarImovel();

	}

}
