package com.mvc.spring.service;

import java.util.List;

import com.mvc.spring.model.Cliente;

/**
 * <p>
 * <b> Nombre </b>Interface Servicios de Cliente
 * </p>
 * 
 * <p>
 * <strong>Descripcion </strong> Interface con métodos que implementa clase
 * Servicios de Cliente
 * </p>
 * 
 * @author Toni Blanche
 * 
 * @version v1
 * 
 * @since 15/05/2021
 */
public interface ClientesService {

	public List<Cliente> getClientes();

}
