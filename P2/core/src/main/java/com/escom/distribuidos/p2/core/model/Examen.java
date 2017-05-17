package com.escom.distribuidos.p2.core.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "examen")
public class Examen extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -8341230845514494166L;
	private Date fecha;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idMateria", nullable = false)
	private Materia materia;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idExamen", nullable = false)
	private Set<Pregunta> preguntas = new HashSet<Pregunta>(0);

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@JsonIgnore
	public Materia getMateria() {
		return materia;
	}

	@JsonProperty
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

}
