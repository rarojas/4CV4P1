package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class GenericHelperDB {

	private BDEnum contype;
	protected Connection con;

	protected GenericHelperDB(BDConexion connection) throws SQLException {
		this.con = connection.open();
		this.contype = connection.getTipo();
	}

}
