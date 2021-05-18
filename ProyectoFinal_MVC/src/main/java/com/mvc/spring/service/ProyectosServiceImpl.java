package com.mvc.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Proyecto;
/**
 * <p><b> Nombre </b> Clase Servicios de Proyecto</p>
 * 
 * <p><strong>Descripcion </strong> Bussines logic de proyectos, recoge formatos JSON y devuelve objetos java</p>
 * 
 * @author	Dario Denche
 * 
 * @version	v1
 * 
 * @since	12/05/2021
 */
@Service
public class ProyectosServiceImpl implements ProyectosService{
	
	private final Logger log = LoggerFactory.getLogger(ProyectosServiceImpl.class);
	
	@Override
	public Collection<Proyecto> getProyectos() {
		log.info("------------------------------Rest Template getProyectos");
		RestTemplate restTemplate = new RestTemplate();
		    Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		    List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		    System.out.println(listaProyectos);
		    return listaProyectos;
	}
	
	@Override
	public void addProyectos(Proyecto proyecto) {
		log.info("------------------------------Rest Template addProyectos");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/proyectos/admin/post", proyecto, Proyecto.class);
	}
	
	@Override
	public Proyecto selectProyecto(Integer id) {
		log.info("------------------------------Rest Template selectProyecto" + id);
		RestTemplate restTemplate = new RestTemplate();
	    Proyecto proyecto = restTemplate.getForObject("http://localhost:5000/proyectos/admin/select/"+id, Proyecto.class);
	    log.info(""+proyecto);
	    return proyecto;
	}
	
	@Override
	public void updateProyectos(Proyecto proyecto) {
		log.info("------------------------------Rest Template updateProyectos");
		 //String url="http://localhost:5000/proyectos/admin/update/"+proyecto.getIdproyecto();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:5000/proyectos/admin/update/"+proyecto.getIdproyecto(), proyecto, Proyecto.class);
	   //HttpEntity<Proyecto> requestEntity = new HttpEntity<Proyecto>(proyecto);
		//HttpEntity<Proyecto> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity,Proyecto.class, proyecto);

		
	}

	@Override
	public void deleteProyecto(Integer id) {
		log.info("------------------------------Rest Template deleteProyectos");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/proyectos/admin/delete/"+id, Proyecto.class);
		
	}
}
