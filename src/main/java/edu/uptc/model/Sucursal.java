package edu.uptc.model;

import java.util.ArrayList;

public class Sucursal {
	private String ciudad;
	private Direccion direccion;
	private ArrayList<Reserva> lisReservas;
	private ArrayList<Mesa> listMesas;
	
	public Sucursal(String ciudad, Direccion direccion, ArrayList<Reserva> lisReservas,
			ArrayList<Mesa> listMesas) {
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.lisReservas = lisReservas;
		this.listMesas = listMesas;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public ArrayList<Mesa> getListMesas() {
		return listMesas;
	}
}