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
import com.rest.spring.model.Proyecto;
import com.rest.spring.service.ProyectosServiceImpl;

/**
 * <p>
 * <b> Nombre </b> ProyectoFinal REST Test
 * </p>
 * 
 * <p>
 * <strong>Descripcion </strong> pruebas unitarias de estructuras Proyectos
 * </p>
 * 
 * @author Dario Denche
 * 
 * @version v1
 * 
 * @since 20/05/2021
 */
public class ProyectosControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Autowired
	ProyectosServiceImpl service;

	@Autowired
	ProyectosDao pDao;

	// test para comprobar el api GET de listar proyectos --método getProyectos()
	@Test
	public void getProyectosTest() throws Exception {
		//ruta del endpoint
		String uri = "/proyectos";
		//objeto para configurar prueba mockmvc, con el endpoint dado, explicitando que el objeto de vuelta es JSON y devolviendolo 
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		//guardar en una variable el status al ejecutar el endpoint
		int status = mvcResult.getResponse().getStatus();
		//comprobar que el status del request es el esperado (todo correcto, un 200) y que por lo tanto funciona bien el endpoint
		assertEquals(200, status);
		
		//guardar en una variable el contenido que devuelve el mock
		String content = mvcResult.getResponse().getContentAsString();
		//recoger el objeto json y convertirlo a objeto java
		Proyecto[] listaproyecto = super.mapFromJson(content, Proyecto[].class);
		assertTrue(listaproyecto.length > 0);

	}

	// test para comprobar el api POST de crear proyecto --método addProyecto()
	@Test
	public void addProyectoTest() throws Exception {
		String uri = "/proyectos/admin/post";

		Proyecto p = new Proyecto(); // añade id siguiente
		p.setProyecto("addProyectoTest117");
		String inputJson = super.mapToJson(p);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Proyecto outputJson = super.mapFromJson(content, Proyecto.class);

		p.setIdproyecto(outputJson.getIdproyecto());
		assertEquals(p.getIdproyecto(), outputJson.getIdproyecto());
		service.deleteProyecto(p.getIdproyecto());

	}

	@Test
	public void updateProyecto() throws Exception {
		// suponemos que bbdd no esta completamente vacia
		int id = 0;
		do {
			id++;
		} while (service.getProyectoById(id) == null);
		String uri = "/proyectos/admin/update/" + id;
		String inputJson = super.mapToJson(service.getProyectoById(id));
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Proyecto actualizado");

	}

	@Test
	public void deleteProyecto() throws Exception {
		Proyecto p = new Proyecto();
		p.setProyecto("deleteProyecto");

		service.addProyectos(p);
		int id = p.getIdproyecto();
		String uri = "/proyectos/admin/delete/" + id;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Proyecto eliminado");

	}

}
