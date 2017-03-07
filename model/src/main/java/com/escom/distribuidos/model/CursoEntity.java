package com.escom.distribuidos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
	
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIncio() {
		return fechaIncio;
	}

	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public BigDecimal getCoutaDeRecuperacion() {
		return coutaDeRecuperacion;
	}

	public void setCoutaDeRecuperacion(BigDecimal coutaDeRecuperacion) {
		this.coutaDeRecuperacion = coutaDeRecuperacion;
	}

}
