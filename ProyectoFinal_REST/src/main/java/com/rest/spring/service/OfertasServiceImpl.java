package com.rest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.OfertasDao;
import com.rest.spring.model.Oferta;

@Service
public class OfertasServiceImpl implements OfertasService {

	@Autowired
	OfertasDao ofertaDao;

	public List<Oferta> getOfertas() {
		return ofertaDao.findAll();
	}

	@Override
	public Oferta addOfertas(Oferta oferta) {
		return ofertaDao.save(oferta);
	}

	@Override
	public Oferta updateOfertas(Oferta oferta) {
		return ofertaDao.save(oferta);
	}

	@Override
	public Oferta getOfertaById(Integer id) {
		List<Oferta> listaProyectos = this.getOfertas();
		for (Oferta p : listaProyectos) {
			if (p.getIdoferta() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void deleteOferta(Integer id) {
		ofertaDao.deleteById(id);
	}
}
