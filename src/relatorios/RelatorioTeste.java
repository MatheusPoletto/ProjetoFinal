package relatorios;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAOFactory.DaoFactoryJDBC;
import pessoa.Cliente;
import conexao.ConexaoUtil;

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

		List<Cliente> clientes = DaoFactoryJDBC.get().clienteDAO().todos();
				
		new RelatorioUtil().compileViewReport(
				"src/relatorios/Cherry.jrxml",
				clientes, parametros);
	}
}
