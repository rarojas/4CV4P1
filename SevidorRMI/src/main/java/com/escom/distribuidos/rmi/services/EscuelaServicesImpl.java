package com.escom.distribuidos.rmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.rmi.dao.db.EscuelaDAO;
import com.escom.distribuidos.rmi.dao.entity.Escuela;

@Service
public class EscuelaServicesImpl extends ServiceBaseImpl<Escuela> implements EscuelaServices {

	@Autowired
	private void setDao(EscuelaDAO escuelaDAO) {
		this.dao = escuelaDAO;
	}

	private EscuelaDAO getDao() {
		return (EscuelaDAO) this.dao;
	}

}
