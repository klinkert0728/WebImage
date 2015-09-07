package com.dso.webimages.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clients {

	private String idTercero;
	private String cliente;
	private String marca;
	public String getIdTercero() {
		return idTercero;
	}
	public void setIdTercero(String idTercero) {
		this.idTercero = idTercero;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Clients(){
		
	}
	
	public Clients(String idTercero, String cliente, String marca) {
		super();
		this.idTercero = idTercero;
		this.cliente = cliente;
		this.marca = marca;
	}
	
	
}
