package com.escom.distribuidos.p2.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta extends Entidad<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -3588851539085219074L;
	private String respuesta;
	private Boolean isTheAnswer;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "idPregunta", nullable = false, referencedColumnName =
	// "id")
	// private Pregunta pregunta;

	// public Pregunta getPregunta() {
	// return pregunta;
	// }
	//
	// public void setPregunta(Pregunta pregunta) {
	// this.pregunta = pregunta;
	// }

	public Boolean getIsTheAnswer() {
		return isTheAnswer;
	}

	public void setIsTheAnswer(Boolean isTheAnswer) {
		this.isTheAnswer = isTheAnswer;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
