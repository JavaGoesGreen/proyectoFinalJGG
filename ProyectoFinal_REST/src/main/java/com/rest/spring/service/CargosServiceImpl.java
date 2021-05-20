package com.rest.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.CargosDao;
import com.rest.spring.model.Cargo;

@Service
public class CargosServiceImpl implements CargosService {

	@Autowired
	CargosDao cargosDao;

	public List<Cargo> getCargos() {

		return cargosDao.findAll();
	}

	@Override
	public Cargo addCargo(Cargo cargo) {
		return cargosDao.save(cargo);

	}

}
