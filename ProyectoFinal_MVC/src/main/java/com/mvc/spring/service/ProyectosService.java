package com.mvc.spring.service;

import java.util.Collection;
import java.util.List;

import com.mvc.spring.model.Proyecto;

public interface ProyectosService {
  
	public Collection<Proyecto>getProyectos();
	
	public void addProyectos(Proyecto proyecto);
}
