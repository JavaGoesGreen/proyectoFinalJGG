package com.rest.spring.service;

import java.util.List;

import com.rest.spring.model.Mensaje;

public interface MensajeService {

	public List<Mensaje> getMensajes();

	public Mensaje addMensajes(Mensaje mensaje);

	public Mensaje updateMensajes(Mensaje mensaje);

	public Mensaje getMensajeById(Integer id);

	public void deleteMensaje(Integer id);
}
