package com.rest.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.rest.spring.model.Equipo;
import com.rest.spring.service.EquipoServiceImpl;


public class EquipoController {

	 private final Logger log = LoggerFactory.getLogger(EquipoController.class);
		
		@Autowired
	    EquipoServiceImpl equipoService;
		
		@GetMapping("/equipo")
		public List<Equipo> getEquipo() {
			log.info("----Entrando en método listar miembros del equipo /equipo--------");
			return equipoService.getEquipo();	
		}
}
