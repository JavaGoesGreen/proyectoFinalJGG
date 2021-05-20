package com.rest.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		log.info("----Entrando en método listar proyectos REST --------");
		return service.getProyectos();	
	}
	
	@PostMapping("/proyectos/admin/post") 
	public Proyecto addProyecto(@RequestBody Proyecto proyecto) {
		log.info("---- Entrando en método guardar proyecto REST ------- "+proyecto.getIdproyecto()+" -------");
		Proyecto p = service.addProyectos(proyecto);
		log.info("Proyecto a añadir: "+p);
		return p;
	}
	
	@GetMapping("/proyectos/admin/select/{id}")
	public Proyecto selectProyecto(@PathVariable Integer id) {
		log.info("---- Entrando en método seleccionar proyecto "+id+" REST -------");
		return service.getProyectoById(id);
	}
	
	@PutMapping("/proyectos/admin/update/{proyecto.getIdproyecto()}")
	public String updateProyecto(@RequestBody Proyecto proyecto) {
		log.info("---- Entrando en método modificar proyecto REST ------- "+proyecto.getIdproyecto()+" -------");
		service.updateProyectos(proyecto);
		String mensaje ="Proyecto actualizado"; 
		return mensaje;
	}
	
	
	@DeleteMapping("/proyectos/admin/delete/{id}")
	public String deleteProyecto(@PathVariable Integer id) {
		
		service.deleteProyecto(id);
		 String mensaje =("Proyecto eliminado");
	return mensaje;
	}
	
	
}
