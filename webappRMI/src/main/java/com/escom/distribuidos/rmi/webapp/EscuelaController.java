package com.escom.distribuidos.rmi.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escom.distribuidos.rmi.dao.entity.Escuela;
import com.escom.distribuidos.rmi.services.EscuelaServices;

@Controller
@RequestMapping("/escuela")
public class EscuelaController {

	@Autowired
	private EscuelaServices escuelaServices;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void insertEscuela(Escuela escuela) {
		escuelaServices.insert(escuela);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Escuela> getEscuelas() {
		return escuelaServices.get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Escuela getEscuela(@PathVariable Integer id) {
		return escuelaServices.get(id);
	}
}