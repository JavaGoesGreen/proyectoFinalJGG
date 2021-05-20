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

import com.rest.spring.model.Oferta;
import com.rest.spring.service.OfertasServiceImpl;

@RestController
public class OfertasController {

	private final Logger log = LoggerFactory.getLogger(OfertasController.class);

	@Autowired
	OfertasServiceImpl service;

	@GetMapping("/ofertas")
	public List<Oferta> getOfertas() {
		log.info("----Entrando en método listar proyectos REST --------");
		return service.getOfertas();
	}

	@PostMapping("/ofertas/admin/post")
	public Oferta addProyecto(@RequestBody Oferta oferta) {
		log.info("---- Entrando en método guardar oferta REST ------- " + oferta.getIdoferta() + " -------");
		Oferta p = service.addOfertas(oferta);
		log.info("Proyecto a añadir: " + p);
		return p;
	}

	@GetMapping("/ofertas/admin/select/{id}")
	public Oferta selectProyecto(@PathVariable Integer id) {
		log.info("---- Entrando en método seleccionar oferta " + id + " REST -------");
		return service.getOfertaById(id);
	}

	@PutMapping("/ofertas/admin/update/{oferta.getIdoferta()}")
	public Oferta updateProyecto(@RequestBody Oferta oferta) {
		log.info("---- Entrando en método modificar oferta REST ------- " + oferta.getIdoferta() + " -------");
		return service.updateOfertas(oferta);
	}

	@DeleteMapping("/ofertas/admin/delete/{id}")
	public void deleteProyecto(@PathVariable Integer id) {
		service.deleteOferta(id);
	}
}
