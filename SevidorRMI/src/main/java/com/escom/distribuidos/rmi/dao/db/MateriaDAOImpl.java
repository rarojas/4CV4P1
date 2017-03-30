package com.escom.distribuidos.rmi.dao.db;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.rmi.dao.entity.Materia;

@Repository
public class MateriaDAOImpl extends BaseDaoImpl<Materia> implements MateriaDao {

	public MateriaDAOImpl() {
		this.clazz = Materia.class;
	}
}
