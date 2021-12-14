package edu.uptc.model;

import java.util.ArrayList;

public class SucursalManager {
	ArrayList<Sucursal> listSucursales = new ArrayList<Sucursal>();
	ArrayList<Mesa> listMesas = new ArrayList<Mesa>();

	public SucursalManager() {
		listMesas.add(new Mesa(1, 23));
		listMesas.add(new Mesa(5, 23));
		
		listSucursales.add(new Sucursal("Tunja", new Direccion("79", "20"), new ArrayList<Reserva>(), listMesas));
		listSucursales.add(new Sucursal("Sogamoso", new Direccion("21", "12"), new ArrayList<Reserva>(), listMesas));
		listSucursales.add(new Sucursal("Duitama", new Direccion("11", "11"), new ArrayList<Reserva>(), listMesas));
		listSucursales.add(new Sucursal("Tunja", new Direccion("21", "50"), new ArrayList<Reserva>(), listMesas));

	}
	
	
	public ArrayList<Sucursal> getListSucursales() {
		return listSucursales;
	}
	
	
	
	public void name() {
		System.out.println("hola");
	}
	
	
}
