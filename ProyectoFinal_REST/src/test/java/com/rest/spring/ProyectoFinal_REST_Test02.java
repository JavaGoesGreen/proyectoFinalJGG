package com.rest.spring;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import com.rest.spring.service.ProyectosServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProyectoFinal_REST_Test02 {
	
	 @LocalServerPort
	    private int port;
		
		/*@Autowired
		//private TestRestTemplate restTemplate;
		
		//@Autowired
		//private ProyectosServiceImpl service;
		
		//comprobando que método en controller te devuelve un objeto service (en este caso service.getProyectos())
		@Test
		void returnController1() {
			 assertThat(restTemplate.getForObject("http://localhost:" + port + "/", ProyectosServiceImpl.class)).;
		
		*/
					 
		
			
			 
			
		}


