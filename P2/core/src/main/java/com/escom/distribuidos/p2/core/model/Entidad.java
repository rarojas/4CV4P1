package com.escom.distribuidos.p2.core.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidad<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8467890581807743032L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

}
