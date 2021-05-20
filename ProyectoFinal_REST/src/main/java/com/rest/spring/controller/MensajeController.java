package com.rest.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.spring.model.Mensaje;
import com.rest.spring.service.MensajeServiceImpl;

@RestController
public class MensajeController {

	private final Logger log = LoggerFactory.getLogger(MensajeController.class);

	@Autowired
	MensajeServiceImpl service;

	@GetMapping("/mensaje")
	public List<Mensaje> getMensaje() {
		log.info("----Entrando en método listar mensajes REST --------");
		return service.getMensajes();
	}

	@PostMapping("/mensaje/admin/post")
	public Mensaje addMensaje(@RequestBody Mensaje mensaje) {
		log.info("---- Entrando en método guardar mensaje REST ------- " + mensaje + " -------");
		Mensaje p = service.addMensajes(mensaje);
		log.info("Mensaje a añadir: " + p);
		return p;
	}

	@GetMapping("/mensaje/admin/select/{id}")
	public Mensaje selectMensaje(@PathVariable Integer id) {
		log.info("---- Entrando en método seleccionar mensaje " + id + " REST -------");
		return service.getMensajeById(id);
	}

	@PutMapping("/mensaje/admin/update/{mensaje.getIdmensaje()}")
	public Mensaje updateMensaje(@RequestBody Mensaje mensaje) {
		log.info("---- Entrando en método modificar mensaje REST ------- " + mensaje.getIdmensaje() + " -------");
		return service.updateMensajes(mensaje);
	}

	@DeleteMapping("/mensaje/admin/delete/{id}")
	public void deleteMensaje(@PathVariable Integer id) {
		service.deleteMensaje(id);
	}
}
