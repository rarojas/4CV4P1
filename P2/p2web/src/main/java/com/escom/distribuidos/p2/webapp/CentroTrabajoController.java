package com.escom.distribuidos.p2.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.core.dto.CentroTrabajoDto;
import com.escom.distribuidos.p2.core.model.CentroTrabajo;
import com.escom.distribuidos.p2.core.services.CentroTrabajoServices;

@RestController
@RequestMapping("centrotrabajo")
public class CentroTrabajoController extends BaseController<CentroTrabajo, CentroTrabajoDto> {

	private CentroTrabajoServices centroTrabajoServices;

	@Autowired
	public void setCarreraServices(CentroTrabajoServices centroTrabajoServices) {
		this.serviceBase = centroTrabajoServices;
		this.centroTrabajoServices = centroTrabajoServices;
	}

}
