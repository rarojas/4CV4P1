package com.escom.distribuidos.rmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.rmi.dao.db.CarreraDao;
import com.escom.distribuidos.rmi.dao.entity.Carrera;

@Service
public class CarreraServicesImpl extends ServiceBaseImpl<Carrera> implements CarreraServices {

	@Autowired
	private void setDao(CarreraDao carreraDao) {
		this.dao = carreraDao;
	}

	private CarreraDao getDao() {
		return (CarreraDao) this.dao;
	}
}
