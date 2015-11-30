package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import pessoa.Corretor;

public class CorretorDAOJDBC implements CorretorDAO {

	private Connection con;

	public CorretorDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	public void inserir(Corretor corretor) {
		String sql = "insert into Corretor (salario, Pessoa_idPessoa) values(? ,? ,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, corretor.getSalario());
			pstmt.setInt(2, corretor.getPessoa().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Corretor corretor) {
		String sql = "update corretor set salario = ? where idCorretor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, corretor.getSalario());
			pstmt.setInt(2, corretor.getIdCorretor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Corretor corretor) {
		String sql = "delete from Corretor where idCorretor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, corretor.getIdCorretor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Corretor buscar(Integer idCorretor) {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		Corretor corretor = null;
		String sql = "select * from corretor where idCorretor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCorretor);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				corretor = new Corretor();
				corretor.setIdCorretor(rs.getInt("idCorretor"));
				corretor.setSalario(rs.getDouble("salario"));
				corretor.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corretor;
	}

	public List<Corretor> todos() {
		PessoaDAO pessoaDao = new PessoaDAOJDBC();
		List<Corretor> corretores = new ArrayList<>();
		String sql = "select * from corretor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Corretor corretor = new Corretor();
				corretor.setIdCorretor(rs.getInt("idCorretor"));
				corretor.setSalario(rs.getDouble("salario"));
				corretor.setPessoa(pessoaDao.buscar(rs.getInt("Pessoa_idPessoa")));
				corretores.add(corretor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corretores;
	}

	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idCorretor) from corretor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				maior = rs.getInt("max(idCorretor)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}

}
