package com.rest.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.ClientesDao;
import com.rest.spring.model.Cliente;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	ClientesDao clienteDao;

	public List<Cliente> getClientes() {

		return clienteDao.findAll();
	}

	@Override
	public Cliente addCliente(Cliente cliente) {
		return clienteDao.save(cliente);

	}

}
