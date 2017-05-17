package com.escom.distribuidos.p2.core.dto;

import java.util.ArrayList;
import java.util.List;

public class PreguntaDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 3376524833672806632L;
	private String pregunta;
	private ExamenDto examen;
	private List<RespuestaDto> respuestas = new ArrayList<RespuestaDto>();

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ExamenDto getExamen() {
		return examen;
	}

	public void setExamen(ExamenDto examen) {
		this.examen = examen;
	}

	public List<RespuestaDto> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaDto> respuestas) {
		this.respuestas = respuestas;
	}
}
