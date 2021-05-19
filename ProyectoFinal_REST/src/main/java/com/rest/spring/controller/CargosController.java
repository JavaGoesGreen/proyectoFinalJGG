package com.rest.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.model.Cargo;
import com.rest.spring.service.CargosServiceImpl;


@RestController
public class CargosController {
	
	  private final Logger log = LoggerFactory.getLogger(CargosController.class);
	
	@Autowired
	CargosServiceImpl service;
	
	@GetMapping("/cargos")
	public List<Cargo> getCargos() {
		log.info("----Entrando en método listar cargos--------");
		return service.getCargos();	
	}
	
	@PostMapping("/cargos/admin/post")
	public Cargo addCargo(@RequestBody Cargo cargo) {
		log.info("----Entrando en método add cargo REST --------");
		return service.addCargo(cargo);
	}	
	
}
