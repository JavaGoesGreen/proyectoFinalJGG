package com.mvc.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Cargo;

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
