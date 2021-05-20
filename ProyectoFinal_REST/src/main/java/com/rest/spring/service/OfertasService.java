package com.rest.spring.service;

import java.util.List;

import com.rest.spring.model.Oferta;

public interface OfertasService {

	public List<Oferta> getOfertas();

	public Oferta addOfertas(Oferta oferta);

	public Oferta updateOfertas(Oferta oferta);

	public Oferta getOfertaById(Integer id);

	public void deleteOferta(Integer id);

}
