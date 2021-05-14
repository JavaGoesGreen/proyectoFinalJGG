package com.mvc.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Equipo;

@Service
public class EquipoServiceImpl implements EquipoService{
	
	private final Logger log = LoggerFactory.getLogger(EquipoServiceImpl.class);
	
	@Override
	public Collection<Equipo> getEquipo() {
		log.info("------------------------------Rest Template getEquipo");
		RestTemplate restTemplate = new RestTemplate();
		    Equipo[] equipos = restTemplate.getForObject("http://localhost:5000/equipo", Equipo[].class);
		    List<Equipo> listaEquipos = Arrays.asList(equipos);
		    System.out.println(listaEquipos);
		    return listaEquipos;
	}
	
	@Override
	public void addEquipo(Equipo equipo) {
		log.info("------------------------------Rest Template addEquipo");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/equipo/admin/post", equipo, Equipo.class);
	}
	
	@Override
	public Equipo selectEquipo(Integer id) {
		log.info("------------------------------Rest Template selectEquipo" + id);
		RestTemplate restTemplate = new RestTemplate();
		Equipo equipo = restTemplate.getForObject("http://localhost:5000/equipo/admin/select/"+id, Equipo.class);
	    log.info(""+equipo);
	    return equipo;
	}
	
	@Override
	public void updateEquipo(Equipo equipo) {
		log.info("------------------------------Rest Template updateEquipo");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/equipo/admin/update/"+equipo.getIdpersona(), equipo, Equipo.class);
	}
}
