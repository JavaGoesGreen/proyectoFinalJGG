package com.rest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.spring.dao.MensajeDao;
import com.rest.spring.model.Mensaje;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	MensajeDao mensajeDao;

	public List<Mensaje> getMensajes() {
		return mensajeDao.findAll();
	}

	@Override
	public Mensaje addMensajes(Mensaje mensaje) {
		return mensajeDao.save(mensaje);
	}
	
}
