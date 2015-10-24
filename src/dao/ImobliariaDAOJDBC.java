package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Imobiliaria;
import conexao.ConexaoUtil;

public class ImobliariaDAOJDBC implements ImobiliariaDAO {

	
	private Connection con;

	public  ImobliariaDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imobiliaria imobiliaria) {
		// TODO Auto-generated method stub
		
		String sql = "insert into Imobiliaria (razaosocial, nomefantasia, cnpj, uf, cidade, rua , bairro, numero, telefone, nomeproprietario) values(?, ?, ?, ?, ?, ?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			
			pstmt.setString(1, imobiliaria.getRazaoSocial());
			pstmt.setString(2, imobiliaria.getNomeFantasia());
			pstmt.setString(3, imobiliaria.getCnpj());
			pstmt.setString(4, imobiliaria.getUf());
			pstmt.setString(5, imobiliaria.getCidade());
			pstmt.setString(6, imobiliaria.getRua());
			pstmt.setString(7, imobiliaria.getBairro());
			pstmt.setInt(8, imobiliaria.getNumero());
			pstmt.setString(9, imobiliaria.getTelefone());
			pstmt.setString(10, imobiliaria.getNomeProprietario());
			
			
			
			
			
			pstmt.executeUpdate(); 
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
			
		}
		
	}

	@Override
	public void alterar(Imobiliaria imobiliaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Imobiliaria imobiliaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Imobiliaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imobiliaria> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}
}
