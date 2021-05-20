package com.rest.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private int idcliente;
	private String nombre;
	private String descripcion;
	private String logo;

	// constructors
	public Cliente() {
		super();
	}

	public Cliente(int idcliente, String nombre, String descripcion, String logo) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.logo = logo;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombre=" + nombre + ", descripcion=" + descripcion + ", logo="
				+ logo + "]";
	}

}
