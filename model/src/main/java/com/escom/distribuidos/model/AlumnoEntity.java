package com.escom.distribuidos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;
import com.escom.distribuidos.core.annotations.Id;
import com.escom.distribuidos.core.annotations.OneToMany;

@Entity
public class AlumnoEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8435076050718785207L;

	@Id
	@Column(name = "idAlumno")
	private int idAlumno;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "paterno")
	private String paterno;

	@Column(name = "materno")
	private String materno;

	@Column(name = "email")
	private String email;

	@Column(name = "calle")
	private String calle;

	@Column(name = "numero")
	private String numero;

	@Column(name = "colonia")
	private String colonia;

	@Column(name = "delegacion")
	private String delegacion;

	@Column(name = "entidad")
	private String entidad;

	@Column(name = "noTelefono")
	private String noTelefono;

	@OneToMany
	private List<CursoEntity> cursos = new ArrayList<CursoEntity>();

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getNoTelefono() {
		return noTelefono;
	}

	public void setNoTelefono(String noTelefono) {
		this.noTelefono = noTelefono;
	}

	public List<CursoEntity> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
	}

}
