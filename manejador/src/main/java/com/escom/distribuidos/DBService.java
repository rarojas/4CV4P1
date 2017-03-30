package com.escom.distribuidos;

import java.util.List;
import java.util.Map;

import com.escom.distribuidos.cliente.async.AsyncRequestListener;

public interface DBService {

	public void showDatabase(AsyncRequestListener<List<String>> listener);

	public void showTable(String db, AsyncRequestListener<List<String>> listener);

	public void showTableMeta(String table, AsyncRequestListener<Map<String, String>> listener);

	void query(String query, AsyncRequestListener<Object> listener);

}