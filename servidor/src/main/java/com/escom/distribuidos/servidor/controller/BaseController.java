package com.escom.distribuidos.servidor.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.escom.distribuidos.core.dao.BDConexion;

public abstract class BaseController {

	protected Connection connection;

	public BaseController() throws SQLException {
		connection = BDConexion.getInstance().open();
	}

	@Override
	public void finalize() throws Throwable {
		try {
			BDConexion.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.finalize();
		}
	}

}
