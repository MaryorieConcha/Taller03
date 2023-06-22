package com.example.inmuebles.model;

public class Inmueble {
	private int cod_inmueble;
	private String tipoConstruccion;
	private String ubicacionGeografica;
	private int precio;

	public Inmueble(int cod_inmueble, String tipoConstruccion, String ubicacionGeografica, int precio) {
		this.cod_inmueble = cod_inmueble;
		this.tipoConstruccion = tipoConstruccion;
		this.ubicacionGeografica = ubicacionGeografica;
		this.precio = precio;
	}

	public int getCod_inmueble() {
		return cod_inmueble;
	}

	public void setCod_inmueble(int cod_inmueble) {
		this.cod_inmueble = cod_inmueble;
	}

	public String getTipoConstruccion() {
		return tipoConstruccion;
	}

	public void setTipoConstruccion(String tipoConstruccion) {
		this.tipoConstruccion = tipoConstruccion;
	}

	public String getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return this.cod_inmueble+", "+this.tipoConstruccion+", "+this.ubicacionGeografica + '\'' +
				", precio: " + this.precio;
	}
}