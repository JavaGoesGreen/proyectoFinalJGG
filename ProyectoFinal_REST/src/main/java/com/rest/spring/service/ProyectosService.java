package com.rest.spring.service;

import java.util.List;
import com.rest.spring.model.Proyecto;

public interface ProyectosService {

	public List<Proyecto> getProyectos();
	
	public Proyecto addProyectos(Proyecto proyecto);
	
	public Proyecto updateProyectos(Proyecto proyecto);
	
	public Proyecto getProyectoById(Integer id);
	
}
