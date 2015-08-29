package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
	

	
	private static Connection connection;
	
	
	static {
		
		String endereco = ""; // colocar aqui depois que criar o banco de dados 
		String usuario = "root";
		String senha = "root";
		
	
		
		try {
			
			 connection = DriverManager.getConnection(endereco, usuario, senha);
				
			}catch(SQLException e){
				
				System.out.println("Erro ao conectar ao banco de dados");
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	} 
	public static Connection getCon(){
	return connection; 
	
	
}









}