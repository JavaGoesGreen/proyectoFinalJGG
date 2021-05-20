package com.rest.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.spring.controller.CargosController;
import com.rest.spring.controller.ClientesController;
import com.rest.spring.controller.EquipoController;
import com.rest.spring.controller.MensajeController;
import com.rest.spring.controller.OfertasController;
import com.rest.spring.controller.ProyectosController;
import com.rest.spring.dao.CargosDao;
import com.rest.spring.dao.ClientesDao;
import com.rest.spring.dao.EquipoDao;
import com.rest.spring.dao.MensajeDao;
import com.rest.spring.dao.OfertasDao;
import com.rest.spring.dao.ProyectosDao;
import com.rest.spring.service.CargosService;
import com.rest.spring.service.CargosServiceImpl;
import com.rest.spring.service.ClientesService;
import com.rest.spring.service.ClientesServiceImpl;
import com.rest.spring.service.EquipoService;
import com.rest.spring.service.EquipoServiceImpl;
import com.rest.spring.service.MensajeService;
import com.rest.spring.service.MensajeServiceImpl;
import com.rest.spring.service.OfertasService;
import com.rest.spring.service.OfertasServiceImpl;
import com.rest.spring.service.ProyectosService;
import com.rest.spring.service.ProyectosServiceImpl;



@SpringBootTest
public class ProyectoFinal_REST_Estructura {
	
	@Autowired
	private ProyectosController controllerPro;
	@Autowired
	private ProyectosDao daoPro;
	@Autowired
	private ProyectosService servicePro;
	@Autowired
	private ProyectosServiceImpl serviceImplPro;

	
	@Autowired
	private EquipoController controllerTeam;
	@Autowired
	private EquipoDao daoTeam;
	@Autowired
	private EquipoService serviceTeam;
	@Autowired
	private EquipoServiceImpl serviceImplTeam;

	
	@Autowired
	private ClientesController controllerCli;
	@Autowired
	private ClientesDao daoCli;
	@Autowired
	private ClientesService serviceCli;
	@Autowired
	private ClientesServiceImpl serviceImplCli;
	
	
	@Autowired
	private CargosController controllerCar;
	@Autowired
	private CargosDao daoCar;
	@Autowired
	private CargosService serviceCar;
	@Autowired
	private CargosServiceImpl serviceImplCar;

	
	@Autowired
	private MensajeController controllerSms;
	@Autowired
	private MensajeDao daoSms;
	@Autowired
	private MensajeService serviceSms;
	@Autowired
	private MensajeServiceImpl serviceImplSms;

	
	@Autowired
	private OfertasController controllerOf;
	@Autowired
	private OfertasDao daoOf;
	@Autowired
	private OfertasService serviceOf;
	@Autowired
	private OfertasServiceImpl serviceImplOf;
	
	
	//asegurando que existe repositorio de datos (dao)
	@Test
	void testDao() {
		assertThat(daoPro).isNotNull();
		assertThat(daoCli).isNotNull();
		assertThat(daoSms).isNotNull();
		assertThat(daoCar).isNotNull();
		assertThat(daoTeam).isNotNull();
		assertThat(daoOf).isNotNull();
	}

	
	//asegurando que existe interface servicios (services)
	@Test
	void testService() {
		assertThat(servicePro).isNotNull();
		assertThat(serviceCli).isNotNull();
		assertThat(serviceSms).isNotNull();
		assertThat(serviceOf).isNotNull();
		assertThat(serviceTeam).isNotNull();
		assertThat(serviceCar).isNotNull();
	}
	
	//asegurando que existe clase servicios (services)
	@Test
	void testServiceImpl() {
		assertThat(serviceImplPro).isNotNull();
		assertThat(serviceImplCli).isNotNull();
		assertThat(serviceImplTeam).isNotNull();
		assertThat(serviceImplOf).isNotNull();
		assertThat(serviceImplCar).isNotNull();
		assertThat(serviceImplSms).isNotNull();
	}
	
	//asegurando que controller no es nulo
		@Test
		void testController() {
			assertThat(controllerPro).isNotNull();
			assertThat(controllerTeam).isNotNull();
			assertThat(controllerCli).isNotNull();
			assertThat(controllerSms).isNotNull();
			assertThat(controllerOf).isNotNull();
			assertThat(controllerCar).isNotNull();
		}
	
	
}
