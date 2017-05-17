package com.escom.distribuidos.p2.core.dao;

import org.springframework.stereotype.Repository;

import com.escom.distribuidos.p2.core.model.Materia;

@Repository
public class MateriaDaoImpl extends BaseDaoImpl<Materia> implements MateriaDao {

	public MateriaDaoImpl() {
		this.clazz = Materia.class;
	}
}
