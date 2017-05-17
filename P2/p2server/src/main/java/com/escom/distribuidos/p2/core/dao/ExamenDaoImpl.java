package com.escom.distribuidos.p2.core.dao;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.p2.core.model.Examen;

@Repository
public class ExamenDaoImpl extends BaseDaoImpl<Examen> implements ExamenDao {

	public ExamenDaoImpl() {
		this.clazz = Examen.class;
	}
}
