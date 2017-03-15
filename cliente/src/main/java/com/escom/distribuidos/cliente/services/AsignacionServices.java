package com.escom.distribuidos.cliente.services;

import java.util.List;
import java.util.concurrent.Callable;

import com.escom.distribuidos.cliente.SocketInterface;
import com.escom.distribuidos.cliente.async.AsyncRequest;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.core.socket.Peticion;
import com.escom.distribuidos.model.Asignacion;

public class AsignacionServices {

	private SocketInterface socket;

	public AsignacionServices(SocketInterface socket) {
		this.socket = socket;
	}

	public void all(AsyncRequestListener<List<Asignacion>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("asignacion/obtener");

		(new AsyncRequest<List<Asignacion>>(new Callable<List<Asignacion>>() {
			@Override
			public List<Asignacion> call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();
	}

	public void save(Asignacion asignacion, AsyncRequestListener<Integer> listener) {
		final Peticion save = new Peticion();
		save.setMethod("POST");
		save.setRoute("asignacion/create");
		save.setPayload(asignacion);

		(new AsyncRequest<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return socket.sendRequest(save);
			}
		}, listener)).run();

	}

	public void delete(Asignacion asignacion, AsyncRequestListener<Integer> listener) {
		final Peticion save = new Peticion();
		save.setMethod("POST");
		save.setRoute("asignacion/delete");
		save.setPayload(asignacion);

		(new AsyncRequest<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return socket.sendRequest(save);
			}
		}, listener)).run();

	}
}
