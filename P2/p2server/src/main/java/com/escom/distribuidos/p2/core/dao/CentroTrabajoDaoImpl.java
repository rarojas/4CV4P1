package com.escom.distribuidos.p2.core.dao;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.p2.core.model.CentroTrabajo;

@Repository
public class CentroTrabajoDaoImpl extends BaseDaoImpl<CentroTrabajo> implements CentroTrabajoDao {

	public CentroTrabajoDaoImpl() {
		this.clazz = CentroTrabajo.class;
	}
}
