package com.mvc.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Proyecto;

@Service
public class ProyectosServiceImpl implements ProyectosService{
	
	@Override
	public Collection<Proyecto> getProyectos() {
		 RestTemplate restTemplate = new RestTemplate();
		    Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		    List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		    System.out.println(listaProyectos);
		    return listaProyectos;
	}
	
	@Override
	public void addProyectos(Proyecto proyecto) {
		System.out.println("ENTRANDO EN RESTTEMPLATE------------------------------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/proyectos/admin/post", proyecto, Proyecto.class);
	}
}
