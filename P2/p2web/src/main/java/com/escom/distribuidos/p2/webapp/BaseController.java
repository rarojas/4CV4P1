package com.escom.distribuidos.p2.webapp;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.escom.distribuidos.p2.core.services.ServiceBase;

public abstract class BaseController<T, DTO> {

	protected ServiceBase<T, DTO> serviceBase;

	@RequestMapping(method = RequestMethod.GET)
	public List<DTO> get() {
		return serviceBase.get();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public DTO get(@PathVariable Integer id) {
		return serviceBase.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public DTO save(@RequestBody DTO entity) {
		serviceBase.save(entity);
		return entity;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public DTO update(@RequestBody DTO entity) {
		serviceBase.update(entity);
		return entity;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody DTO entity) {
		serviceBase.delete(entity);
	}

}
