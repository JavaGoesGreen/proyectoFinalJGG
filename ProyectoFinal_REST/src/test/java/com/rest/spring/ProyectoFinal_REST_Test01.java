package com.rest.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.spring.controller.ProyectosController;
import com.rest.spring.dao.ProyectosDao;
import com.rest.spring.model.Proyecto;
import com.rest.spring.service.ProyectosService;
import com.rest.spring.service.ProyectosServiceImpl;


/**
 * <p><b> Nombre </b> ProyectoFinal REST Test </p>
 * 
 * <p><strong>Descripcion </strong> pruebas unitarias de estructuras Proyectos</p>
 * 
 * @author	Yelder Da Silva
 * 
 * @version	v1
 * 
 * @since	13/05/2021
 */

@SpringBootTest
public class ProyectoFinal_REST_Test01 {
	
	
	@Autowired
	private ProyectosController controller;
	
	@Autowired
	private ProyectosDao dao1;
	
	@Autowired
	private ProyectosService service1;
	
	@Autowired
	private ProyectosServiceImpl serviceImpl1;
	
	@Autowired
	private Proyecto proyecto;
	
	//asegurando que controller no es nulo
	@Test
	void testController() {
		assertThat(controller).isNotNull();
	}
	
	
	//asegurando que existe repositorio de datos (dao)
	@Test
	void testDaoProyecto() {
		assertThat(dao1).isNotNull();
	}
	
	//asegurando que existe interface servicios proyecto (services)
	@Test
	void testServiceProyecto() {
		assertThat(service1).isNotNull();
	}
	
	//asegurando que existe clase servicios proyecto (services)
	@Test
	void testServiceImpl() {
		assertThat(serviceImpl1).isNotNull();
	}
	
	//asegurando que existe clase de entidad proyecto (model)
	@Test
	void testClassProyecto() {
		assertThat(proyecto).isNotNull();
	}

}
