package com.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.spring.model.Cliente;
import com.mvc.spring.model.Proyecto;
import com.mvc.spring.service.ClientesServiceImpl;
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
public class ProyectoController {

	@Autowired
	ProyectosServiceImpl serviceProyecto;
	
	@Autowired
	ClientesServiceImpl serviceCliente;

	@GetMapping("/proyectos")
	public String listaProyectos(Model m) {
		m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		return "proyectos";
	}

	@GetMapping("/proyectos/admin/list")
	public String listaProyectosAdmin(Model m) {
		//m.addAttribute("cliente", proyecto.getEmpresa().getIdcliente());
		m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		return "admin/proyectosadmin";
	}
	
	@GetMapping("proyectos/admin/add")
	public String newUser(Model m, Proyecto proyecto) {
		m.addAttribute("proyecto", proyecto);
		m.addAttribute("cliente", serviceCliente.getClientes());
		return "/admin/addProyecto";
	}

	@PostMapping("proyectos/admin/post")
	public ModelAndView addProyecto(Proyecto proyecto) {
		System.out.println("IMPRIMIENDO PROYECTO-------" + proyecto);
		serviceProyecto.addProyectos(proyecto);
		System.out.println("IMPRIMIENDO PROYECTO1000-------" + proyecto);
		return new ModelAndView("redirect:/proyectos/admin/list");
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
