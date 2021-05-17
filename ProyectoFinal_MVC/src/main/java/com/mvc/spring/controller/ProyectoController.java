package com.mvc.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private final Logger log = LoggerFactory.getLogger(ProyectoController.class);
	
	@Autowired
	ProyectosServiceImpl serviceProyecto;
	
	@Autowired
	ClientesServiceImpl serviceCliente;

	// --------------------------------------------------------------------
	// FRONT OFFICE
	
	@GetMapping("proyectos")
	public String listaProyectos(Model m) {
		m.addAttribute("proyectoslista", serviceProyecto.getProyectos());
		m.addAttribute("listaClientes", serviceCliente.getClientes());
		m.addAttribute("cliente", new Cliente());
		return "proyectos";
	}
	
	@GetMapping("proyectos/detalle")
	public ModelAndView selectProyectoDetalle(@RequestParam Integer id) {
		log.info("--------------------------------------ProyectoControllerMVC" + id);
		ModelAndView m = new ModelAndView("/proyectodetalle");
		m.addObject("proyecto", serviceProyecto.selectProyecto(id));
		m.addObject("listaClientes", serviceCliente.getClientes());
		return m;
	}
	
	@GetMapping("proyectos/empresa")
	public String selectProyectoEmpresa(@RequestParam Integer idcliente, Model m) {
		List<Proyecto> todosproyectos = new ArrayList<>();
		List<Proyecto> proyectos = new ArrayList<>();
		todosproyectos.addAll(serviceProyecto.getProyectos());
		for (Proyecto p: todosproyectos) {
			if (idcliente == 0){
				proyectos = todosproyectos;
			}
			else if (p.getCliente().getIdcliente() == idcliente) {
				proyectos.add(p);
			}
		}
		m.addAttribute("proyectoslista", proyectos);
		m.addAttribute("listaClientes", serviceCliente.getClientes());
		m.addAttribute("cliente", new Cliente());
		return "proyectos";
	}

	// --------------------------------------------------------------------
	// BACK OFFICE
	
	@GetMapping("admin/proyectos/list")
	public String listaProyectosAdmin(Model m) {
		List<Proyecto> proyectos = new ArrayList<>();
		proyectos.addAll(serviceProyecto.getProyectos());
		m.addAttribute("proyectoslista", proyectos);
		return "admin/proyectosadmin";
	}
	
	@GetMapping("admin/proyectos/add")
	public ModelAndView newProyecto() {
		ModelAndView m = new ModelAndView("/admin/addProyecto");
		m.addObject("proyecto", new Proyecto());
		m.addObject("listaClientes", serviceCliente.getClientes());
		return m;
	}

	@PostMapping("admin/proyectos/post")
	public ModelAndView addProyecto(@ModelAttribute Proyecto proyecto) {
		log.info("IMPRIMIENDO PROYECTO-------" + proyecto);
		serviceProyecto.addProyectos(proyecto);
		return new ModelAndView("redirect:/admin/proyectos/list");
	}
	
	@GetMapping("admin/proyectos/select")
	public ModelAndView selectProyecto(@RequestParam Integer id) {
		log.info("--------------------------------------ProyectoControllerMVC" + id);
		ModelAndView m = new ModelAndView("/admin/updateProyecto");
		m.addObject("proyecto", serviceProyecto.selectProyecto(id));
		m.addObject("listaClientes", serviceCliente.getClientes());
		return m;
	}
	
	@RequestMapping(value="admin/proyectos/update", method = { RequestMethod.POST})
	public ModelAndView updateProyecto(@ModelAttribute Proyecto proyecto) {
		log.info("IMPRIMIENDO PROYECTO-------" + proyecto);
		serviceProyecto.updateProyectos(proyecto);
		return new ModelAndView("redirect:/admin/proyectos/list");
	}
	
	@GetMapping(value="/admin/proyectos/delete")
	public ModelAndView deleteProyecto(@RequestParam Integer id) {
		log.info("ELIMINANDO PROYECTO-------ID:" + id);
		serviceProyecto.deleteProyecto(id);
		return new ModelAndView("redirect:/admin/proyectos/list");
	}
}
