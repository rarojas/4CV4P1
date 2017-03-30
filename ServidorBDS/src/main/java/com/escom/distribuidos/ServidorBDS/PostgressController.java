package com.escom.distribuidos.ServidorBDS;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.core.dao.PostgressDao;

@Controller("postgress")
public class PostgressController {

	private PostgressDao postgressDao;

	public PostgressController() throws SQLException {
		postgressDao = new PostgressDao();
	}

	@RequestMapping(value = "databases", method = "POST")
	public List<String> getDatabases() {
		return postgressDao.showDatabases();
	}

	@RequestMapping(value = "tables", method = "POST")
	public List<String> showTables(String db) {
		return postgressDao.showTables(db);
	}

	@RequestMapping(value = "meta", method = "POST")
	public Map<String, String> showMeta(String db) {
		return postgressDao.showTableMeta(db);
	}

	@RequestMapping(value = "query", method = "POST")
	public Object query(String query) {
		return postgressDao.showExecuteQuery(query);
	}

}
