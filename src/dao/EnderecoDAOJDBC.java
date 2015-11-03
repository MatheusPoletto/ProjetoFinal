package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pessoa.Endereco;
import conexao.ConexaoUtil;

public class EnderecoDAOJDBC implements EnderecoDAO{
	private Connection con;

	public  EnderecoDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Endereco endereco) {
		String sql = "insert into Endereco(rua, numero, bairro, cidade, cep, uf) values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, endereco.getRua());
			pstmt.setString(2, endereco.getNumero());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getCidade());
			pstmt.setString(5, endereco.getCep());
			pstmt.setString(6, endereco.getUf());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	public Integer maiorId(){
		Integer maior = null;
		String sql = "select max(idEndereco) from endereco";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idEndereco)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}

	@Override
	public void alterar(Endereco endereco) {
		String sql = "update Endereco set rua=?, numero=?,"
				+ " bairro = ?, cidade = ?, cep = ?, uf = ? where idEndereco = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, endereco.getRua());
			pstmt.setString(2, endereco.getNumero());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getCidade());
			pstmt.setString(5, endereco.getCep());
			pstmt.setString(6, endereco.getUf());
			pstmt.setInt(7, endereco.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void excluir(Endereco endereco) {
		String sql = "delete from Endereco where idEndereco = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, endereco.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Endereco buscar(Integer id) {
		Endereco endereco = null;
		String sql = "select * from endereco where idEndereco = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				endereco = new Endereco();
				endereco.setId(rs.getInt("idEndereco"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setUf(rs.getString("uf"));
				endereco.setCep(rs.getString("cep"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return endereco;
	}

	@Override
	public List<Endereco> todos() {
		List<Endereco> enderecos = new ArrayList<>();
		String sql = "select * from endereco";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("idEndereco"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setUf(rs.getString("uf"));
				enderecos.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enderecos;
	}
	
	
}
