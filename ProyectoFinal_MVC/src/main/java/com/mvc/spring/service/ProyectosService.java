package com.mvc.spring.service;

import java.util.List;

import com.mvc.spring.model.Proyecto;

public interface ProyectosService {
  
	public List<Proyecto>getProyectos();
	
	public void addProyectos(Proyecto proyecto);
}
