package com.escom.distribuidos.p2.core.dto;

public class CarreraDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -7559338346384813819L;
	private String nombre;
	private int duracion;
	private CentroTrabajoDto centroTrabajoDto;

	public CentroTrabajoDto getCentroTrabajoDto() {
		return centroTrabajoDto;
	}

	public void setCentroTrabajoDto(CentroTrabajoDto centroTrabajoDto) {
		this.centroTrabajoDto = centroTrabajoDto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
