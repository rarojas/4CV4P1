package com.escom.distribuidos.servidor.dao;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;

@Entity
public class AlumnoEntity {

	@Column(name = "idAlumno")
	public int idAlumno;
}
