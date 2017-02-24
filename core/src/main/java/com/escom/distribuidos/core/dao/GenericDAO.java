package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.exceptions.GenericRuntimeException;
import com.escom.distribuidos.core.reflection.ObjectSQLMapper;
import com.escom.distribuidos.core.reflection.ResultSetMapper;

public abstract class GenericDAO<T> {

	protected final String tableName;
	protected Connection con;
	private Statement statement;
	protected ResultSetMapper<T> mapper;
	protected ObjectSQLMapper<T> mapperSql;

	protected GenericDAO(Connection con, String tableName) {
		this.tableName = tableName;
		this.con = con;
		mapper = new ResultSetMapper<T>();
		mapperSql = new ObjectSQLMapper<T>();
	}

	protected List<T> executeQuery(String query) {
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			result = mapper.mapRersultSetToObject(rs, this.getClass().getGenericSuperclass().getClass());
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException("Error");
		}
		return result;
	}

	protected int executeUpdate(String query) {
		int rowsAffected = 0;
		try {
			statement = con.createStatement();
			rowsAffected = statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException("Error");
		}
		return rowsAffected;
	}

}