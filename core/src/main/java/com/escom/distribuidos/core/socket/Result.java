package com.escom.distribuidos.core.socket;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2677025936042896986L;

	private StatusCodeEnum code = StatusCodeEnum.OK;
	private Object payload;

	public StatusCodeEnum getCode() {
		return code;
	}

	public void setCode(StatusCodeEnum code) {
		this.code = code;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
