package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Corretor;

public class CorretorDAOJDBC implements CorretorDAO{

	private Connection con;

	public  CorretorDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Corretor Corretor) {
		// TODO Auto-generated method stub
		
		
		
		/*String sql = "insert into Corretor (nomecorretor, cpf, rg, uf, cidade, rua, numero, salario, comissao, telefone) values(?, ?, ?, ?, ?, ?,?,?,?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			

			
			pstmt.setString(1, Corretor.getNomeCorretor());
			pstmt.setString(2, Corretor.getCpf());
			pstmt.setString(3, Corretor.getRg());
			pstmt.setString(4, Corretor.getUf());
			pstmt.setString(5,Corretor.getCidade());
			pstmt.setString(6,Corretor.getRua());
			pstmt.setInt(7, Corretor.getNumero());
			pstmt.setDouble(8, Corretor.getSalario());
			pstmt.setDouble(9, Corretor.getComissão());
			pstmt.setString(10, Corretor.getTelefone());
			
			
			
			
			
			pstmt.executeUpdate(); 
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
			
		}
		
		
		
		*/
	}

	@Override
	public void alterar(Corretor Corretor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Corretor Corretor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corretor buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Corretor> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
