package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOFactory.DaoFactoryJDBC;
import pessoa.Endereco;
import pessoa.Pessoa;
import conexao.ConexaoUtil;

public class EnderecoDAOJDBC implements EnderecoDAO{
	private Connection con;

	public  EnderecoDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Endereco entidade) {
		String sql = "insert into Endereco(rua, numero, bairro, cidade, cep, uf) values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, entidade.getRua());
			pstmt.setString(2, entidade.getNumero());
			pstmt.setString(3, entidade.getBairro());
			pstmt.setString(4, entidade.getCidade());
			pstmt.setString(5, entidade.getCep());
			pstmt.setString(6, entidade.getUf());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
