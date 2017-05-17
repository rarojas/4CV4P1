package com.escom.distribuidos.p2.core.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "alumnos")
public class Alumno extends Entidad<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -5706412736889150832L;

	private String nombre;
	private String paterno;
	private String materno;
	private Date fechaNacimiento;
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCarrera", nullable = false)
	private Carrera carrera;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
