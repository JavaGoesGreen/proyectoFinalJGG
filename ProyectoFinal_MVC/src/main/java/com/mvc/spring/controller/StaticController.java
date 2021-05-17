package com.mvc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p><b> Nombre </b> ProyectoController</p>
 * 
 * <p><strong>Descripcion </strong> controlador del proyecto MVC que recibe json</p>
 * 
 * @author	Toni Blanche
 * 
 * @version	v1
 * 
 * @since	13/05/2021
 */

@Controller
public class StaticController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/*@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}*/

	@GetMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
}
