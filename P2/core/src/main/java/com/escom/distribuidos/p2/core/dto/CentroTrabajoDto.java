package com.escom.distribuidos.p2.core.dto;

public class CentroTrabajoDto extends EntidadDto<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1646472893955695754L;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
