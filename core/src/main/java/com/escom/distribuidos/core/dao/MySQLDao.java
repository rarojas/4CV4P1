package com.escom.distribuidos.core.dao;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.escom.distribuidos.core.exceptions.GenericRuntimeException;

public class MySQLDao extends GenericHelperDB {

	public MySQLDao() throws SQLException {
		super(BDConexion.getInstance());
	}

	@Override
	public List<String> showDatabases() {

		List<String> databases = new ArrayList<>();
		DatabaseMetaData dbmd;
		try {
			dbmd = con.getMetaData();
			ResultSet ctlgs = dbmd.getCatalogs();
			while (ctlgs.next()) {
				databases.add(ctlgs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException(e.getMessage());

		}

		return databases;
	}

	@Override
	public List<String> showTables(String db) {
		List<String> databases = new ArrayList<>();
		DatabaseMetaData dbmd;
		try {
			con.setCatalog(db);
			dbmd = con.getMetaData();
			ResultSet ctlgs = dbmd.getTables(db, null, "%", new String[] { "TABLE" });
			while (ctlgs.next()) {
				databases.add(ctlgs.getString("TABLE_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException(e.getMessage());
		}

		return databases;
	}

	@Override
	public Map<String, String> showTableMeta(String db) {
		Map<String, String> databases = new HashMap<>();
		DatabaseMetaData dbmd;
		try {
			con.setCatalog(db.split(Pattern.quote("."))[0]);
			dbmd = con.getMetaData();
			ResultSet ctlgs = dbmd.getColumns(db.split(Pattern.quote("."))[0], null, db.split(Pattern.quote("."))[1],
					"%");
			while (ctlgs.next()) {
				databases.put(ctlgs.getString(4), ctlgs.getString("TYPE_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException(e.getMessage());
		}

		return databases;
	}

	@Override
	public Object showExecuteQuery(String query) {
		List<String> rows = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			Boolean isResultSet = statement.execute(query);
			if (isResultSet) {
				ResultSet resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = resultSet.getMetaData();
				String result = new String();
				for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
					String columnName = rsmd.getColumnName(_iterator + 1);
					result = result.concat(columnName).concat(",");
				}
				rows.add(result);
				while (resultSet.next()) {
					result = new String();
					for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
						Object columnValue = resultSet.getObject(_iterator + 1);
						result = result.concat(columnValue.toString()).concat(",");
					}
					rows.add(result);
				}
				return rows;

			} else {
				return statement.getUpdateCount();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericRuntimeException(e.getMessage());
		}
	}
}
