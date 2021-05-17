package com.mvc.spring.controller;

import java.time.LocalDate;
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
import org.springframework.web.servlet.ModelAndView;
import com.mvc.spring.model.Mensaje;
import com.mvc.spring.service.MensajesServiceImpl;
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
public class MensajeController {
	
	private final Logger log = LoggerFactory.getLogger(MensajeController.class);
	
	@Autowired
	MensajesServiceImpl service;

	@GetMapping("mensajes/admin/list")
	public String listaProyectosAdmin(Model m) {
		List<Mensaje> mensajes = new ArrayList<>();
		mensajes.addAll(service.getMensajes());
		m.addAttribute("mensajeslista", mensajes);
		return "admin/mensajesadmin";
	}
	
	@GetMapping("contacto")
	public ModelAndView newContacto() {
		ModelAndView m = new ModelAndView("/contacto");
		m.addObject("mensaje", new Mensaje());
		return m;
	}
	
	@GetMapping("mensajes/admin/add")
	public ModelAndView newMensaje() {
		ModelAndView m = new ModelAndView("/admin/addMensaje");
		m.addObject("mensaje", new Mensaje());
		return m;
	}

	@PostMapping("mensajes/post")
	public ModelAndView addmensaje(@ModelAttribute Mensaje mensaje) {
		LocalDate l = LocalDate.now();
		mensaje.setFecha(l.toString());
		log.info("IMPRIMIENDO MENSAJE-------" + mensaje);
		service.addMensajes(mensaje);
		return new ModelAndView("redirect:/contacto");
	}

}
