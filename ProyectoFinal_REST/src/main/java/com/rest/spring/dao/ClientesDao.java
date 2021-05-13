package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spring.model.Cliente;


public interface ClientesDao extends JpaRepository<Cliente,Integer> {

}
