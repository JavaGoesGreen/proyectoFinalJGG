package com.rest.spring;

import java.io.IOException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= ProyectoFinalRestApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {
	
	//atributo MockMvc para realizas las configuraciones de cara a pruebas unitarias de controllers
	protected MockMvc mvc;
	//atributo para realizar la configuración del contexto de la app web
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//se configura la construcción del atributo mock con el atributo contexto de app web
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	
	//se crea un método para pasar información de un parametro objeto java a JSON
	// por un "mapeador de objetos"
	protected String mapToJson (Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.writeValueAsString(obj);
	}
	//metodo para recibir un json como parametro  y transformarlo a un objeto java a través de un método de lectura
	//del objeto tipo ObjectMapper
	protected <T> T mapFromJson(String json, Class<T> clazz)
		      throws JsonParseException, JsonMappingException, IOException {
		  ObjectMapper objectMapper = new ObjectMapper();
		 
	      return objectMapper.readValue(json, clazz);
	}
}

