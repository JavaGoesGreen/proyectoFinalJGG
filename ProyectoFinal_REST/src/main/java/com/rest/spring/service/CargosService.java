package com.rest.spring.service;

import java.util.List;

import com.rest.spring.model.Cargo;



public interface CargosService {

	public List<Cargo> getCargos();
	
	public Cargo addCargo(Cargo cargo);
}
