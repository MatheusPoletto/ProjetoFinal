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
import pessoa.Pessoa;

public class ClienteDAOJDBC implements ClienteDAO{
	private Connection con;

	public  ClienteDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Cliente cliente) {
		String sql = "insert into Cliente (Pessoa_idPessoa) values( ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, cliente.getPessoa().getId());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> todos() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "select * from cliente";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				
				PessoaDAO pessoaDao = DaoFactoryJDBC.get().pessoaDAO();
				int idPessoa = rs.getInt("Pessoa_idPessoa");
				for(Pessoa pessoa : pessoaDao.todos()){
					if(pessoa.getId() == idPessoa){
						cliente.setPessoa(pessoa);
					}
				}
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
