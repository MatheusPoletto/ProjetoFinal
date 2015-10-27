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
import pessoa.Corretor;
import pessoa.Endereco;
import pessoa.Pessoa;

public class CorretorDAOJDBC implements CorretorDAO{

	private Connection con;

	public  CorretorDAOJDBC(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public void inserir(Corretor corretor) {
		String sql = "insert into Corretor (salario, comissao, Pessoa_idPessoa) values(? ,? ,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			
			pstmt.setDouble(1, corretor.getSalario());
			pstmt.setDouble(2, corretor.getPorcentagemComissao());
			pstmt.setInt(3, corretor.getPessoa().getId());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Corretor corretor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Corretor corretor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corretor buscar(Integer id) {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		Corretor corretor = null;
		String sql = "select * from corretor where idCorretor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				corretor = new Corretor();
				corretor.setIdCorretor(rs.getInt("idCorretor"));
				corretor.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corretor;
	}

	@Override
	public List<Corretor> todos() {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		List<Corretor> corretores = new ArrayList<>();
		String sql = "select * from corretor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Corretor corretor = new Corretor();
				corretor.setIdCorretor(rs.getInt("idCorretor"));
				corretor.setSalario(rs.getDouble("salario"));
				corretor.setPorcentagemComissao(rs.getDouble("comissao"));
				corretor.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
				corretores.add(corretor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corretores;
	}

	@Override
	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idCorretor) from corretor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				maior = rs.getInt("max(idCorretor)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}
	
}
