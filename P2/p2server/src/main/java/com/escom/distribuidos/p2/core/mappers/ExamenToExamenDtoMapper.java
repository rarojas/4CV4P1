package com.escom.distribuidos.p2.core.mappers;

import com.escom.distribuidos.p2.core.dto.ExamenDto;
import com.escom.distribuidos.p2.core.dto.MateriaDto;
import com.escom.distribuidos.p2.core.dto.PreguntaDto;
import com.escom.distribuidos.p2.core.model.Examen;
import com.escom.distribuidos.p2.core.model.Materia;
import com.escom.distribuidos.p2.core.model.Pregunta;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ExamenToExamenDtoMapper extends CustomMapper<Examen, ExamenDto> {

	@Override
	public void mapAtoB(Examen source, ExamenDto destination, MappingContext context) {
		destination.setFecha(source.getFecha());
		destination.setId(source.getId());
		destination.setMateria(this.mapperFacade.map(source.getMateria(), MateriaDto.class));
		destination.setPreguntas(this.mapperFacade.mapAsList(source.getPreguntas(), PreguntaDto.class));
	}

	@Override
	public void mapBtoA(ExamenDto source, Examen destination, MappingContext context) {
		destination.setFecha(source.getFecha());
		destination.setId(source.getId());
		destination.setMateria(this.mapperFacade.map(source.getMateria(), Materia.class));
		destination.setPreguntas(this.mapperFacade.mapAsSet(source.getPreguntas(), Pregunta.class));
	}
}
