package com.escom.distribuidos.p2.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.core.dto.CarreraDto;
import com.escom.distribuidos.p2.core.model.Carrera;
import com.escom.distribuidos.p2.core.services.CarreraServices;

@RestController
@RequestMapping("carrera")
public class CarreraController extends BaseController<Carrera, CarreraDto> {

	private CarreraServices carreraServices;

	@Autowired
	public void setCarreraServices(CarreraServices carreraServices) {
		this.serviceBase = carreraServices;
		this.carreraServices = carreraServices;
	}

}
