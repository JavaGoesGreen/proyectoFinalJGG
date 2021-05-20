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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.spring.model.Mensaje;
import com.mvc.spring.service.MensajesServiceImpl;

/**
 * <p>
 * <b> Nombre </b> MensajeController
 * </p>
 * 
 * <p>
 * <strong>Descripcion </strong> endpoints del proyecto MVC para objetos mensaje
 * </p>
 * 
 * @author Toni Blanche
 * 
 * @version v1
 * 
 * @since 13/05/2021
 */

@Controller
public class MensajeController {

	private final Logger log = LoggerFactory.getLogger(MensajeController.class);

	@Autowired
	MensajesServiceImpl service;

	// --------------------------------------------------------------------
	// FRONT OFFICE

	@GetMapping("contacto")
	public ModelAndView newContacto(String alert) {
		ModelAndView m = new ModelAndView("/contacto");
		m.addObject("mensaje", new Mensaje());
		m.addObject("alert", alert);
		return m;
	}

	@PostMapping("mensajes/post")
	public ModelAndView addmensaje(@ModelAttribute Mensaje mensaje) {
		LocalDate l = LocalDate.now();
		mensaje.setFecha(l.toString());
		log.info("IMPRIMIENDO MENSAJE-------" + mensaje);

		List<Mensaje> mensajesAntes = new ArrayList<>();
		mensajesAntes.addAll(service.getMensajes());

		service.addMensajes(mensaje);

		List<Mensaje> mensajesDespues = new ArrayList<>();
		mensajesDespues.addAll(service.getMensajes());
		String alert;
		if (mensajesAntes.size() == mensajesDespues.size()) {
			alert = "Ha ocurrido un error. Mensaje no enviado";

		} else {
			alert = "Mensaje enviado correctamente";
		}

		ModelAndView m = new ModelAndView("redirect:/contacto");
		m.addObject("alert", alert);
		return m;
	}

	// --------------------------------------------------------------------
	// BACK OFFICE

	@GetMapping("admin/mensajes/list")
	public String listaProyectosAdmin(Model m) {
		List<Mensaje> mensajes = new ArrayList<>();
		mensajes.addAll(service.getMensajes());
		m.addAttribute("mensajeslista", mensajes);
		return "admin/mensajesadmin";
	}

	@PostMapping("admin/mensajes/post")
	public ModelAndView addMensaje(@ModelAttribute Mensaje mensaje) {
		log.info("IMPRIMIENDO MENSAJE-------" + mensaje);
		service.addMensajes(mensaje);
		return new ModelAndView("redirect:/admin/mensajes/list");
	}

	@GetMapping("admin/mensajes/select")
	public ModelAndView selectMensaje(@RequestParam Integer id) {
		log.info("--------------------------------------MensajeControllerMVC" + id);
		ModelAndView m = new ModelAndView("/admin/responderMensaje");
		m.addObject("mensaje", service.selectMensaje(id));
		return m;
	}

	@RequestMapping(value = "admin/mensajes/update", method = { RequestMethod.POST })
	public ModelAndView updateMensaje(@ModelAttribute Mensaje mensaje) {
		log.info("IMPRIMIENDO PROYECTO-------" + mensaje);
		service.updateMensajes(mensaje);
		return new ModelAndView("redirect:/admin/mensajes/list");
	}

	@GetMapping(value = "/admin/mensajes/delete")
	public ModelAndView deleteMensaje(@RequestParam Integer id) {
		log.info("ELIMINANDO PROYECTO-------ID:" + id);
		service.deleteMensaje(id);
		return new ModelAndView("redirect:/admin/mensajes/list");
	}

}
