package com.escom.distribuidos.p2.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "carreras")
public class Carrera extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -7381029747355244861L;

	private String nombre;
	private int duracion;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idCentroTrabajo", nullable = false)
	private CentroTrabajo centroTrabajo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public CentroTrabajo getCentroTrabajo() {
		return this.centroTrabajo;
	}

	@JsonProperty
	public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}

}
