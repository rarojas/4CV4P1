package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.dao.GenericDAO;
import com.escom.distribuidos.core.reflection.ResultSetMapper;

public class AlumnoDao extends GenericDAO<AlumnoEntity> {

	private final static String TABLENAME = "alumnos";
	private Statement statement;
	private ResultSetMapper<AlumnoEntity> mapper;

	public AlumnoDao(Connection con) {
		super(con, TABLENAME);
		mapper = new ResultSetMapper<AlumnoEntity>();
	}

	public List<AlumnoEntity> all() {
		String query = "SELECT * FROM " + tableName;
		ResultSet rs = null;
		List<AlumnoEntity> alumnoEntity = new ArrayList<AlumnoEntity>();
		try {

			statement = con.createStatement();
			rs = statement.executeQuery(query);
			alumnoEntity = mapper.mapRersultSetToObject(rs, AlumnoEntity.class);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return alumnoEntity;
	}

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
