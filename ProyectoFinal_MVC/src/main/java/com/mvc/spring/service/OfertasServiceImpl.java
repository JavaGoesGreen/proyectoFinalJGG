package com.mvc.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Oferta;
/**
 * <p><b> Nombre </b> Clase Servicios de Proyecto</p>
 * 
 * <p><strong>Descripcion </strong> Bussines logic de proyectos, recoge formatos JSON y devuelve objetos java</p>
 * 
 * @author	Dario Denche
 * 
 * @version	v1
 * 
 * @since	19/05/2021
 */
@Service
public class OfertasServiceImpl implements OfertasService{
	
	private final Logger log = LoggerFactory.getLogger(OfertasServiceImpl.class);
	
	@Override
	public Collection<Oferta> getOfertas() {
		log.info("------------------------------Rest Template getOfertas");
		RestTemplate restTemplate = new RestTemplate();
		Oferta[] ofertas = restTemplate.getForObject("http://localhost:5000/ofertas", Oferta[].class);
		    List<Oferta> listaOfertas = Arrays.asList(ofertas);
		    System.out.println(listaOfertas);
		    return listaOfertas;
	}
	
	@Override
	public void addOfertas(Oferta oferta) {
		log.info("------------------------------Rest Template addOfertas");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:5000/ofertas/admin/post", oferta, Oferta.class);
	}
	
	@Override
	public Oferta selectOferta(Integer id) {
		log.info("------------------------------Rest Template selectOferta" + id);
		RestTemplate restTemplate = new RestTemplate();
		Oferta oferta = restTemplate.getForObject("http://localhost:5000/ofertas/admin/select/"+id, Oferta.class);
	    log.info(""+oferta);
	    return oferta;
	}
	
	@Override
	public void updateOfertas(Oferta oferta) {
		log.info("------------------------------Rest Template updateOfertas");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:5000/ofertas/admin/update/"+oferta.getIdoferta(), oferta, Oferta.class);
	   	}

	@Override
	public void deleteOferta(Integer id) {
		log.info("------------------------------Rest Template deleteOfertas");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/ofertas/admin/delete/"+id, Oferta.class);
		
	}
}
