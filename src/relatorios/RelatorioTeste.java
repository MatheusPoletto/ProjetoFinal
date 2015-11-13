package relatorios;



import java.util.HashMap;
import java.util.Map;

import conexao.ConexaoUtil;

public class RelatorioTeste {

	public static void main(String[] args) {
		


		Map<String, Object> parametros = new HashMap<String, Object>();
		new RelatorioUtil().viewReport("src/relatorios/Cherry.jasper", ConexaoUtil.getCon(),	 parametros);	
		
		
		new RelatorioUtil().gerarPdf(
				"src/relatorios/Cherry.jasper",
				ConexaoUtil.getCon(), parametros);
		
		
	}
}
