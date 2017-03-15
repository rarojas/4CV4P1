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
	private Class<T> clazz;

	protected GenericDAO(Connection con, String tableName, Class<T> clazz) {
		this.tableName = tableName;
		this.con = con;
		mapper = new ResultSetMapper<T>();
		mapperSql = new ObjectSQLMapper<T>();
		this.clazz = clazz;
	}

	public List<T> all() {
		String query = "SELECT * FROM " + tableName;
		List<T> result = new ArrayList<T>();
		result = this.executeQuery(query);
		return result;
	}

	public int create(T entity) {
		String query = "insert  into " + tableName;
		query = query.concat(mapperSql.mapObjectToInsertSQL(entity, clazz));
		return this.executeUpdate(query);
	}

	public int update(T entity) {
		String query = "update " + tableName;
		query = query.concat(mapperSql.mapObjectToUpdateSQL(entity, clazz));
		return this.executeUpdate(query);
	}

	public List<T> executeQuery(String query) {
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			result = mapper.mapRersultSetToObject(rs, clazz);
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException(e.getMessage());
		}
		return result;
	}

	public <E> List<E> executeQueryLeft(String query, Class<E> _clazz) {
		ResultSet rs = null;
		List<E> result = new ArrayList<E>();
		try {
			ResultSetMapper<E> _mapper = new ResultSetMapper<>();
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			result = _mapper.mapRersultSetToObject(rs, _clazz);
			rs.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException("Error");
		}
		return result;
	}

	public int executeUpdate(String query) {
		int rowsAffected = 0;
		try {
			statement = con.createStatement();
			rowsAffected = statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			throw new GenericRuntimeException(e.getMessage());
		}
		return rowsAffected;
	}

}