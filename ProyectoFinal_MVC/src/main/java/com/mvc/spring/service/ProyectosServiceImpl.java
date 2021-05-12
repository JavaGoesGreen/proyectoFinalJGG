package com.mvc.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Proyecto;

@Service
public class ProyectosServiceImpl implements ProyectosService{
	
	@Override
	public List<Proyecto> getProyectos() {
		 RestTemplate restTemplate = new RestTemplate();
		    Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		    List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		    return listaProyectos;
	}
	
	@Override
	public void addProyectos(Proyecto proyecto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/proyectos", proyecto, Proyecto[].class);
	}
}
