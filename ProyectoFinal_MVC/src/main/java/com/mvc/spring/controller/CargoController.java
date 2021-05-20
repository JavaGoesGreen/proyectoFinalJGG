package com.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.spring.service.CargosServiceImpl;

/**
 * <p>
 * <b> Nombre </b> CargoController
 * </p>
 * <p>
 * <strong>Descripcion </strong> endpoints del proyecto MVC para objetos cargo
 * </p>
 * 
 * @author Toni
 * @version v1
 * @since 13/05/2021
 */

@Controller
public class CargoController {

	@Autowired
	CargosServiceImpl serviceC;

	@GetMapping("/cargos")
	public String listaCargos(Model m) {
		m.addAttribute("cargoslista", serviceC.getCargos());
		return "cargos";
	}

}
