package com.escom.distribuidos.rmi.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escom.distribuidos.rmi.dao.entity.Alumno;
import com.escom.distribuidos.rmi.dao.entity.Usuario;
import com.escom.distribuidos.rmi.services.AuthServices;
import com.escom.distribuidos.rmi.webapp.dtos.AlumnoRegistroDto;
import com.escom.distribuidos.rmi.webapp.dtos.LoginDto;

@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	AuthServices authServices;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Boolean login(@RequestBody LoginDto loginDto) {
		Usuario usuario = new Usuario();
		usuario.setUsuario(loginDto.getUsername());
		usuario.setPassword(loginDto.getPassword());
		return authServices.login(usuario);
	}

	@RequestMapping(value = "registroAlumno", method = RequestMethod.POST)
	@ResponseBody
	public Alumno registroAlumno(@RequestBody AlumnoRegistroDto alumnoRegistroDto) {
		Alumno alumno = new Alumno();
		alumno.setUsuario(alumnoRegistroDto.getUsername());
		alumno.setPassword(alumnoRegistroDto.getPassword());
		return authServices.registro(alumno);
	}
}
