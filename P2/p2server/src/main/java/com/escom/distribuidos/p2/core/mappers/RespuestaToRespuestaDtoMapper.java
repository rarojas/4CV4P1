package com.escom.distribuidos.p2.core.mappers;

import com.escom.distribuidos.p2.core.dto.RespuestaDto;
import com.escom.distribuidos.p2.core.model.Respuesta;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class RespuestaToRespuestaDtoMapper extends CustomMapper<Respuesta, RespuestaDto> {

	@Override
	public void mapAtoB(Respuesta source, RespuestaDto destination, MappingContext context) {
		destination.setId(source.getId());
		destination.setRespuesta(destination.getRespuesta());
	}

	@Override
	public void mapBtoA(RespuestaDto source, Respuesta destination, MappingContext context) {
		destination.setId(source.getId());
		destination.setRespuesta(destination.getRespuesta());

	}

}
