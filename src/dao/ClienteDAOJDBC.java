package dao;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import model.Cliente;

public class ClienteDAOJDBC {
	private Connection con;

	public void inserir(Cliente cliente) {
		/* criar tabelas no server
		String sql = "insert into cliente...";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
		   
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	*/	
	}
	
}
