package com.mvc.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		/*m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		System.out.println(serviceProyecto.getProyectos());
		return "admin/proyectosadmin";*/
		List<Proyecto> proyectos = new ArrayList<>();
		proyectos.addAll(serviceProyecto.getProyectos());
		m.addAttribute("proyectoslista" ,proyectos);
		
		return "admin/proyectosadmin";
	}
	
	@GetMapping("proyectos/admin/add")
	public ModelAndView newProyecto() {
		ModelAndView m = new ModelAndView("/admin/addProyecto");
		m.addObject("proyecto", new Proyecto());
		m.addObject("listaClientes", serviceCliente.getClientes());
		return m;
	}

	@PostMapping("proyectos/admin/post")
	public ModelAndView addProyecto(@ModelAttribute Proyecto proyecto) {
		System.out.println("IMPRIMIENDO PROYECTO-------" + proyecto);
		serviceProyecto.addProyectos(proyecto);
		return new ModelAndView("redirect:/proyectos/admin/list");
	}
	// Alta proyecto
	/*	@GetMapping("backoffice/proyectos/new")
		public ModelAndView newProject() {
			ModelAndView model = new ModelAndView("ProjectForm");
			model.addObject("project", new Project());
			model.addObject("clients", clientService.findAll());
			return model;
		}
*/
	// salvar proyecto
	/*	@PostMapping("backoffice/proyectos/save")
		public ModelAndView saveProject(Project project) {
			log.info("----- Inside saveProject");
			log.info("----- objeto Project" + project);
			projectService.save(project);
			return new ModelAndView("redirect:/backoffice/proyectos/");
		}*/

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
