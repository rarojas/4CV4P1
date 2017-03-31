package com.escom.distribuidos.core.dao;

import java.util.List;
import java.util.Map;

public interface GenericHelperDBSoport {

	public List<String> showDatabases();

	public List<String> showTables(String db);

	public Map<String, String> showTableMeta(String db);

	public Object showExecuteQuery(String query);

}
