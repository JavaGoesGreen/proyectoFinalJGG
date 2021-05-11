package com.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.spring.service.ProyectosServiceImpl;

@Controller
public class ProyectoController {

	@Autowired 
	ProyectosServiceImpl proyectosServiceImpl;
	
	@GetMapping("/proyectos")
	public String listUser(Model m) {
		m.addAttribute("proyectoslista", proyectosServiceImpl.getProyectos());
		return "proyectos";
	}

}
