package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Interesse;

public class InteresseDAOJDBC implements InteresseDAO{
	private Connection con;
	
	public InteresseDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Interesse interesse) {
		String sql = "insert into Interesses(descricao, Cliente_idCliente) values(?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, interesse.getDescricao());
			pstmt.setInt(2, interesse.getCliente().getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Interesse entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Interesse entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Interesse buscar(Integer id) {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		Interesse interesse = null;
		return null;
	}

	@Override
	public Integer maiorId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interesse> todos() {
		ClienteDAO clienteDao = new ClienteDAOJDBC();
		List<Interesse> interesses = new ArrayList<>();
		String sql = "select * from interesses";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Interesse interesse = new Interesse();
				interesse.setIdInteresse(rs.getInt("idInteresses"));
				interesse.setDescricao(rs.getString("descricao"));
				interesse.setCliente(clienteDao.buscar(rs.getInt("Cliente_idCliente")));
				interesses.add(interesse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return interesses;
	}

}
