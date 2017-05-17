package com.escom.distribuidos.p2.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.p2.core.dao.MateriaDao;
import com.escom.distribuidos.p2.core.dto.MateriaDto;
import com.escom.distribuidos.p2.core.model.Materia;

@Service
public class MateriaServicesImpl extends ServiceBaseImpl<Materia, MateriaDto> implements MateriaServices {

	public MateriaServicesImpl() {
		super(MateriaDto.class, Materia.class);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5115498093424039587L;

	@Autowired
	private void setDao(MateriaDao materiaDao) {
		this.dao = materiaDao;
	}

	private MateriaDao getDao() {
		return (MateriaDao) this.dao;
	}

}
