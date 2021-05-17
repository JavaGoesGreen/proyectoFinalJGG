package com.rest.spring.service;

import java.util.List;

import com.rest.spring.model.Mensaje;

public interface MensajeService {

	public List<Mensaje> getMensajes();
	
	public Mensaje addMensajes(Mensaje mensaje);
	
}
