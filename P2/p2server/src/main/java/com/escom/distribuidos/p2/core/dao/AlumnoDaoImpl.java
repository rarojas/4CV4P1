package com.escom.distribuidos.p2.core.dao;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.p2.core.model.Alumno;

@Repository
public class AlumnoDaoImpl extends BaseDaoImpl<Alumno> implements AlumnoDao {

	public AlumnoDaoImpl() {
		this.clazz = Alumno.class;
	}
}
