package com.escom.distribuidos.rmi.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escom.distribuidos.rmi.dao.entity.Carrera;
import com.escom.distribuidos.rmi.services.CarreraServices;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraServices carreraServices;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void insertEscuela(Carrera carrera) {
		carreraServices.insert(carrera);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Carrera> getCarreras() {
		return carreraServices.get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Carrera getEscuela(@PathVariable Integer id) {
		return carreraServices.get(id);
	}
}