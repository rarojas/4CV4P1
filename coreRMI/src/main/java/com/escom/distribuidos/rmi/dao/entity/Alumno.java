package com.escom.distribuidos.rmi.dao.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "id")
public class Alumno extends Usuario {

	/**
	 *
	 */
	private static final long serialVersionUID = 6696169098368628193L;

}
