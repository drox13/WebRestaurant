package edu.uptc.model;

public class Reserva {
	private Cliente cliente;
	private Mesa mesa;
	private String fecha;
	private String hora;
	
	public Reserva() {}

	public Reserva(Cliente cliente, Mesa mesa, String fecha, String hora) {
		this.cliente = cliente;
		this.mesa = mesa;
		this.fecha = fecha;
		this.hora = hora;
	}
}