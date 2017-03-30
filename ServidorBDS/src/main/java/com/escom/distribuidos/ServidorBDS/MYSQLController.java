package com.escom.distribuidos.ServidorBDS;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.core.dao.MySQLDao;

@Controller("mysql")
public class MYSQLController {

	private MySQLDao mySQLDao;

	public MYSQLController() throws SQLException {
		mySQLDao = new MySQLDao();
	}

	@RequestMapping(value = "databases", method = "POST")
	public List<String> getDatabases() {
		return mySQLDao.showDatabases();
	}

	@RequestMapping(value = "tables", method = "POST")
	public List<String> showTables(String db) {
		return mySQLDao.showTables(db);
	}

	@RequestMapping(value = "meta", method = "POST")
	public Map<String, String> showMeta(String db) {
		return mySQLDao.showTableMeta(db);
	}

	@RequestMapping(value = "query", method = "POST")
	public Object query(String query) {
		return mySQLDao.showExecuteQuery(query);
	}
}
