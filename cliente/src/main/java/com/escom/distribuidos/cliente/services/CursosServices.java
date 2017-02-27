package com.escom.distribuidos.cliente.services;

import java.util.List;
import java.util.concurrent.Callable;

import com.escom.distribuidos.cliente.SocketInterface;
import com.escom.distribuidos.cliente.async.AsyncRequest;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.core.socket.Peticion;
import com.escom.distribuidos.model.CursoEntity;

public class CursosServices {

	private SocketInterface socket;

	public CursosServices(SocketInterface socket) {
		this.socket = socket;
	}

	public void all(AsyncRequestListener<List<CursoEntity>> listener) {
		final Peticion getAll = new Peticion();
		getAll.setMethod("POST");
		getAll.setRoute("curso/obtener");

		(new AsyncRequest<List<CursoEntity>>(new Callable<List<CursoEntity>>() {
			@Override
			public List<CursoEntity> call() throws Exception {
				return socket.sendRequest(getAll);
			}
		}, listener)).run();

	}

	public void getCursoByAlumno(int idAlumno, AsyncRequestListener<List<CursoEntity>> listener) {
		final Peticion getCursoByAlumno = new Peticion();
		getCursoByAlumno.setMethod("POST");
		getCursoByAlumno.setRoute("curso/obtenerByAlumno");
		getCursoByAlumno.setPayload(idAlumno);

		(new AsyncRequest<List<CursoEntity>>(new Callable<List<CursoEntity>>() {
			@Override
			public List<CursoEntity> call() throws Exception {
				return socket.sendRequest(getCursoByAlumno);
			}
		}, listener)).run();
	}
}