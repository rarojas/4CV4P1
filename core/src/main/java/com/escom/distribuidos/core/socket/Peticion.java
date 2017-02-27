package com.escom.distribuidos.core.socket;

import java.io.Serializable;

public class Peticion implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1034658149590845356L;

	private String method;
	private String route;
	private Object payload;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
