package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.dao.GenericDAO;

public class AlumnoDao extends GenericDAO<AlumnoEntity> {

	private final static String TABLENAME = "alumnos";

	public AlumnoDao(Connection con) {
		super(con, TABLENAME);
	}

	public List<AlumnoEntity> all() {
		String query = "SELECT * FROM " + tableName;
		List<AlumnoEntity> result = new ArrayList<AlumnoEntity>();
		try {
			result = this.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

}
