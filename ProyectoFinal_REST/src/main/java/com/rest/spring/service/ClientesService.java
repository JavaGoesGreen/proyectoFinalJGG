package com.rest.spring.service;

import java.util.List;

import com.rest.spring.model.Cliente;



public interface ClientesService {

	public List<Cliente> getClientes();
	
	public Cliente addCliente(Cliente cliente);
}
