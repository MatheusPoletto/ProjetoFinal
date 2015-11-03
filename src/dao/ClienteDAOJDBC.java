package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOFactory.DaoFactoryJDBC;
import conexao.ConexaoUtil;
import pessoa.Cliente;
import pessoa.Endereco;
import pessoa.Pessoa;

public class ClienteDAOJDBC implements ClienteDAO{
	private Connection con;

	public  ClienteDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Cliente cliente) {
		String sql = "insert into Cliente (Pessoa_idPessoa, interesse1, interesse2, interesse3) values( ?, ?, ? , ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, cliente.getPessoa().getId());
			pstmt.setString(2, cliente.getInteresse1());
			pstmt.setString(3, cliente.getInteresse2());
			pstmt.setString(4, cliente.getInteresse3());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Cliente cliente) {
		String sql = "update cliente set interesse1 = ?, interesse2 = ?, interesse3 = ? where idCliente = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cliente.getInteresse1());
			pstmt.setString(2, cliente.getInteresse2());
			pstmt.setString(3, cliente.getInteresse3());
			pstmt.setInt(4, cliente.getIdCliente());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void excluir(Cliente cliente) {
		String sql = "delete from Cliente where idCliente = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cliente.getIdCliente());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cliente buscar(Integer id) {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		Cliente cliente = null;
		//String sql = "select * from cliente where idCliente = ?";
		String sql = "select * from cliente where Pessoa_idPessoa = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setInteresse1(rs.getString("interesse1"));
				cliente.setInteresse2(rs.getString("interesse2"));
				cliente.setInteresse3(rs.getString("interesse3"));
				cliente.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public List<Cliente> todos() {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from cliente";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setInteresse1(rs.getString("interesse1"));
				cliente.setInteresse2(rs.getString("interesse2"));
				cliente.setInteresse3(rs.getString("interesse3"));
				cliente.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idCliente) from cliente";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idCliente)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}
	
	
}
