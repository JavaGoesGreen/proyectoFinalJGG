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
/**
 * <p><b> Nombre </b> ProyectoController</p>
 * 
 * <p><strong>Descripcion </strong> controlador del proyecto MVC que recibe json</p>
 * 
 * @author	Toni Blanche
 * 
 * @version	v1
 * 
 * @since	13/05/2021
 */

@Controller
/* @RequestMapping("/admin/proyectos") */
public class ProyectoController {

	@Autowired
	ProyectosServiceImpl serviceProyecto;
	
	/*@Autowired
	ClienteServiceImpl serviceCliente;*/

	@GetMapping("/proyectos")
	public String listaProyectos(Model m) {
		m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		return "proyectos";
	}

	@GetMapping("/proyectos/admin/list")
	public String listaProyectosAdmin(Model m) {
		m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		return "admin/proyectosadmin";
	}

	// nuevo usuario
	@GetMapping("proyectos/admin/add")
	public String newUser(Proyecto proyecto) {
		return "/admin/addProyecto";
	}
	
	/*@GetMapping("proyectos/admin/add")
	public String newUser(Model m) {
		
		m.addAttribute("cliente", serviceCliente.getCliente() )
		return "/admin/addProyecto";
	}*/

	@PostMapping("proyectos/admin/post")
	public ModelAndView addProyecto(Proyecto proyecto) {
		serviceProyecto.addProyectos(proyecto);
		return new ModelAndView("proyectos/admin/add");
	}

	// referencias a otras paginas
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
