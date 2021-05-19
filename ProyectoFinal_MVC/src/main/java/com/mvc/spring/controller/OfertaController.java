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

import com.mvc.spring.model.Oferta;
import com.mvc.spring.service.OfertasServiceImpl;

/**
 * <p><b> Nombre </b> ProyectoController</p>
 * 
 * <p><strong>Descripcion </strong> endpoints del proyecto MVC para objetos proyecto</p>
 * 
 * @author	Toni Blanche
 * 
 * @version	v1
 * 
 * @since	19/05/2021
 */

@Controller
public class OfertaController {
	
	private final Logger log = LoggerFactory.getLogger(OfertaController.class);
	
	@Autowired
	OfertasServiceImpl serviceOferta;
	

	// --------------------------------------------------------------------
	// FRONT OFFICE
	
	@GetMapping("ofertas")
	public String listaOfertas(Model m) {
		m.addAttribute("ofertaslista", serviceOferta.getOfertas());
		return "ofertas";
	}
	
	@GetMapping("ofertas/detalle")
	public ModelAndView selectOfertaDetalle(@RequestParam Integer id) {
		log.info("--------------------------------------OfertaControllerMVC" + id);
		ModelAndView m = new ModelAndView("/ofertadetalle");
		m.addObject("oferta", serviceOferta.selectOferta(id));
		return m;
	}

	// --------------------------------------------------------------------
	// BACK OFFICE
	
	@GetMapping("admin/ofertas/list")
	public String listaOfertasAdmin(Model m) {
		List<Oferta> ofertas = new ArrayList<>();
		ofertas.addAll(serviceOferta.getOfertas());
		m.addAttribute("ofertaslista", ofertas);
		return "admin/ofertasadmin";
	}
	
	@GetMapping("admin/ofertas/add")
	public ModelAndView newOferta() {
		ModelAndView m = new ModelAndView("/admin/addOferta");
		m.addObject("oferta", new Oferta());
		return m;
	}

	@PostMapping("admin/ofertas/post")
	public ModelAndView addOferta(@ModelAttribute Oferta oferta) {
		log.info("IMPRIMIENDO Oferta-------" + oferta);
		serviceOferta.addOfertas(oferta);
		return new ModelAndView("redirect:/admin/ofertas/list");
	}
	
	@GetMapping("admin/ofertas/select")
	public ModelAndView selectOferta(@RequestParam Integer id) {
		log.info("--------------------------------------OfertaControllerMVC" + id);
		ModelAndView m = new ModelAndView("/admin/updateOferta");
		m.addObject("oferta", serviceOferta.selectOferta(id));
		return m;
	}
	
	@RequestMapping(value="admin/ofertas/update", method = { RequestMethod.POST})
	public ModelAndView updateOferta(@ModelAttribute Oferta oferta) {
		log.info("IMPRIMIENDO OFERTA-------" + oferta);
		serviceOferta.updateOfertas(oferta);
		return new ModelAndView("redirect:/admin/ofertas/list");
	}
	
	@GetMapping(value="/admin/ofertas/delete")
	public ModelAndView deleteOferta(@RequestParam Integer id) {
		log.info("ELIMINANDO OFERTA-------ID:" + id);
		serviceOferta.deleteOferta(id);
		return new ModelAndView("redirect:/admin/ofertas/list");
	}
}
