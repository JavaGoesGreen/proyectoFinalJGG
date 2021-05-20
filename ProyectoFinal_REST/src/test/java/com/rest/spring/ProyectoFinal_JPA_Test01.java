package com.rest.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rest.spring.dao.CargosDao;
import com.rest.spring.dao.ClientesDao;
import com.rest.spring.dao.EquipoDao;
import com.rest.spring.dao.MensajeDao;
import com.rest.spring.dao.ProyectosDao;
import com.rest.spring.model.Cargo;
import com.rest.spring.model.Cliente;
import com.rest.spring.model.Equipo;
import com.rest.spring.model.Mensaje;
import com.rest.spring.model.Proyecto;

@DataJpaTest
public class ProyectoFinal_JPA_Test01 {
	
	@Autowired
	private ProyectosDao proyectosDao;
	
	@Autowired
	private ClientesDao clientesDao;
	
	@Autowired
	private EquipoDao equipoDao;
	

	@Autowired
	private MensajeDao mensajeDao;
	

	@Autowired
	private CargosDao cargosDao;
	
	@Test
	public void testCreateProyecto() {
		Proyecto proyecto= new Proyecto(1,"GreenProyecto","22/02/2021","Un proyecto Green","Es un proyecto muy green","es una imagen");
		assertNotNull(proyecto);
		assertTrue(proyecto.getIdproyecto()>0);
		
	}
	
	@Test 
	public void testCreateCliente() {
		Cliente cliente= new Cliente(1,"Tesla","gsag","Elon Musk");
		assertNotNull(cliente);
		assertTrue(cliente.getIdcliente()>0);
		
	}
	
	@Test 
	public void testCreateEquipo() {
		Equipo equipo= new Equipo(1,"Luisa","Rodriguez","Diseñadora","/imagenes/luisa");
		assertNotNull(equipo);
		assertTrue(equipo.getIdpersona()>0);	
	}
	
	@Test 
	public void testCreateMensaje() {
		Mensaje mensaje= new Mensaje(1,"Luisa","luisa@hotmail.com","20/04/2021","saludo", "hola que tal", "bien y tu");
		assertNotNull(mensaje);
		assertTrue(mensaje.getIdmensaje()>0);	
	}
	
	@Test 
	public void testCreateCargo() {
		Cargo cargo= new Cargo(7,"Seguridad");
		assertNotNull(cargo);
		assertTrue(cargo.getIdcargo()>0);	
	}


}
