package com.rest.spring.service;

import java.util.List;
import com.rest.spring.model.Equipo;

public interface EquipoService {

	public List<Equipo> getEquipo();

	public Equipo addEquipo(Equipo equipo);

	public Equipo updateEquipos(Equipo equipo);

	public Equipo getEquipoById(Integer id);

	public void deleteEquipo(Integer id);
}
