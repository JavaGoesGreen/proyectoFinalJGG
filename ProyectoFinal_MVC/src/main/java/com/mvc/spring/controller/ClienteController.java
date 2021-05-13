package com.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mvc.spring.service.ClientesServiceImpl;

/**
 * <p><b> Nombre </b> ClienteController</p>
 * 
 * <p><strong>Descripcion </strong> controlador del proyecto MVC que recibe json</p>
 * 
 * @author	Darío
 * 
 * @version	v1
 * 
 * @since	13/05/2021
 */

@Controller
public class ClienteController {

	@Autowired
	ClientesServiceImpl serviceC;

	@GetMapping("/clientes")
	public String listaClientes(Model m) {
		m.addAttribute("clienteslista", serviceC.getClientes());
		return "proyectos";
	}

}
