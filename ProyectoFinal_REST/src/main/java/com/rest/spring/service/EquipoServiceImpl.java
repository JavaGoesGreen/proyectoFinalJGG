package com.rest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.EquipoDao;
import com.rest.spring.model.Equipo;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	EquipoDao equipoDao;

	public List<Equipo> getEquipo() {
		return equipoDao.findAll();
	}

	@Override
	public Equipo addEquipo(Equipo equipo) {
		return equipoDao.save(equipo);
	}

	@Override
	public Equipo updateEquipos(Equipo equipo) {
		
		return equipoDao.save(equipo);
	}

	@Override
	public Equipo getEquipoById(Integer id) {
		List<Equipo> listaEquipos = this.getEquipo();
		for(Equipo e:listaEquipos) {
			if(e.getIdpersona() == id) {
				return e;
			}
		} return null;
	}

	@Override
	public void deleteEquipo(Integer id) {
			
		equipoDao.deleteById(id);
		
		
	}

}
