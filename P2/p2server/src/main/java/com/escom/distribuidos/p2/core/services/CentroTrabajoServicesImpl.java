package com.escom.distribuidos.p2.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.p2.core.dao.CentroTrabajoDao;
import com.escom.distribuidos.p2.core.dto.CentroTrabajoDto;
import com.escom.distribuidos.p2.core.model.CentroTrabajo;

@Service
public class CentroTrabajoServicesImpl extends ServiceBaseImpl<CentroTrabajo, CentroTrabajoDto>
		implements CentroTrabajoServices {

	public CentroTrabajoServicesImpl() {
		super(CentroTrabajoDto.class, CentroTrabajo.class);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 8950613518449133983L;

	@Autowired
	private void setDao(CentroTrabajoDao centroTrabajoDao) {
		this.dao = centroTrabajoDao;
	}

	private CentroTrabajoDao getDao() {
		return (CentroTrabajoDao) this.dao;
	}

}
