package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.dao.GenericDAO;
import com.escom.distribuidos.model.AlumnoEntity;

public class AlumnoDao extends GenericDAO<AlumnoEntity> {

	private final static String TABLENAME = "alumno";

	public AlumnoDao(Connection con) {
		super(con, TABLENAME);
	}

	public List<AlumnoEntity> all() {
		String query = "SELECT * FROM " + tableName;
		List<AlumnoEntity> result = new ArrayList<AlumnoEntity>();
		result = this.executeQuery(query);
		return result;
	}

	public int createAlumno(AlumnoEntity alumno) {
		String query = "insert  into " + tableName;
		query = query.concat(mapperSql.mapObjectToInsertSQL(alumno, AlumnoEntity.class));
		return this.executeUpdate(query);
	}

	public int updateAlumno(AlumnoEntity alumno) {
		String query = "update " + tableName;
		query = query.concat(mapperSql.mapObjectToUpdateSQL(alumno, AlumnoEntity.class));
		return this.executeUpdate(query);
	}
}
