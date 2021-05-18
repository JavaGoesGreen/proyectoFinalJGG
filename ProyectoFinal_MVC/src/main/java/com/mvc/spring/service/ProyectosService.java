package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Proyecto;
/**
 * <p><b> Nombre </b>Interface Servicios de Proyecto</p>
 * 
 * <p><strong>Descripcion </strong> Interface con métodos que implementa clase Servicios de proyecto</p>
 * 
 * @author	Yelder Da Silva
 * 
 * @version	v1
 * 
 * @since	12/05/2021
 */
public interface ProyectosService {
  
	public Collection<Proyecto>getProyectos();
	
	public void addProyectos(Proyecto proyecto);
	
	public Proyecto selectProyecto(Integer id);
	
	public void updateProyectos(Proyecto proyecto);
	
	public void deleteProyecto(Integer id);
}
