package com.mvc.spring.model;

/**
 * <p>
 * <b> Nombre </b> Clase Proyecto
 * </p>
 * 
 * <p>
 * <strong>Descripcion </strong> Recoge todos los campos de información de un
 * proyecto
 * </p>
 * 
 * @author Toni Blanche
 * 
 * @version v1
 * 
 * @since 19/05/2021
 */

public class Oferta {

	private int idoferta;
	private String puesto;
	private String empresa;
	private String conocimientos;
	private String descripcion;
	private String aptitudes;
	private String fecha;

	// Constructores
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
