package com.escom.distribuidos.p2.core.mappers;

import org.springframework.stereotype.Component;

import com.escom.distribuidos.p2.core.dto.CarreraDto;
import com.escom.distribuidos.p2.core.dto.CentroTrabajoDto;
import com.escom.distribuidos.p2.core.model.Carrera;
import com.escom.distribuidos.p2.core.model.CentroTrabajo;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class CarreraDtoToCarreraMapper extends CustomMapper<CarreraDto, Carrera> {

	@Override
	public void mapBtoA(Carrera source, CarreraDto destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setDuracion(source.getDuracion());
		destination.setId(source.getId());
		destination.setCentroTrabajoDto(this.mapperFacade.map(source.getCentroTrabajo(), CentroTrabajoDto.class));
	}

	@Override
	public void mapAtoB(CarreraDto source, Carrera destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setDuracion(source.getDuracion());
		destination.setId(source.getId());
		destination.setCentroTrabajo(this.mapperFacade.map(source.getCentroTrabajoDto(), CentroTrabajo.class));
	}

}
