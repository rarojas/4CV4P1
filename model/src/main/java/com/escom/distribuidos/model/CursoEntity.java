package com.escom.distribuidos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;
import com.escom.distribuidos.core.annotations.Id;

@Entity
public class CursoEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5797371797666987528L;

	@Id
	@Column(name = "idCurso")
	private int idCurso;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fechaInicio")
	private Date fechaIncio;

	@Column(name = "fechaTermino")
	private Date fechaTermino;

	@Column(name = "coutaDeRecuperacion")
	private BigDecimal coutaDeRecuperacion;
}
