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
}
