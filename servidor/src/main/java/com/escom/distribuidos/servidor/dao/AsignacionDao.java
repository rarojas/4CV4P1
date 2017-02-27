package com.escom.distribuidos.servidor.dao;

import java.sql.Connection;

import com.escom.distribuidos.core.dao.GenericDAO;
import com.escom.distribuidos.model.Asignacion;

public class AsignacionDao extends GenericDAO<Asignacion> {

	public final static String TABLENAME = "asignacion";

	public AsignacionDao(Connection con) {
		super(con, TABLENAME, Asignacion.class);
	}



}
