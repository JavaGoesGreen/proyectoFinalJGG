package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Equipo;

public interface EquipoService {
  
	public Collection<Equipo>getEquipo();
	
	public void addEquipo(Equipo equipo);
	
	public Equipo selectEquipo(Integer id);
	
	public void updateEquipo(Equipo equipo);
	
	public void deleteEquipo(Integer id);
}
