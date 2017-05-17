package com.escom.distribuidos.p2.core.dao;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.p2.core.model.Carrera;

@Repository
public class CarreraDaoImpl extends BaseDaoImpl<Carrera> implements CarreraDao {

	public CarreraDaoImpl() {
		this.clazz = Carrera.class;
	}
}
