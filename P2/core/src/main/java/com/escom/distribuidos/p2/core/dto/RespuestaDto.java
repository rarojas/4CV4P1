package com.escom.distribuidos.p2.core.dto;

public class RespuestaDto extends EntidadDto<Integer> {

	private static final long serialVersionUID = 2604773993043784536L;

	private String respuesta;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
