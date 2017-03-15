package com.escom.distribuidos.cliente.services;

import java.util.List;
import java.util.concurrent.Callable;

import com.escom.distribuidos.cliente.SocketInterface;
import com.escom.distribuidos.cliente.async.AsyncRequest;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.core.socket.Peticion;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.CursoEntity;

public class AlumnosServices {

	private SocketInterface socket;

	public AlumnosServices(SocketInterface socket) {
		this.socket = socket;
	}

	public void all(AsyncRequestListener<List<AlumnoEntity>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("alumno/obtener");

		(new AsyncRequest<List<AlumnoEntity>>(
				new Callable<List<AlumnoEntity>>() {
					@Override
					public List<AlumnoEntity> call() throws Exception {
						return socket.sendRequest(getAll);
					}
				}, listener)).run();

	}
	
	
	public void save(AlumnoEntity alumno, AsyncRequestListener<Integer> listener) {
		final Peticion save = new Peticion();
		save.setMethod("POST");
		if(alumno.getIdAlumno() == 0)
			save.setRoute("alumno/create");
		else
			save.setRoute("alumno/update");
		save.setPayload(alumno);

		(new AsyncRequest<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return socket.sendRequest(save);
			}
		}, listener)).run();

	}
	
	public void delete(int id,AsyncRequestListener<Integer> listener) {
		final Peticion save = new Peticion();
		save.setMethod("POST");
		save.setRoute("alumno/delete");
		save.setPayload(id);

		(new AsyncRequest<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return socket.sendRequest(save);
			}
		}, listener)).run();

	}
	
}
