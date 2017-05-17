package com.escom.distribuidos.p2.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.core.dto.AlumnoDto;
import com.escom.distribuidos.p2.core.model.Alumno;
import com.escom.distribuidos.p2.core.services.AlumnoServices;

@RestController
@RequestMapping("alumno")
public class AlumnoController extends BaseController<Alumno, AlumnoDto> {

	private AlumnoServices alumnoServices;

	@Autowired
	public void setAlumnoServices(AlumnoServices alumnoServices) {
		this.serviceBase = alumnoServices;
		this.alumnoServices = alumnoServices;
	}

}
