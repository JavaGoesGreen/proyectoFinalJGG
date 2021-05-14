package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.model.Equipo;

@Repository
public interface EquipoDao extends JpaRepository<Equipo,Integer> {

}
