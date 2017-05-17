package com.escom.distribuidos.p2.core.mappers;

import com.escom.distribuidos.p2.core.dto.CarreraDto;
import com.escom.distribuidos.p2.core.dto.MateriaDto;
import com.escom.distribuidos.p2.core.model.Carrera;
import com.escom.distribuidos.p2.core.model.Materia;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class MateriaToMateriaDtoMapper extends CustomMapper<Materia, MateriaDto> {

	@Override
	public void mapAtoB(Materia source, MateriaDto destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setCreditos(source.getCreditos());
		destination.setId(source.getId());
		destination.setCarrera(this.mapperFacade.map(source.getCarrera(), CarreraDto.class));
	}

	@Override
	public void mapBtoA(MateriaDto source, Materia destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setCreditos(source.getCreditos());
		destination.setId(source.getId());
		destination.setCarrera(this.mapperFacade.map(source.getCarrera(), Carrera.class));
	}

}
