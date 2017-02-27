package com.escom.distribuidos.model;

import java.io.Serializable;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;

@Entity
public class Asignacion implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -5190189167787856744L;

	@Column(name = "idAlumno")
	private int idAlumno;

	@Column(name = "idCurso")
	private int idCurso;

	@Column(name = "horario")
	private String horario;

	@Column(name = "tipoCurso")
	private int tipoCurso;
}
