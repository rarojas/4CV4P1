package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConexionProxy {

	public Connection open() throws SQLException;

	public void close() throws SQLException;

}
