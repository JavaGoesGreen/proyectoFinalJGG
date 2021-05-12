package com.rest.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.spring.dao.ProyectosDao;
import com.rest.spring.model.Proyecto;

@Service
public class ProyectosServiceImpl implements ProyectosService {

	@Autowired
	ProyectosDao proyectoDao;


	public List<Proyecto> getProyectos() {

		return proyectoDao.findAll();
	}


	@Override
	public Proyecto addProyectos(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
		
	}
	
}
