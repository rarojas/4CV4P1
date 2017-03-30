package com.escom.distribuidos.rmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.rmi.dao.db.MateriaDao;
import com.escom.distribuidos.rmi.dao.entity.Materia;

@Service
public class MateriaServicesImpl extends ServiceBaseImpl<Materia> implements MateriaServices {

	@Autowired
	private void setDao(MateriaDao materiaDao) {
		this.dao = materiaDao;
	}

	private MateriaDao getDao() {
		return (MateriaDao) this.dao;
	}

}
