package com.escom.distribuidos.servidor.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.core.dao.BDConexion;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.servidor.dao.AlumnoDao;

@Controller("alumno")
public class AlumnoController {

	private AlumnoDao alumnoDao;

	public AlumnoController() throws SQLException {
		Connection connection = BDConexion.getInstance().open();
		alumnoDao = new AlumnoDao(connection);
	}

	@RequestMapping(value = "obtenerAlumnos", method = "POST")
	public List<AlumnoEntity> obtenerAlumnos() {
		return alumnoDao.all();
	}

	@RequestMapping(value = "crearAlumno", method = "POST")
	public void crearAlumno(AlumnoEntity alumno) {
		alumnoDao.createAlumno(alumno);
	}

	@RequestMapping(value = "updateAlumno", method = "POST")
	public int updateAlumno(AlumnoEntity alumno) {
		return alumnoDao.updateAlumno(alumno);
	}

	@Override
	public void finalize() throws Throwable {
		try {
			BDConexion.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.finalize();
		}
	}

}
