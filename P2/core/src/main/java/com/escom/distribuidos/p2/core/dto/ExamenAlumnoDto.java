package com.escom.distribuidos.p2.core.dto;

import java.util.ArrayList;
import java.util.List;

public class ExamenAlumnoDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 6633155941596126625L;

	private AlumnoDto alumno;
	private ExamenDto examen;
	private Integer aciertos;
	private List<RespuestaExamenAlumnoDto> respuestas = new ArrayList<RespuestaExamenAlumnoDto>();

	public AlumnoDto getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoDto alumno) {
		this.alumno = alumno;
	}

	public ExamenDto getExamen() {
		return examen;
	}

	public void setExamen(ExamenDto examen) {
		this.examen = examen;
	}

	public Integer getAciertos() {
		return aciertos;
	}

	public void setAciertos(Integer aciertos) {
		this.aciertos = aciertos;
	}

	public List<RespuestaExamenAlumnoDto> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaExamenAlumnoDto> respuestas) {
		this.respuestas = respuestas;
	}

}
