package com.escom.distribuidos.p2.core.mappers;

import com.escom.distribuidos.p2.core.dto.PreguntaDto;
import com.escom.distribuidos.p2.core.dto.RespuestaDto;
import com.escom.distribuidos.p2.core.model.Pregunta;
import com.escom.distribuidos.p2.core.model.Respuesta;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class PreguntaToPreguntaDtoMapper extends CustomMapper<Pregunta, PreguntaDto> {

	@Override
	public void mapAtoB(Pregunta source, PreguntaDto destination, MappingContext context) {
		destination.setId(source.getId());
		destination.setPregunta(source.getPregunta());
		destination.setRespuestas(this.mapperFacade.mapAsList(source.getRespuestas(), RespuestaDto.class));
	}

	@Override
	public void mapBtoA(PreguntaDto source, Pregunta destination, MappingContext context) {
		destination.setId(source.getId());
		destination.setPregunta(source.getPregunta());
		destination.setRespuestas(this.mapperFacade.mapAsSet(source.getRespuestas(), Respuesta.class));
	}
}
