package com.escom.distribuidos.p2.core.dto;

public class RespuestaExamenAlumnoDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -6135014726752894198L;

	private PreguntaDto pregunta;
	private RespuestaDto respuesta;
	private Boolean isCorrect;

	public PreguntaDto getPregunta() {
		return pregunta;
	}

	public void setPregunta(PreguntaDto pregunta) {
		this.pregunta = pregunta;
	}

	public RespuestaDto getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaDto respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
