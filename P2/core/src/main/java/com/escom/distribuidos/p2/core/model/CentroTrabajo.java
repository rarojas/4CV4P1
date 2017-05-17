package com.escom.distribuidos.p2.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "centrotrabajo")
public class CentroTrabajo extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -736817042091310318L;

	private String nombre;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Carrera> carreras = new HashSet<Carrera>(0);

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
