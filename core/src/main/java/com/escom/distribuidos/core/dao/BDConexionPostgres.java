package com.escom.distribuidos.core.dao;

import com.escom.distribuidos.core.LocalProperties;

public class BDConexionPostgres extends BDConexion {

	static final String JDBC_DRIVER = "org.postgresql.Driver";

	protected BDConexionPostgres() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		LocalProperties localProperties = LocalProperties.getInstance();
		this.dbURL = localProperties.getProp("postgress.bd.url");
		this.username = localProperties.getProp("postgress.bd.username");
		this.password = localProperties.getProp("postgress.bd.password");
	}

	private static final BDConexionPostgres instance = new BDConexionPostgres();

	public static BDConexion getInstance() {
		return instance;
	}

	@Override
	public BDEnum getTipo() {
		return BDEnum.POSTGRES;
	}
}
