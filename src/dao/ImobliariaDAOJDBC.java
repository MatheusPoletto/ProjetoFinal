package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Imobiliaria;
import conexao.ConexaoUtil;
import imovel.Imovel;

public class ImobliariaDAOJDBC implements ImobiliariaDAO {

	
	private Connection con;

	public  ImobliariaDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imobiliaria imobiliaria) {
		// TODO Auto-generated method stub
		
		String sql = "insert into Imobiliaria(nomeFantasia, razaoSocial, cnpj, idEndereco, telefone) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, imobiliaria.getRazaoSocial());
			pstmt.setString(2, imobiliaria.getNomeFantasia());
			pstmt.setString(3, imobiliaria.getCnpj());
			pstmt.setInt(4, imobiliaria.getEndereco().getId());
			pstmt.setString(5, imobiliaria.getTelefone());
			pstmt.executeUpdate(); 
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Imobiliaria imobiliaria) {
		String sql = "update imobiliaria set nomeFantasia = ?, razaoSocial = ?, cnpj = ?, telefone = ? where idImobiliaria = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, imobiliaria.getRazaoSocial());
			pstmt.setString(2, imobiliaria.getNomeFantasia());
			pstmt.setString(3, imobiliaria.getCnpj());
			pstmt.setString(4, imobiliaria.getTelefone());
			pstmt.setInt(5, imobiliaria.getIdImobiliaria());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void excluir(Imobiliaria imobiliaria) {
		String sql = "delete from Imobiliaria where idImobiliaria = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, imobiliaria.getIdImobiliaria());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Imobiliaria buscar(Integer id){
		EnderecoDAO enderecoDao = new EnderecoDAOJDBC();
		Imobiliaria imobiliaria = null;
		String sql = "select * from imobiliaria where idImobiliaria = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				imobiliaria = new Imobiliaria();
				imobiliaria.setIdImobiliaria(rs.getInt("idImobiliaria"));
				imobiliaria.setNomeFantasia(rs.getString("nomeFantasia"));
				imobiliaria.setRazaoSocial(rs.getString("razaoSocial"));
				imobiliaria.setEndereco(enderecoDao.buscar(rs.getInt("idEndereco")));
				imobiliaria.setTelefone(rs.getString("telefone"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return imobiliaria;
	}

	@Override
	public List<Imobiliaria> todos() {
		EnderecoDAO enderecoDao = new EnderecoDAOJDBC();
		List<Imobiliaria> imobiliarias = new ArrayList<>();
		String sql = "select * from imobiliaria";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Imobiliaria imobiliaria = new Imobiliaria();
				imobiliaria.setIdImobiliaria(rs.getInt("idImobiliaria"));
				imobiliaria.setNomeFantasia(rs.getString("nomeFantasia"));
				imobiliaria.setRazaoSocial(rs.getString("razaoSocial"));
				imobiliaria.setEndereco(enderecoDao.buscar(rs.getInt("idEndereco")));
				imobiliaria.setTelefone(rs.getString("telefone"));
				imobiliarias.add(imobiliaria);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return imobiliarias;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idImobiliaria) from imobiliaria";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idImobiliaria)");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return maior;
	}
}
