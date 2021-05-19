package com.mvc.spring.service;

import java.util.List;

import com.mvc.spring.model.Cargo;
/**
 * <p><b> Nombre </b>Interface Servicios de Cargo</p>
 * 
 * <p><strong>Descripcion </strong> Interface con métodos que implementa clase Servicios de cargo</p>
 * 
 * @author	Dario Denche
 * 
 * @version	v1
 * 
 * @since	15/05/2021
 */
public interface CargosService {
  
	public List<Cargo>getCargos();
	
}
