package com.mvc.spring.model;
/**
 * <p><b> Nombre </b> Clase Proyecto</p>
 * 
 * <p><strong>Descripcion </strong> Recoge todos los campos de información de un proyecto</p>
 * 
 * @author	Toni Blanche
 * 
 * @version	v1
 * 
 * @since	12/05/2021
 */


public class Proyecto {

	private int idproyecto;
	private String proyecto;
	private String fechafin;
	private String resumen;
	private String descripcion;
	private String imagen;
	private Cliente cliente;
	
	//Constructores 
	public Proyecto(int idproyecto, String proyecto, String fechafin, String resumen, String descripcion, String imagen, Cliente cliente) {
		super();
		this.idproyecto = idproyecto;
		this.proyecto = proyecto;
		this.fechafin = fechafin;
		this.resumen = resumen;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.cliente = cliente;
	}
	
	public Proyecto() {
		super();
	}
	
	//Getters y Setters
	public int getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(int idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getFechafin() {
		return fechafin;
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Proyecto [idproyecto=" + idproyecto + ", proyecto=" + proyecto + ", fechafin=" + fechafin + ", resumen="
				+ resumen + ", descripcion=" + descripcion + ", imagen=" + imagen + ", cliente=" + cliente + "]";
	}	
	
	
	
}
