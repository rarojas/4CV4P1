package com.escom.distribuidos.p2.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.p2.core.dao.AlumnoDao;
import com.escom.distribuidos.p2.core.dto.AlumnoDto;
import com.escom.distribuidos.p2.core.email.EmailServices;
import com.escom.distribuidos.p2.core.model.Alumno;

@Service
public class AlumnoServicesImpl extends ServiceBaseImpl<Alumno, AlumnoDto> implements AlumnoServices {

	/**
	 *
	 */
	private static final long serialVersionUID = 5115498093424039587L;

	@Autowired
	private EmailServices emailServices;

	@Value("${mail.username}")
	private String fromMail;

	public AlumnoServicesImpl() {
		super(AlumnoDto.class, Alumno.class);
	}

	@Autowired
	private void setDao(AlumnoDao alumnoDao) {
		this.dao = alumnoDao;
	}

	private AlumnoDao getDao() {
		return (AlumnoDao) this.dao;
	}

	@Override
	public void save(AlumnoDto dto) {
		super.save(dto);
		emailServices.sendEmail(dto.getEmail(), fromMail, "Registro Existoso",
				"Bienvenido al sistema de examenes en linea");

	}

}
