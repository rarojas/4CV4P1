package com.escom.distribuidos;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.escom.distribuidos.cliente.SocketInterface;
import com.escom.distribuidos.cliente.async.AsyncRequest;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.core.socket.Peticion;

public class MySqlServices implements DBService {

	private SocketInterface socket;

	public MySqlServices(SocketInterface socket) {
		this.socket = socket;
	}

	@Override
	public void showDatabase(AsyncRequestListener<List<String>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("mysql/databases");

		(new AsyncRequest<List<String>>(new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();
	}

	@Override
	public void showTable(String db, AsyncRequestListener<List<String>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("mysql/tables");
		getAll.setPayload(db);

		(new AsyncRequest<List<String>>(new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();
	}

	@Override
	public void showTableMeta(String table, AsyncRequestListener<Map<String, String>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("mysql/meta");
		getAll.setPayload(table);

		(new AsyncRequest<Map<String, String>>(new Callable<Map<String, String>>() {
			@Override
			public Map<String, String> call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();
	}

	@Override
	public void query(String query, AsyncRequestListener<Object> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("mysql/query");
		getAll.setPayload(query);

		(new AsyncRequest<Object>(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();
	}

}