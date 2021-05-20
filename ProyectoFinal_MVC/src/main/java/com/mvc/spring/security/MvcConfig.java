package com.mvc.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * <p><b> Nombre </b> Configuración de MVC</p>
 * <p><strong>Descripcion </strong> Configuración del proyecto MVC para añadir login</p>
 * @author	Toni Blanche y Dario Denche
 * @version	v1
 * @since	18/05/2021
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

}
