package com.mvc.spring.service;

import java.util.Collection;
import com.mvc.spring.model.Oferta;
/**
 * <p><b> Nombre </b>Interface Servicios de Proyecto</p>
 * 
 * <p><strong>Descripcion </strong> Interface con métodos que implementa clase Servicios de proyecto</p>
 * 
 * @author	Yelder Da Silva
 * 
 * @version	v1
 * 
 * @since	19/05/2021
 */
public interface OfertasService {
  
	public Collection<Oferta>getOfertas();
	
	public void addOfertas(Oferta oferta);
	
	public Oferta selectOferta(Integer id);
	
	public void updateOfertas(Oferta oferta);
	
	public void deleteOferta(Integer id);
}
