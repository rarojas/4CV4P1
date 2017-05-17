package com.escom.distribuidos.p2.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Practica2ServicesImpl implements Practica2Services {

	@Autowired
	private CarreraServices carreraServices;

	@Autowired
	private CentroTrabajoServices centroTrabajoServices;

	public CarreraServices getCarrera() {
		return carreraServices;
	}

	public CentroTrabajoServices getCentroTrabajo() {
		return centroTrabajoServices;
	}

}
