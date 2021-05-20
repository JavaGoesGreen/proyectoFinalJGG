package com.rest.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.spring.dao.ProyectosDao;
import com.rest.spring.model.Cliente;
import com.rest.spring.model.Proyecto;
import com.rest.spring.service.ProyectosServiceImpl;
/**
 * <p><b> Nombre </b> ProyectoFinal REST Test </p>
 * 
 * <p><strong>Descripcion </strong> pruebas unitarias de estructuras Proyectos</p>
 * 
 * @author	Dario Denche
 * 
 * @version	v1
 * 
 * @since	20/05/2021
 */
public class ProyectosControllerTest extends AbstractTest{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Autowired
	ProyectosServiceImpl service;
	
	
	
	//test para comprobar el api GET de listar proyectos --método getProyectos()
	@Test
	public void getProyectosTest() throws Exception {
		String uri = "/proyectos";
		MvcResult mvcResult =  mvc
				.perform(MockMvcRequestBuilders.get(uri)
		        .accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
	
	
	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	String content = mvcResult.getResponse().getContentAsString();
	
	Proyecto[] listaproyecto = super.mapFromJson(content, Proyecto[].class);
	assertTrue(listaproyecto.length > 0);
	
	}
	
	//test para comprobar el api POST de crear proyecto --método addProyecto()
	@Test
	public void addProyectoTest() throws Exception {
		String uri="/proyectos/admin/post";
		
	Proyecto p = new Proyecto (); //añade id siguiente, si es con la bbdd sin tocar, es el 11
	p.setIdproyecto(11);
	p.setProyecto("addProyectoTest");
	String inputJson = super.mapToJson(p);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson))
				.andReturn();
		
		  int status = mvcResult.getResponse().getStatus();
		  assertEquals(200, status);
		  String content = mvcResult.getResponse().getContentAsString();
		  assertEquals(content,inputJson);
		  service.deleteProyecto(p.getIdproyecto());
	}
	
	
	@Test
	public void updateProyecto() throws Exception {
		
		Proyecto p = new Proyecto();
		p.setProyecto("updateProyectoMock");
		//p.setIdproyecto(service.getProyectos().size()+1); 
		String uri = "/proyectos/admin/update/" +service.getProyectos().size()+2 ;
		System.out.println("-----------------------------------------------------" +p.getIdproyecto());
		String inputJson = super.mapToJson(p);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders
				.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Proyecto actualizado" );
		service.deleteProyecto(service.getProyectos().size());
		
	}
	
	
	@Test
	public void deleteProyecto() throws Exception {
	Proyecto p = new Proyecto();
		p.setProyecto("deleteProyecto");
		p.setIdproyecto(0);
		service.addProyectos(p);
		int id = p.getIdproyecto();
		String uri="/proyectos/admin/delete/" + id;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertEquals(content, "Proyecto eliminado");
	}

}
