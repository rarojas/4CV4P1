package com.escom.distribuidos.p2.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "materia")
public class Materia extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 783727819078051582L;

	private String nombre;
	private int creditos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCarrera", nullable = false)
	private Carrera carrera;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@JsonIgnore
	public Carrera getCarrera() {
		return carrera;
	}

	@JsonProperty
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

}
