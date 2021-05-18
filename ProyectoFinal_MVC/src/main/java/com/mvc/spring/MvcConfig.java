package com.mvc.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/contacto").setViewName("contacto");
		registry.addViewController("/admin").setViewName("admin/admin");
		registry.addViewController("proyectos").setViewName("proyectos");
		registry.addViewController("proyectos/admin/list").setViewName("admin/proyectosadmin");
		registry.addViewController("proyectos/admin/add").setViewName("/admin/addProyecto");
		registry.addViewController("proyectos/admin/post").setViewName("redirect:/proyectos/admin/list");
		registry.addViewController("proyectos/admin/select").setViewName("/admin/updateProyecto");
		registry.addViewController("proyectos/detalle").setViewName("/proyectodetalle");
		registry.addViewController("proyectos/empresa").setViewName("proyectos");
		registry.addViewController("proyectos/admin/update").setViewName("redirect:/proyectos/admin/list");
		registry.addViewController("/proyectos/admin/delete").setViewName("redirect:/proyectos/admin/list");
		
		registry.addViewController("/equipo").setViewName("equipo");
		registry.addViewController("/equipo/admin/list").setViewName("admin/equipoadmin");
		registry.addViewController("equipo/admin/add").setViewName("/admin/addEquipo");
		registry.addViewController("equipo/admin/post").setViewName("redirect:/equipo/admin/list");
		registry.addViewController("equipo/admin/select").setViewName("/admin/updateEquipo");
		registry.addViewController("equipo/admin/update").setViewName("redirect:/equipo/admin/list");
		registry.addViewController("/equipo/admin/delete").setViewName("redirect:/equipo/admin/list");
		
		registry.addViewController("/listaclientes").setViewName("clientes");
		
		registry.addViewController("/cargos").setViewName("cargos");
		registry.addViewController("/login").setViewName("login");
	}

}
