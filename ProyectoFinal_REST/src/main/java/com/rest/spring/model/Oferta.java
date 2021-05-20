package com.rest.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ofertas")
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idoferta")
	private int idoferta;
	private String puesto;
	private String empresa;
	private String conocimientos;
	private String descripcion;
	private String aptitudes;
	private String fecha;

	// constructors
	public Oferta() {
		super();
	}

	public Oferta(int idoferta, String puesto, String empresa, String conocimientos, String descripcion,
			String aptitudes, String fecha) {
		super();
		this.idoferta = idoferta;
		this.puesto = puesto;
		this.empresa = empresa;
		this.conocimientos = conocimientos;
		this.descripcion = descripcion;
		this.aptitudes = aptitudes;
		this.fecha = fecha;
	}

	// getters and setters
	public int getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(String conocimientos) {
		this.conocimientos = conocimientos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAptitudes() {
		return aptitudes;
	}

	public void setAptitudes(String aptitudes) {
		this.aptitudes = aptitudes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	// toString
	@Override
	public String toString() {
		return "Oferta [idoferta=" + idoferta + ", puesto=" + puesto + ", empresa=" + empresa + ", conocimientos="
				+ conocimientos + ", descripcion=" + descripcion + ", aptitudes=" + aptitudes + ", fecha=" + fecha
				+ "]";
	}
}
