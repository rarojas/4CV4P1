package com.escom.distribuidos.rmi.dao.db;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.rmi.dao.entity.Carrera;

@Repository
public class CarreraDaoImpl extends BaseDaoImpl<Carrera> implements CarreraDao {

	public CarreraDaoImpl() {
		this.clazz = Carrera.class;
	}
}
