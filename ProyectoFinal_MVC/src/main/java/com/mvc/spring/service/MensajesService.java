package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Mensaje;

public interface MensajesService {
  
	public Collection<Mensaje>getMensajes();
	
	public void addMensajes(Mensaje mensaje);
	
}
