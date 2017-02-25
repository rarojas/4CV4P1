package com.escom.distribuidos.cliente;

import java.util.List;
import java.util.concurrent.Callable;

import com.escom.distribuidos.core.socket.Peticion;
import com.escom.distribuidos.model.AlumnoEntity;

public class AlumnosServices {

	private SocketInterface socket;

	public AlumnosServices(SocketInterface socket) {
		this.socket = socket;
	}

	public void all(AsyncRequestListener<List<AlumnoEntity>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("alumno/obtenerAlumnos");

		(new AsyncRequest<List<AlumnoEntity>>(
				new Callable<List<AlumnoEntity>>() {
					@Override
					public List<AlumnoEntity> call() throws Exception {
						return socket.sendRequest(getAll);
					}
				}, listener)).run();

	}
}
