package com.escom.distribuidos.servidor.controller;

import java.sql.SQLException;
import java.util.List;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.servidor.dao.AlumnoDao;

@Controller("alumno")
public class AlumnoController extends BaseController {

	private AlumnoDao alumnoDao;

	public AlumnoController() throws SQLException {
		super();
		alumnoDao = new AlumnoDao(connection);
	}

	@RequestMapping(value = "obtener", method = "POST")
	public List<AlumnoEntity> obtenerAlumnos() {
		return alumnoDao.all();
	}

	@RequestMapping(value = "create", method = "POST")
	public void crearAlumno(AlumnoEntity alumno) {
		alumnoDao.createAlumno(alumno);
	}

	@RequestMapping(value = "update", method = "POST")
	public int updateAlumno(AlumnoEntity alumno) {
		return alumnoDao.updateAlumno(alumno);
	}
	
	@RequestMapping(value = "delete", method = "POST")
	public int delete(Integer id) {
		return alumnoDao.delete(id);
	}

}
