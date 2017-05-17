package com.escom.distribuidos.p2.core.dto;

import java.util.Date;

public class AlumnoDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -3664550143795475344L;

	private String nombre;
	private String paterno;
	private String materno;
	private Date fechaNacimiento;
	private String email;
	private CarreraDto carreraDto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CarreraDto getCarreraDto() {
		return carreraDto;
	}

	public void setCarreraDto(CarreraDto carreraDto) {
		this.carreraDto = carreraDto;
	}
}
