package com.escom.distribuidos.p2.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.core.dto.MateriaDto;
import com.escom.distribuidos.p2.core.model.Materia;
import com.escom.distribuidos.p2.core.services.MateriaServices;

@RestController
@RequestMapping("materia")
public class MateriaController extends BaseController<Materia, MateriaDto> {

	private MateriaServices materiaServices;

	@Autowired
	public void setAlumnoServices(MateriaServices materiaServices) {
		this.serviceBase = materiaServices;
		this.materiaServices = materiaServices;
	}

}
