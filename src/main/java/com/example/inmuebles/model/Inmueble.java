package com.example.inmuebles.model;

public class Inmueble {
	private int cod_inmueble;
	private String tipoConstruccion;
	private String ciudad;
	private String direccion;
	private int precio;

	public Inmueble(int cod_inmueble,String tipoConstruccion,String ciudad,String direccion,int precio) {
		this.cod_inmueble = cod_inmueble;
		this.tipoConstruccion = tipoConstruccion;
		this.ciudad = ciudad;
		this.direccion = direccion;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return this.cod_inmueble+", "+this.tipoConstruccion+", "+this.ciudad+", "+this.direccion+ '\'' +
				", precio: " + this.precio;
	}
}