package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.model.Oferta;

@Repository
public interface OfertasDao extends JpaRepository<Oferta,Integer> {
	
	
}
