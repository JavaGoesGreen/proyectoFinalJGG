package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Proyecto;

public interface ProyectosService {
  
	public Collection<Proyecto>getProyectos();
	
	public void addProyectos(Proyecto proyecto);
	
	public Proyecto selectProyecto(Integer id);
	
	public void updateProyectos(Proyecto proyecto);
}
