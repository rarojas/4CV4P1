package com.escom.distribuidos.rmi.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escom.distribuidos.rmi.dao.entity.Materia;
import com.escom.distribuidos.rmi.services.MateriaServices;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private MateriaServices materiasServices;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void insertEscuela(Materia materia) {
		materiasServices.insert(materia);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Materia> getMaterias() {
		return materiasServices.get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Materia getEscuela(@PathVariable Integer id) {
		return materiasServices.get(id);
	}
}