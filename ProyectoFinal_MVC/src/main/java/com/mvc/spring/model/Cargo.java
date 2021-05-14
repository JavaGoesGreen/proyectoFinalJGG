package com.mvc.spring.model;

import java.util.List;

public class Cargo {

	private int idcargo;
	private String cargo;

	// Contructors
	public Cargo() {
		super();
	}

	public Cargo(int idcargo, String cargo, List<Equipo> equipo) {
		super();
		this.idcargo = idcargo;
		this.cargo = cargo;
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

	// toString
	@Override
	public String toString() {
		return "Cargos [idcargo=" + idcargo + ", cargo=" + cargo + "]";
	}

}
