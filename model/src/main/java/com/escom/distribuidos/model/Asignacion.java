package com.escom.distribuidos.model;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;

@Entity
public class Asignacion {


	@Column(name = "idAlumno")
	private int idAlumno;

	@Column(name = "idCurso")
	private int idCurso;

	@Column(name = "horario")
	private String horario;

	@Column(name = "tipoCurso")
	private int tipoCurso;
}
