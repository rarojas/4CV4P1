package com.escom.distribuidos.servidor.controller;

import java.sql.SQLException;
import java.util.List;

import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;
import com.escom.distribuidos.model.CursoEntity;
import com.escom.distribuidos.servidor.dao.CursoDao;

@Controller("curso")
public class CursosController extends BaseController {
	private CursoDao cursoDao;

	public CursosController() throws SQLException {
		super();
		cursoDao = new CursoDao(connection);
	}

	@RequestMapping(value = "obtener", method = "POST")
	public List<CursoEntity> obtener() {
		return cursoDao.all();
	}

	@RequestMapping(value = "obtenerByAlumno", method = "POST")
	public List<CursoEntity> obtenerByAlumno(int idAlumno) {
		return cursoDao.getByAlumno(idAlumno);
	}

	@RequestMapping(value = "create", method = "POST")
	public int create(CursoEntity entity) {
		return cursoDao.create(entity);
	}

	@RequestMapping(value = "update", method = "POST")
	public int update(CursoEntity entity) {
		return cursoDao.update(entity);
	}
}
