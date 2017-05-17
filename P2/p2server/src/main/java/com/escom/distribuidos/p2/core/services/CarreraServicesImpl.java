package com.escom.distribuidos.p2.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.p2.core.dao.CarreraDao;
import com.escom.distribuidos.p2.core.dto.CarreraDto;
import com.escom.distribuidos.p2.core.model.Carrera;

@Service
public class CarreraServicesImpl extends ServiceBaseImpl<Carrera, CarreraDto> implements CarreraServices {

	public CarreraServicesImpl() {
		super(CarreraDto.class, Carrera.class);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5115498093424039587L;

	@Autowired
	private void setDao(CarreraDao carreraDao) {
		this.dao = carreraDao;
	}

	private CarreraDao getDao() {
		return (CarreraDao) this.dao;
	}

}
