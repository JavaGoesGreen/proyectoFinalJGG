package com.rest.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpersona")
	private int idpersona;
	private String nombre;
	private String apellidos;
	private String resumen;
	private String foto;

	
	@ManyToOne
	@JoinColumn(name="cargo")
	private Equipo equipo;

	// Constructor
	public Equipo() {
		super();
	}

	public Equipo(int idpersona, String nombre, String apellidos, String resumen, String foto, int cargo) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.resumen = resumen;
		this.foto = foto;
	}

	// Getters and setters
	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



	// toString
	@Override
	public String toString() {
		return "Equipo [idpersona=" + idpersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", resumen="
				+ resumen + ", foto=" + foto + "]";
	}

}
