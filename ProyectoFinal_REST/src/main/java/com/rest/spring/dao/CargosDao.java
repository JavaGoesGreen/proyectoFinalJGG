package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spring.model.Cargo;


public interface CargosDao extends JpaRepository<Cargo,Integer> {

}
