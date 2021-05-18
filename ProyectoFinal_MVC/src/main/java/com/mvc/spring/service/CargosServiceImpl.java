package com.mvc.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Cargo;
/**
 * <p><b> Nombre </b> Clase Servicios de Cargo</p>
 * 
 * <p><strong>Descripcion </strong> Bussines logic de cargos, recoge formatos JSON y devuelve objetos java</p>
 * 
 * @author	Antonia Hidalgo
 * 
 * @version	v1
 * 
 * @since	15/05/2021
 */
@Service
public class CargosServiceImpl implements CargosService{
	
	@Override
	public List<Cargo> getCargos() {
		 RestTemplate restTemplate = new RestTemplate();
		    Cargo[] cargos = restTemplate.getForObject("http://localhost:5000/cargos", Cargo[].class);
		    List<Cargo> listaCargos = Arrays.asList(cargos);
		    return listaCargos;
	}
}
