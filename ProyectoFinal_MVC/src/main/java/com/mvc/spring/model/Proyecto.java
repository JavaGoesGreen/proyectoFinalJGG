package com.mvc.spring.model;



public class Proyecto {

	private int idproyecto;
	private String proyecto;
	private String fechafin;
	private String resumen;
	private String descripcion;
	private String imagen;
	private Cliente empresa;
	
	//Constructores 
	public Proyecto(int idproyecto, String proyecto, String fechafin, String resumen, String descripcion, String imagen,
			Cliente empresa) {
		super();
		this.idproyecto = idproyecto;
		this.proyecto = proyecto;
		this.fechafin = fechafin;
		this.resumen = resumen;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.empresa = empresa;
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
	public Cliente getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Cliente empresa) {
		this.empresa = empresa;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Proyecto [idproyecto=" + idproyecto + ", proyecto=" + proyecto + ", fechafin=" + fechafin + ", resumen="
				+ resumen + ", descripcion=" + descripcion + ", imagen=" + imagen + ", empresa=" + empresa + "]";
	}	
	
	
	
}