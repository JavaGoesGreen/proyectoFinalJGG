package com.mvc.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Cliente;

@Service
public class ClientesServiceImpl implements ClientesService{
	
	@Override
	public List<Cliente> getClientes() {
		 RestTemplate restTemplate = new RestTemplate();
		    Cliente[] clientes = restTemplate.getForObject("http://localhost:5000/clientes", Cliente[].class);
		    List<Cliente> listaClientes = Arrays.asList(clientes);
		    return listaClientes;
	}
}
