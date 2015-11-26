package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import conexao.ConexaoUtil;
import imovel.Imovel;

public class ImovelDAOJDBC implements ImovelDAO{

	
	
	private Connection con;

	public  ImovelDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}

	@Override
	public void inserir(Imovel imovel) {
		String sql = "insert into Imovel (metrosQuadrados, Cliente_idCliente, valorTotal, valorMensal, mesesContrato, Endereco_idEndereco, imagem1, imagem2, imagem3, descricao1, descricao2, descricao3, imagem4, possui) values(?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, imovel.getMetrosquadrados());
			pstmt.setInt(2, imovel.getCliente().getIdCliente());
			pstmt.setDouble(3, imovel.getValorTotal());
			pstmt.setDouble(4, imovel.getValorMensal());
			pstmt.setInt(5, imovel.getMesesContrato());
			pstmt.setInt(6, imovel.getEndereco().getId());
			pstmt.setString(7, imovel.getImagem1());
			pstmt.setString(8, imovel.getImagem2());
			pstmt.setString(9, imovel.getImagem3());
			pstmt.setString(10, imovel.getDescricao1());
			pstmt.setString(11, imovel.getDescricao2());
			pstmt.setString(12, imovel.getDescricao3());
			pstmt.setString(13, imovel.getImagem4());
			pstmt.setInt(14, imovel.getPossui());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
		
	}

	@Override
	public void alterar(Imovel imovel) {
		String sql = "update imovel set metrosQuadrados = ?, valorTotal = ?, valorMensal = ?, mesesContrato = ?, imagem1 = ?, imagem 2 = ?, imagem 3 = ?, imagem 4 = ?, descricao1 = ?, descricao2 = ?, descricao3 = ?, possui = ? where idCliente = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, imovel.getMetrosquadrados());
			pstmt.setDouble(2, imovel.getValorTotal());
			pstmt.setDouble(3, imovel.getValorMensal());
			pstmt.setInt(4, imovel.getMesesContrato());
			pstmt.setString(5, imovel.getImagem1());
			pstmt.setString(6, imovel.getImagem2());
			pstmt.setString(7, imovel.getImagem3());
			pstmt.setString(8, imovel.getImagem4());
			pstmt.setString(9, imovel.getDescricao1());
			pstmt.setString(10, imovel.getDescricao2());
			pstmt.setString(11, imovel.getDescricao3());
			pstmt.setInt(12, imovel.getPossui());
			pstmt.setInt(13, imovel.getIdImovel());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Imovel imovel) {
		String sql = "delete from Imovel where idImovel = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, imovel.getIdImovel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Imovel buscar(Integer id) {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		EnderecoDAO enderecoDao = new EnderecoDAOJDBC();
		Imovel imovel = null;
		String sql = "select * from imovel where idImovel = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				imovel = new Imovel();
				imovel.setIdImovel(rs.getInt("idImovel"));
				imovel.setMetrosquadrados(rs.getString("metrosQuadrados"));
				imovel.setCliente(clienteDao.buscar(rs.getInt("Cliente_idCliente")));
				imovel.setValorTotal(rs.getDouble("valorTotal"));
				imovel.setValorMensal(rs.getDouble("valorMensal"));
				imovel.setMesesContrato(rs.getInt("mesesContrato"));
				imovel.setEndereco(enderecoDao.buscar(rs.getInt("Endereco_idEndereco")));
				imovel.setImagem1(rs.getString("imagem1"));
				imovel.setImagem2(rs.getString("imagem2"));
				imovel.setImagem3(rs.getString("imagem3"));
				imovel.setImagem4(rs.getString("imagem4"));
				imovel.setDescricao1(rs.getString("descricao1"));
				imovel.setDescricao2(rs.getString("descricao2"));
				imovel.setDescricao3(rs.getString("descricao3"));
				imovel.setPossui(rs.getInt("possui"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return imovel;
	}

	@Override
	public List<Imovel> todos() {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		EnderecoDAO enderecoDao = new EnderecoDAOJDBC();
		List<Imovel> imoveis = new ArrayList<>();
		String sql = "select * from imovel";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Imovel imovel = new Imovel();
				imovel.setIdImovel(rs.getInt("idImovel"));
				imovel.setMetrosquadrados(rs.getString("metrosQuadrados"));
				imovel.setCliente(clienteDao.buscar(rs.getInt("Cliente_idCliente")));
				imovel.setValorTotal(rs.getDouble("valorTotal"));
				imovel.setValorMensal(rs.getDouble("valorMensal"));
				imovel.setMesesContrato(rs.getInt("mesesContrato"));
				imovel.setEndereco(enderecoDao.buscar(rs.getInt("Endereco_idEndereco")));
				imovel.setImagem1(rs.getString("imagem1"));
				imovel.setImagem2(rs.getString("imagem2"));
				imovel.setImagem3(rs.getString("imagem3"));
				imovel.setImagem4(rs.getString("imagem4"));
				imovel.setDescricao1(rs.getString("descricao1"));
				imovel.setDescricao2(rs.getString("descricao2"));
				imovel.setDescricao3(rs.getString("descricao3"));
				imovel.setPossui(rs.getInt("possui"));
				imoveis.add(imovel);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return imoveis;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idImovel) from imovel";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idImovel)");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return maior;
	}
	
}
