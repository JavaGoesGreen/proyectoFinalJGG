package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spring.model.Equipo;

public interface EquipoDao extends JpaRepository<Equipo,Integer> {

}
