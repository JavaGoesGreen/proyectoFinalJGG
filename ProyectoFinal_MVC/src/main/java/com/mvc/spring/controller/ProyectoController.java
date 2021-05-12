package com.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.spring.model.Proyecto;
import com.mvc.spring.service.ProyectosServiceImpl;

@Controller
/*@RequestMapping("/admin/proyectos")*/
public class ProyectoController {

	@Autowired 
	ProyectosServiceImpl service;
	
	@GetMapping("/proyectos")
	public String listaProyectos(Model m) {
		m.addAttribute("proyectoslista", service.getProyectos());
		return "proyectos";
	}
	
	@GetMapping("/proyectos/admin/list")
	public String listaProyectosAdmin(Model m) {
		m.addAttribute("proyectoslista", service.getProyectos());
		return "admin/proyectosadmin";
	}
	
	//nuevo usuario
	@GetMapping("proyectos/admin/add")
	public String newUser(Proyecto proyecto) {
		return "/admin/addProyecto";
	}
	
	@PostMapping("proyectos/admin/post")
	public ModelAndView addProyecto(Proyecto proyecto) {	
		service.addProyectos(proyecto);
		return new ModelAndView("redirect:/");
	}
	
	
	//referencias a otras paginas
	@GetMapping("/contacto")
	public String contacto() {

		return "contacto";
	}
	
	@GetMapping("/equipo")
	public String equipo() {

		return "equipo";
	}
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}
}
