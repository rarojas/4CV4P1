package com.escom.distribuidos.p2.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 2306047881532583682L;

	private String pregunta;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "idExamen", nullable = false, referencedColumnName =
	// "id")
	// private Examen examen;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPregunta", nullable = false)
	private Set<Respuesta> respuestas = new HashSet<Respuesta>(0);

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	// public Examen getExamen() {
	// return examen;
	// }
	//
	// public void setExamen(Examen examen) {
	// this.examen = examen;
	// }

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
