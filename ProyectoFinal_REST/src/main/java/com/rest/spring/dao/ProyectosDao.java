package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.model.Proyecto;

@Repository
public interface ProyectosDao extends JpaRepository<Proyecto,Integer> {
	
	
}
