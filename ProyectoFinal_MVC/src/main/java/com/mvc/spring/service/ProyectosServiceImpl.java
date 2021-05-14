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
		System.out.println("------------------------------Rest Template getProyectos");
		 RestTemplate restTemplate = new RestTemplate();
		    Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		    List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		    System.out.println(listaProyectos);
		    return listaProyectos;
	}
	
	@Override
	public void addProyectos(Proyecto proyecto) {
		System.out.println("------------------------------Rest Template addProyectos");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/proyectos/admin/post", proyecto, Proyecto.class);
	}
	
	@Override
	public Proyecto selectProyecto(Integer id) {
		System.out.println("------------------------------Rest Template selectProyecto" + id);
		RestTemplate restTemplate = new RestTemplate();
	    Proyecto proyecto = restTemplate.getForObject("http://localhost:5000/proyectos/admin/select/"+id, Proyecto.class);
	    System.out.println(proyecto);
	    return proyecto;
	}
}
