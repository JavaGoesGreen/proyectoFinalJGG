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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.spring.model.Equipo;
import com.mvc.spring.service.CargosServiceImpl;
import com.mvc.spring.service.EquipoServiceImpl;

/**
 * <p>
 * <b> Nombre </b> EquipoController
 * </p>
 * <p>
 * <strong>Descripcion </strong>endpoints del proyecto MVC para objetos equipo
 * </p>
 * 
 * @author Toni Blanche
 * @version v1
 * @since 13/05/2021
 */

@Controller
public class EquipoController {

	private final Logger log = LoggerFactory.getLogger(ProyectoController.class);

	@Autowired
	EquipoServiceImpl serviceEquipo;

	@Autowired
	CargosServiceImpl serviceCargo;

	// --------------------------------------------------------------------
	// FRONT OFFICE

	@GetMapping("/equipo")
	public String listaEquipo(Model m) {
		List<Equipo> equipos = new ArrayList<>();
		equipos.addAll(serviceEquipo.getEquipo());
		Integer id = (int) ((Math.random() * 400) + 100);
		for (int i = 0; i <= 15; i++) {
			equipos.add(serviceEquipo.newFakeMember(id));
			id++;
		}
		m.addAttribute("equipolista", equipos);
		return "equipo";
	}

	// --------------------------------------------------------------------
	// BACK OFFICE

	@GetMapping("/admin/equipo/list")
	public String listaEquipoAdmin(Model m) {
		List<Equipo> equipos = new ArrayList<>();
		equipos.addAll(serviceEquipo.getEquipo());

		m.addAttribute("equipoLista", equipos);
		log.info("Lista en Equipo controller: " + equipos);
		return "admin/equipoadmin";
	}

	@GetMapping("admin/equipo/add")
	public ModelAndView newEquipo() {
		log.info("AGREGANDO EQUIPO-------");
		ModelAndView m = new ModelAndView("/admin/addEquipo");
		m.addObject("equipo", new Equipo());
		m.addObject("listaCargos", serviceCargo.getCargos());
		return m;
	}

	@PostMapping("admin/equipo/post")
	public ModelAndView addProyecto(@ModelAttribute Equipo equipo) {
		log.info("IMPRIMIENDO EQUIPO-------" + equipo);
		serviceEquipo.addEquipo(equipo);
		return new ModelAndView("redirect:/admin/equipo/list");
	}

	@GetMapping("admin/equipo/select")
	public ModelAndView selectEquipo(@RequestParam Integer id) {
		log.info("--------------------------------------EquipoControllerMVC" + id);
		ModelAndView m = new ModelAndView("/admin/updateEquipo");
		m.addObject("equipo", serviceEquipo.selectEquipo(id));
		m.addObject("listaCargos", serviceCargo.getCargos());
		return m;
	}

	@PostMapping("admin/equipo/update")
	public ModelAndView updateEquipo(@ModelAttribute Equipo equipo) {
		log.info("IMPRIMIENDO EQUIPO-------" + equipo);
		serviceEquipo.updateEquipo(equipo);
		return new ModelAndView("redirect:/admin/equipo/list");
	}

	@GetMapping(value = "admin/equipo/delete")
	public ModelAndView deleteEquipo(@RequestParam Integer id) {
		log.info("ELIMINANDO EQUIPO-------ID:" + id);
		serviceEquipo.deleteEquipo(id);
		return new ModelAndView("redirect:/admin/equipo/list");
	}

}
