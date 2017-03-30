package com.escom.distribuidos.rmi.dao.db;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.rmi.dao.entity.Escuela;

@Repository
public class EscuelaDAOImpl extends BaseDaoImpl<Escuela> implements EscuelaDAO {

	public EscuelaDAOImpl() {
		this.clazz = Escuela.class;
	}
}
