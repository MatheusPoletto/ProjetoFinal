package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import imovel.Imovel;
import model.Venda;


public class VendaDAOJDBC implements VendaDAO{

	private Connection con;

	public  VendaDAOJDBC(){
		con = ConexaoUtil.getCon();
		

	}
	
	@Override
	public void inserir(Venda venda) {
		String sql = "insert into venda(data, comissaoImobiliaria, comissaoCorretor, idCliente, idImovel, idCorretor) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, venda.getData());
			pstmt.setDouble(2, venda.getComissaoImobiliaria());
			pstmt.setDouble(3, venda.getComissaoCorretor());
			pstmt.setInt(4, venda.getCliente().getIdCliente());
			pstmt.setInt(5, venda.getImovel().getIdImovel());
			pstmt.setInt(6, venda.getCorretor().getIdCorretor());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Venda venda) {
		String sql = "update imovel set data = ?, comissaoImobiliaria = ?, comissaoCorretor = ? where idImovel = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, venda.getData());
			pstmt.setDouble(2, venda.getComissaoImobiliaria());
			pstmt.setDouble(3, venda.getComissaoCorretor());
			pstmt.setInt(4, venda.getIdhistorico());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Venda venda) {
		String sql = "delete from venda where idVenda = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, venda.getIdhistorico());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Venda buscar(Integer id) {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		CorretorDAO corretorDao = new CorretorDAOJDBC();
		ImovelDAO imovelDao = new ImovelDAOJDBC();
		Venda venda = null;
		String sql = "select * from venda where idVenda = ?";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				venda = new Venda();
				venda.setIdhistorico(rs.getInt("idVenda"));
				venda.setData(rs.getString("data"));
				venda.setComissaoCorretor(rs.getDouble("comissaoCorretor"));
				venda.setComissaoImobiliaria(rs.getDouble("comissaoImobiliaria"));
				venda.setCorretor(corretorDao.buscar(rs.getInt("idCorretor")));
				venda.setCliente(clienteDao.buscar(rs.getInt("idCliente")));
				venda.setImovel(imovelDao.buscar(rs.getInt("idImovel")));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return venda;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idVenda) from venda";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idVenda)");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return maior;
	}
	

	@Override
	public List<Venda> todos() {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		CorretorDAO corretorDao = new CorretorDAOJDBC();
		ImovelDAO imovelDao = new ImovelDAOJDBC();
		List<Venda> vendas = new ArrayList<>();
		Venda venda;
		String sql = "select * from venda";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				venda = new Venda();
				venda.setIdhistorico(rs.getInt("idVenda"));
				venda.setData(rs.getString("data"));
				venda.setComissaoCorretor(rs.getDouble("comissaoCorretor"));
				venda.setComissaoImobiliaria(rs.getDouble("comissaoImobiliaria"));
				venda.setCorretor(corretorDao.buscar(rs.getInt("idCorretor")));
				venda.setCliente(clienteDao.buscar(rs.getInt("idCliente")));
				venda.setImovel(imovelDao.buscar(rs.getInt("idImovel")));
				vendas.add(venda);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return vendas;
	}

}
