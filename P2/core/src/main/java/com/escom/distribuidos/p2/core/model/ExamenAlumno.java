package com.escom.distribuidos.p2.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examen_alumno")
public class ExamenAlumno extends Entidad<Integer> {

	private static final long serialVersionUID = 145329583573770166L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idExamen")
	private Examen examen;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idExamenAlumno", nullable = false)
	private List<RespuestaExamenAlumno> respuestas = new ArrayList<RespuestaExamenAlumno>();

	private Integer aciertos;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Integer getAciertos() {
		return aciertos;
	}

	public void setAciertos(Integer aciertos) {
		this.aciertos = aciertos;
	}

	public List<RespuestaExamenAlumno> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaExamenAlumno> respuestas) {
		this.respuestas = respuestas;
	}

}
