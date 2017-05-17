package com.escom.distribuidos.p2.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1869482981105587847L;

	@Id
	private int id;
	private BigDecimal puntaje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}

}
