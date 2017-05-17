package com.escom.distribuidos.p2.core.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.escom.distribuidos.p2.core.dao.BaseDao;

import ma.glasnost.orika.MapperFacade;

@Transactional
public abstract class ServiceBaseImpl<T, DTO> implements ServiceBase<T, DTO> {

	/**
	 *
	 */
	private static final long serialVersionUID = 7068941316652947196L;

	public ServiceBaseImpl(Class<DTO> dto, Class<T> type) {
		this.dto = dto;
		this.type = type;
	}

	@Autowired
	protected MapperFacade mapperFacade;
	protected BaseDao<T> dao;
	protected Class<DTO> dto;
	protected Class<T> type;

	public void save(DTO dto) {
		T entity = mapperFacade.map(dto, type);
		dao.save(entity);
	}

	public void update(DTO dto) {
		T entity = mapperFacade.map(dto, type);
		dao.update(entity);
	}

	public DTO get(Serializable id) {
		return mapperFacade.map(dao.get(id), dto);
	}

	public List<DTO> get() {
		return mapperFacade.mapAsList(dao.get(), dto);
	}

	public void delete(DTO dto) {
		T entity = mapperFacade.map(dto, type);
		dao.delete(entity);
	}
}
