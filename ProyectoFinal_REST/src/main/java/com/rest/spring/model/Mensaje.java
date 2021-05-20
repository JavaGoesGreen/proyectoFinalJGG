package com.rest.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensajes")
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmensaje")
	private int idmensaje;
	private String nombre;
	private String correo;
	private String fecha;
	private String subject;
	private String mensaje;
	private String respuesta;

	// Contructors
	public Mensaje() {
		super();
	}

	public Mensaje(int idmensaje, String nombre, String correo, String fecha, String subject, String mensaje,
			String respuesta) {
		super();
		this.idmensaje = idmensaje;
		this.nombre = nombre;
		this.correo = correo;
		this.fecha = fecha;
		this.subject = subject;
		this.mensaje = mensaje;
		this.respuesta = respuesta;
	}

	public int getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(int idmensaje) {
		this.idmensaje = idmensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Mensaje [idmensaje=" + idmensaje + ", nombre=" + nombre + ", correo=" + correo + ", fecha=" + fecha
				+ ", subject=" + subject + ", mensaje=" + mensaje + ", respuesta=" + respuesta + "]";
	}

}