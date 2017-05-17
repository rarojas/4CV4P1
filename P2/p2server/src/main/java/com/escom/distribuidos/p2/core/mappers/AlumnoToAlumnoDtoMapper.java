package com.escom.distribuidos.p2.core.mappers;

import org.springframework.stereotype.Component;

import com.escom.distribuidos.p2.core.dto.AlumnoDto;
import com.escom.distribuidos.p2.core.dto.CarreraDto;
import com.escom.distribuidos.p2.core.model.Alumno;
import com.escom.distribuidos.p2.core.model.Carrera;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class AlumnoToAlumnoDtoMapper extends CustomMapper<Alumno, AlumnoDto> {

	@Override
	public void mapAtoB(Alumno source, AlumnoDto destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setPaterno(source.getPaterno());
		destination.setMaterno(source.getMaterno());
		destination.setFechaNacimiento(source.getFechaNacimiento());
		destination.setEmail(source.getEmail());
		destination.setCarreraDto(this.mapperFacade.map(source.getCarrera(), CarreraDto.class));
	}

	@Override
	public void mapBtoA(AlumnoDto source, Alumno destination, MappingContext context) {
		destination.setNombre(source.getNombre());
		destination.setPaterno(source.getPaterno());
		destination.setMaterno(source.getMaterno());
		destination.setFechaNacimiento(source.getFechaNacimiento());
		destination.setEmail(source.getEmail());
		destination.setCarrera(this.mapperFacade.map(source.getCarreraDto(), Carrera.class));
	}

}
