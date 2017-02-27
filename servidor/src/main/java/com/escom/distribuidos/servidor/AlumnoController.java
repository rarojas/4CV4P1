package com.escom.distribuidos.servidor;

import com.escom.distribuidos.core.Controller;
import com.escom.distribuidos.core.RequestMapping;

@Controller("alumno")
public class AlumnoController {

	@RequestMapping(value = "obtenerAlumnos", method = "POST")
	public void obtenerAlumnos() {
		System.out.println("works");
	}

	@RequestMapping(value = "crearAlumno", method = "POST")
	public void crearAlumno() {

	}

}
