package testes;

import model.Cliente;
import model.Imovel;
import model.Proprietario;
import model.Venda;

public class Main {
	public static void main(String[] args) {
		/*Para um nova venda temos:
		 * 1o = um imovel para vender
		 * 2o = um cliente para compar
		 * 3o = salvar essa compra*/
		
		//1o
		Proprietario proprietario1 = new Proprietario("Matheus Poletto", "1.345.33.3131-3", "6.553.133", 
				"motaviop@gmail.com", "3435-0904");
		Venda venda1 = new Venda(1, "sc", "ponte serrada", "antonio paglia", "irineu", 150, proprietario1);
		venda1.setValorTotal(130000.50);
		//tenho meu imovel para vender
		
		//2o
		Cliente cliente1 = new Cliente(1, "Bruna Serrano da Cruz", "8.313.345-10", "3.546.109", "SC", 
				"Ponte Serrada", "Irineu Bornhausen", "Antonio Paglia", 170, 8970.10, "3435-0904", "Apartamento");
		
		
	}
}
