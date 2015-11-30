package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOFactory.DaoFactoryJDBC;
import conexao.ConexaoUtil;
import model.NotaFiscal;

public class NotaFiscalDAOJDBC implements NotaFiscalDAO {

	private Connection con;

	public NotaFiscalDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

	public void inserir(NotaFiscal notaFiscal) {
		String sql = "insert into notaFiscal (dataEmissao, valorTotal, idImobiliaria, idVenda) values(? ,? ,?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notaFiscal.getDataEmissao());
			pstmt.setDouble(2, notaFiscal.getValorTotal());
			pstmt.setInt(3, notaFiscal.getImobiliaria().getIdImobiliaria());
			pstmt.setInt(4, notaFiscal.getVenda().getIdhistorico());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(NotaFiscal notaFiscal) {

	}

	public void excluir(NotaFiscal notaFiscal) {
		String sql = "delete from notafiscal where idNotaFiscal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notaFiscal.getIdNotaFiscal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NotaFiscal buscar(Integer id) {
		ImobiliariaDAO imobiliariaDao = DaoFactoryJDBC.get().imobiliariaDAO();
		VendaDAO vendaDao = DaoFactoryJDBC.get().vendaDAO();
		NotaFiscal nf = null;
		String sql = "select * from notafiscal where idNotaFiscal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nf = new NotaFiscal();
				nf.setIdNotaFiscal(rs.getInt("idNotaFiscal"));
				nf.setDataEmissao(rs.getString("dataEmissao"));
				nf.setValorTotal(rs.getDouble("valorTotal"));
				nf.setImobiliaria(imobiliariaDao.buscar(rs.getInt("idImobiliaria")));
				nf.setVenda(vendaDao.buscar(rs.getInt("idVenda")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nf;
	}

	public Integer maiorId() {
		Integer maior = null;
		String sql = "select max(idNotaFiscal) from notaFiscal";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				maior = rs.getInt("max(idNotaFiscal)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maior;
	}

	public List<NotaFiscal> todos() {
		ImobiliariaDAO imobiliariaDao = DaoFactoryJDBC.get().imobiliariaDAO();
		List<NotaFiscal> nfs = new ArrayList<>();
		VendaDAO vendaDao = DaoFactoryJDBC.get().vendaDAO();
		String sql = "select * from notafiscal";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				NotaFiscal nf = new NotaFiscal();
				nf.setIdNotaFiscal(rs.getInt("idNotaFiscal"));
				nf.setDataEmissao(rs.getString("dataEmissao"));
				nf.setValorTotal(rs.getDouble("valorTotal"));
				nf.setImobiliaria(imobiliariaDao.buscar(rs.getInt("idImobiliaria")));
				nf.setVenda(vendaDao.buscar(rs.getInt("idVenda")));
				nfs.add(nf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nfs;
	}

}
