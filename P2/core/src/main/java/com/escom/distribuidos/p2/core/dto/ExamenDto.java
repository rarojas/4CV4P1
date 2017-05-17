package com.escom.distribuidos.p2.core.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.escom.distribuidos.p2.webapp.utiils.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ExamenDto extends EntidadDto<Integer> {

	private static final long serialVersionUID = -4346093749876940771L;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date fecha;
	private MateriaDto materia;
	private List<PreguntaDto> preguntas = new ArrayList<PreguntaDto>();

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MateriaDto getMateria() {
		return materia;
	}

	public void setMateria(MateriaDto materia) {
		this.materia = materia;
	}

	public List<PreguntaDto> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaDto> preguntas) {
		this.preguntas = preguntas;
	}
}
