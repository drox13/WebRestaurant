package edu.uptc.model;

public class Direccion {
	private String calle;
	private String carrera;
	
	public Direccion(String calle, String carrera) {
		this.calle = calle;
		this.carrera = carrera;
	}
	
	@Override
	public String toString() {
		return "calle: " + calle  + " carreara: " + carrera;
	}
}