package com.rest.spring.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Proyecto updateProyectos(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}
	
	/* Ejemplo de un ejercicio de David (sin BBDD)
	@Override
	public Optional<Proyecto> update(Proyecto proyecto) {
		List<Proyecto> listaProyectos = this.getProyectos();
		Proyecto aux = listaProyectos.get(proyecto.getIdproyecto());
		if(aux != null) {
			listaProyectos.put(proyecto.getIdproyecto(), proyecto);
			aux = listaProyectos.get(proyecto.getIdproyecto());
		}
		return  Optional.ofNullable(aux);
	}
	*/
	
	@Override
	public Proyecto getProyectoById(Integer id) {
		List<Proyecto> listaProyectos = this.getProyectos();
		for(Proyecto p:listaProyectos) {
			if(p.getIdproyecto() == id) {
				return p;
			}
		} return null;
	}
}
