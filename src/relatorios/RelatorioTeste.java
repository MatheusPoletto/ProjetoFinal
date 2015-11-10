package relatorios;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAOFactory.DaoFactoryJDBC;
import pessoa.Cliente;
import conexao.ConexaoUtil;
import dao.ClienteDAO;

public class RelatorioTeste {

	public static void main(String[] args) {
		

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", 1);
		
		new RelatorioUtil().viewReport(
				"src/relatorios/Cherry.jasper",
				ConexaoUtil.getCon(), parametros);

		new RelatorioUtil().gerarPdf(
				"src/relatorios/Cherry.jasper",
				ConexaoUtil.getCon(), parametros);

		ClienteDAO clienteDao = DaoFactoryJDBC.get().clienteDAO();
		List<Cliente> clientes = clienteDao.todos();
				
		new RelatorioUtil().compileViewReport(
				"src/relatorios/Cherry.jrxml",
				clientes, parametros);
		
		
	}
}
