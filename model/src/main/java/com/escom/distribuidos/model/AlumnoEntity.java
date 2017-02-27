package com.escom.distribuidos.model;

import java.io.Serializable;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;

@Entity
public class AlumnoEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8435076050718785207L;

	@Column(name = "idAlumno")
	public int idAlumno;

	@Column(name = "nombre")
	private String nombre;
}
