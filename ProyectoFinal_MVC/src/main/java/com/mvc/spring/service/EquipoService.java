package com.mvc.spring.service;

import java.util.Collection;

import com.mvc.spring.model.Equipo;

/**
 * <p>
 * <b> Nombre </b>Interface Servicios de Equipo
 * </p>
 * 
 * <p>
 * <strong>Descripcion </strong> Interface con métodos que implementa clase
 * Servicios de Equipo
 * </p>
 * 
 * @author Antonia Hidalgo
 * 
 * @version v1
 * 
 * @since 15/05/2021
 */
public interface EquipoService {

	public Collection<Equipo> getEquipo();

	public void addEquipo(Equipo equipo);

	public Equipo selectEquipo(Integer id);

	public void updateEquipo(Equipo equipo);

	public void deleteEquipo(Integer id);
}
