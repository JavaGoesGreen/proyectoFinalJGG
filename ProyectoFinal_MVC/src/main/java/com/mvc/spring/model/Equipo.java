package com.mvc.spring.model;

/**
 * <p><b> Nombre </b> Clase Equipo</p>
 * 
 * <p><strong>Descripcion </strong> integrantes de la empresa</p>
 * 
 * @author	Antonia Hidalgo
 * 
 * @version	v1
 * 
 * @since	15/05/2021
 */
public class Equipo {

	private int idpersona;
	private String nombre;
	private String apellidos;
	private String resumen;
	private String foto;
	private Cargo cargo;

	// Constructor
	public Equipo() {
		super();
	}

	public Equipo(int idpersona, String nombre, String apellidos, String resumen, String foto, Cargo cargo) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.resumen = resumen;
		this.foto = foto;
		this.cargo = cargo;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	// toString
	@Override
	public String toString() {
		return "Equipo [idpersona=" + idpersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", resumen="
				+ resumen + ", foto=" + foto + ", cargo=" + cargo + "]";
	}

}
