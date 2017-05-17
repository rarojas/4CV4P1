package com.escom.distribuidos.p2.core.dto;

public class MateriaDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -2232968890100159355L;
	private String nombre;
	private int creditos;
	private CarreraDto carrera;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public CarreraDto getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraDto carrera) {
		this.carrera = carrera;
	}
}
