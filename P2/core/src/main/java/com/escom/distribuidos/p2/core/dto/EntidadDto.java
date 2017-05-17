package com.escom.distribuidos.p2.core.dto;

import java.io.Serializable;

public class EntidadDto<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1487399720679662897L;

	protected T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

}
