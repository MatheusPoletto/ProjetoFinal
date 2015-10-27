package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOFactory.DaoFactoryJDBC;
import conexao.ConexaoUtil;
import pessoa.Endereco;
import pessoa.Pessoa;

public class PessoaDAOJDBC implements PessoaDAO{
	private Connection con;

	public  PessoaDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Pessoa pessoa) {
		String sql = "insert into Pessoa(nome, rg, cpf, estadoCivil, genero, dataNascimento, telefoneResidencial, telefoneCelular, email, Endereco_idEndereco) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getRg());
			pstmt.setString(3, pessoa.getCpf());
			pstmt.setString(4, pessoa.getEstadoCivil());
			pstmt.setString(5, pessoa.getGenero());
			java.util.Date dataUtil = pessoa.getDataNascimento();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());  
			pstmt.setDate(6, dataSql);
			pstmt.setString(7, pessoa.getTelefoneResidencial());
			pstmt.setString(8, pessoa.getTelefoneCelular());
			pstmt.setString(9, pessoa.getEmail());
			pstmt.setInt(10, pessoa.getEndereco().getId());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void alterar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> todos() {
		List<Pessoa> pessoas = new ArrayList<>();
		String sql = "select * from pessoa";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("idPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setRg(rs.getString("rg"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setEstadoCivil(rs.getString("estadoCivil"));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setTelefoneResidencial(rs.getString("telefoneResidencial"));
				pessoa.setTelefoneCelular(rs.getString("telefoneCelular"));
				pessoa.setEmail(rs.getString("email"));
			
				EnderecoDAO enderecoDao = DaoFactoryJDBC.get().enderecoDAO();
				int idEndereco = rs.getInt("Endereco_idEndereco");
				for(Endereco endereco: enderecoDao.todos()){
					if(endereco.getId() == idEndereco){
						pessoa.setEndereco(endereco);
					}
				}
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}


	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idPessoa) from pessoa";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idPessoa)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}

}
