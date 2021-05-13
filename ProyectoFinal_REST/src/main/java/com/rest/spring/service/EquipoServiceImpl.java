package com.rest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.spring.dao.EquipoDao;
import com.rest.spring.model.Equipo;



public class EquipoServiceImpl {

	@Autowired
	EquipoDao equipoDao;


	public List<Equipo> getEquipo() {

		return equipoDao.findAll();
	}

}
