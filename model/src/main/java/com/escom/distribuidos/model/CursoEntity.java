package com.escom.distribuidos.model;

import java.sql.Date;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;
import com.escom.distribuidos.core.annotations.Id;

@Entity
public class CursoEntity {

	@Id
	@Column(name = "idCurso")
	private int idCurso;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fechaIncio")
	private Date fechaIncio;

	@Column(name = "fechaTermino")
	private Date fechaTermino;

	@Column(name = "coutaDeRecuperacion")
	private Double coutaDeRecuperacion;
}
