package com.rest.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcargo")
	private int idcargo;
	private String cargo;

	@OneToMany
	private List<Equipo> equipo;

	// Contructors
	public Cargo() {
		super();
	}

	public Cargo(int idcargo, String cargo, List<Equipo> equipo) {
		super();
		this.idcargo = idcargo;
		this.cargo = cargo;
		this.equipo = equipo;
	}

	// Getter and setters
	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	// toString
	@Override
	public String toString() {
		return "Cargos [idcargo=" + idcargo + ", cargo=" + cargo + ", equipo=" + equipo + "]";
	}

}
