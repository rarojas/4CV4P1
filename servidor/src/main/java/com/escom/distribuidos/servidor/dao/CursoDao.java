package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;
import java.util.List;

import com.escom.distribuidos.core.dao.GenericDAO;
import com.escom.distribuidos.model.CursoEntity;

public class CursoDao extends GenericDAO<CursoEntity> {

	public final static String TABLENAME = "cursos";

	public CursoDao(Connection con) {
		super(con, TABLENAME, CursoEntity.class);
	}

	public List<CursoEntity> getByAlumno(int idAlumno) {
		String query = "select  * from " + TABLENAME + " c ";
		query += "left join asignacion a on a.idCurso = c.idCurso where a.idAlumno = "
				+ ((Integer) idAlumno).toString();
		return this.executeQuery(query);
	}
	
	public int delete(Integer id){
		String query = "delete from " + TABLENAME + " where idCurso = " + id.toString();
		return this.executeUpdate(query);
	}


}
