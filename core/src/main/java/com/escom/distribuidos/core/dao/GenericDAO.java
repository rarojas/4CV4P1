package com.escom.distribuidos.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.reflection.ResultSetMapper;

public abstract class GenericDAO<T> {

	protected final String tableName;
	protected Connection con;
	private Statement statement;
	private ResultSetMapper<T> mapper;

	protected GenericDAO(Connection con, String tableName) {
		this.tableName = tableName;
		this.con = con;
	}

	protected List<T> executeQuery(String query) throws SQLException {
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		statement = con.createStatement();
		rs = statement.executeQuery(query);
		result = mapper.mapRersultSetToObject(rs, this.getClass().getGenericSuperclass().getClass());
		rs.close();
		statement.close();
		return result;
	}

}