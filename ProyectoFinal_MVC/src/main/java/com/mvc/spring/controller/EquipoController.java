package com.mvc.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.spring.model.Equipo;
import com.mvc.spring.service.CargosServiceImpl;
import com.mvc.spring.service.EquipoServiceImpl;
/**
 * <p><b> Nombre </b> ProyectoController</p>
 * <p><strong>Descripcion </strong> controlador del proyecto MVC que recibe json</p>
 * @author	Toni Blanche
 * @version	v1
 * @since	13/05/2021
 */

@Controller
public class EquipoController {

	@Autowired
	EquipoServiceImpl serviceEquipo;
	
	@Autowired
	CargosServiceImpl serviceCargo;

	@GetMapping("/equipo")
	public String listaEquipo(Model m) {
		m.addAttribute("equipolista", serviceEquipo.getEquipo());
		return "equipo";
	}

	@GetMapping("/equipo/admin/list")
	public String listaEquipoAdmin(Model m) {
		List<Equipo> equipos = new ArrayList<>();
		equipos.addAll(serviceEquipo.getEquipo());
		m.addAttribute("equipoLista", equipos);
		System.out.println("Lista en Equipo controller: "+equipos);
		return "admin/equipoadmin";
	}
	
	@GetMapping("equipo/admin/add")
	public ModelAndView newEquipo() {
		ModelAndView m = new ModelAndView("/admin/addEquipo");
		m.addObject("equipo", new Equipo());
		m.addObject("listaCargos", serviceCargo.getCargos());
		return m;
	}

	@PostMapping("equipo/admin/post")
	public ModelAndView addProyecto(@ModelAttribute Equipo equipo) {
		System.out.println("IMPRIMIENDO EQUIPO-------" + equipo);
		serviceEquipo.addEquipo(equipo);
		return new ModelAndView("redirect:/equipo/admin/list");
	}
	
	@GetMapping("equipo/admin/select/{id}")
	public ModelAndView selectEquipo(@PathVariable Integer id) {
		System.out.println("--------------------------------------EquipoControllerMVC" + id);
		ModelAndView m = new ModelAndView("/admin/updateProyecto");
		m.addObject("proyecto", serviceEquipo.selectEquipo(id));
		m.addObject("listaCargos", serviceCargo.getCargos());
		return m;
	}
	
	@PutMapping("equipo/admin/update")
	public ModelAndView updateEquipo(@RequestParam Equipo equipo) {
		System.out.println("IMPRIMIENDO EQUIPO-------" + equipo);
		serviceEquipo.updateEquipo(equipo);
		return new ModelAndView("redirect:/equipo/admin/list");
	}
	

	/* referencias a otras paginas
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
	}*/
}
