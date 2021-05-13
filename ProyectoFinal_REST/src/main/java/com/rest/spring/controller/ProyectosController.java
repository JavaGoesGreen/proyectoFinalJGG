package com.rest.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.spring.model.Proyecto;
import com.rest.spring.service.ProyectosServiceImpl;

@RestController
public class ProyectosController {
	
	  private final Logger log = LoggerFactory.getLogger(ProyectosController.class);
	
	@Autowired
	ProyectosServiceImpl service;
	
	@GetMapping("/proyectos")
	public List<Proyecto> getProyectos() {
		log.info("----Entrando en método listar proyectos /proyectos--------");
		return service.getProyectos();	
	}
	
	@PostMapping("/proyectos/admin/post") //(value = "/proyectos/add", consumes = "application/json", produces = "application/json)
	public Proyecto addProyecto(@RequestBody Proyecto proyecto) {
		System.out.println("POSTCONTROLLER EN REST------------------------------");
		Proyecto p = service.addProyectos(proyecto);
		System.out.println(p);
		return p;
	}	
	
}
