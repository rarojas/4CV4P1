package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;

import com.escom.distribuidos.core.dao.GenericDAO;
import com.escom.distribuidos.model.CursoEntity;

public class CursoDao extends GenericDAO<CursoEntity> {

	private final static String TABLENAME = "curso";

	public CursoDao(Connection con) {
		super(con, TABLENAME, CursoEntity.class);
	}

}
