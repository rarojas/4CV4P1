package com.escom.distribuidos.servidor.controller;

import java.sql.SQLException;
import java.util.List;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.model.Asignacion;
import com.escom.distribuidos.servidor.dao.AsignacionDao;

@Controller("asignacion")
public class AsignacionController extends BaseController {

	private AsignacionDao asignacionDao;

	public AsignacionController() throws SQLException {
		super();
		asignacionDao = new AsignacionDao(connection);
	}

	@RequestMapping(value = "obtener", method = "POST")
	public List<Asignacion> obtener() {
		return asignacionDao.all();
	}

	@RequestMapping(value = "crear", method = "POST")
	public void crearAlumno(Asignacion asignacion) {
		asignacionDao.create(asignacion);
	}


}
