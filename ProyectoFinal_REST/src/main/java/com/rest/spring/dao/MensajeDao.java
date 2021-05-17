package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.spring.model.Mensaje;

@Repository
public interface MensajeDao extends JpaRepository<Mensaje,Integer> {
	
	
}
