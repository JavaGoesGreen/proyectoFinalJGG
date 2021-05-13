package com.rest.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.model.Cliente;
import com.rest.spring.service.ClientesServiceImpl;


@RestController
public class ClientesController {
	
	  private final Logger log = LoggerFactory.getLogger(ClientesController.class);
	
	@Autowired
	ClientesServiceImpl service;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		log.info("----Entrando en método listar clientes /clientes--------");
		return service.getClientes();	
	}
	
	@PostMapping("/clientes/admin/post")
	public Cliente addCliente(@RequestBody Cliente cliente) {
		log.info("----Entrando en método add clientes /clientes/admin/post--------");
		return service.addCliente(cliente);
	}	
	
}
