package com.escom.distribuidos.p2.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta_examen_alumno")
public class RespuestaExamenAlumno extends Entidad<Integer> {

	private static final long serialVersionUID = -7856850812585279712L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPregunta")
	private Pregunta pregunta;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idRespuesta")
	private Respuesta respuesta;

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	private Boolean isCorrect;

}
