package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Mensaje;
/**
 * <p><b> Nombre </b>Interface Servicios de Mensaje</p>
 * 
 * <p><strong>Descripcion </strong> Interface con métodos que implementa clase Servicios de mensaje</p>
 * 
 * @author	Yelder Da Silva
 * 
 * @version	v1
 * 
 * @since	15/05/2021
 */
public interface MensajesService {
  
	public Collection<Mensaje>getMensajes();
	
	public Mensaje addMensajes(Mensaje mensaje);
	
	public Mensaje selectMensaje(Integer id);
	
	public void updateMensajes(Mensaje mensaje);
	
	public void deleteMensaje(Integer id);
	
}
