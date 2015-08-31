package testes;

import model.Imovel;
import model.Proprietario;

public class Main {
	public static void main(String[] args) {
		/*Para um nova venda temos:
		 * 1o = um imovel para vender
		 * 2o = um cliente para compar
		 * 3o = salvar essa compra*/
		
		//1o
		Proprietario proprietario1 = new Proprietario("Matheus Poletto", "1.345.33.3131-3", "6.553.133", "motaviop@gmail.com", "3435-0904");
		
		
		Imovel imovel1 = new Imovel(1, "sc", "ponte serrada", "antonio paglia", "irineu bornhausen", 150, proprietario1);
		
	}
}
