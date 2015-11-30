package dao;

import java.sql.Connection;

import conexao.ConexaoUtil;

public class AjudaDAOJDBC {

	private Connection con;

	public AjudaDAOJDBC() {
		con = ConexaoUtil.getCon();
	}

}
