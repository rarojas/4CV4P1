package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.escom.distribuidos.core.LocalProperties;

public class BDConexion {

	String dbURL = "jdbc:mysql://localhost:3306/cursos";
	String username = "root";
	String password = "";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	protected BDConexion() {

	}

	public Connection open() throws SQLException {
		try {
			LocalProperties localProperties = LocalProperties.getInstance();
			this.dbURL = localProperties.getProp("bd.url");
			this.username = localProperties.getProp("bd.username");
			this.password = localProperties.getProp("bd.password");
			if (this.con == null || this.con.isClosed())
				this.con = DriverManager.getConnection(dbURL, username, password);
			return con;
		} catch (SQLException e) {
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			if (this.con != null && !this.con.isClosed())
				this.con.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	private Connection con;

	private static final BDConexion instance = new BDConexion();

	public static BDConexion getInstance() {
		return instance;
	}

	@Override
	protected void finalize() throws Throwable {

		try {
			this.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.finalize();
		}

	}
}
