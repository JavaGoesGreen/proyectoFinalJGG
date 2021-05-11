package com.rest.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.spring.model.Proyecto;
import com.rest.spring.service.ProyectosServiceImpl;

@RestController
public class Rest_Controller {
	
	  private final Logger log = LoggerFactory.getLogger(Rest_Controller.class);
	
	@Autowired
	ProyectosServiceImpl service;
	
	@GetMapping("/proyectos")
	public List<Proyecto> getProyectos() {
		
		log.info("----Entrando en método listar proyectos /proyectos--------");
		
		return service.getProyectos();
		
	}
}
