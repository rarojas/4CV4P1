package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexion {

	String dbURL = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "root";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	protected BDConexion() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Connection open() throws SQLException {
		try {
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
}
