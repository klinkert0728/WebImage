package com.dso.possews.entities;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Remisiones {
	
	// campos de la tabla Remisiones
	
	private int numeroRemision;
    private Date fecha;
    private String idCliente;
    private String codigoOp;
    private int totalRecibido;
    private String refePrenda;
    private String idPrenda;
    private String idMarca;
    private String idConfeccionista;
    private String estado;
   
		
	public int getNumeroRemision() {
		return numeroRemision;
	}

	public void setNumeroRemision(int numeroRemision) {
		this.numeroRemision = numeroRemision;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigoOp() {
		return codigoOp;
	}

	public void setCodigoOp(String codigoOp) {
		this.codigoOp = codigoOp;
	}

	public int getTotalRecibido() {
		return totalRecibido;
	}

	public void setTotalRecibido(int totalRecibido) {
		this.totalRecibido = totalRecibido;
	}

	public String getRefePrenda() {
		return refePrenda;
	}

	public void setRefePrenda(String refePrenda) {
		this.refePrenda = refePrenda;
	}

	public String getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(String prenda) {
		this.idPrenda = prenda;
	}

	public String getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(String marca) {
		this.idMarca = marca;
	}

	public String getIdConfeccionista() {
		return idConfeccionista;
	}

	public void setIdConfeccionista(String idConfeccionista) {
		this.idConfeccionista = idConfeccionista;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Remisiones() {
    }
	
	public Remisiones(int numeroRemision, Date fecha, int total, String codigo) {
		this.numeroRemision = numeroRemision;
		this.fecha = fecha;
		this.totalRecibido = total;
		this.codigoOp = codigo;
    }

	public Remisiones(int numeroRemision, Date fecha, String idCliente,
			String marca, int totalRecibido, String refePrenda, String prenda, 
			String idConfeccionista, String codigoOp, String estado) {
		this.numeroRemision = numeroRemision;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idMarca = marca;
		this.totalRecibido = totalRecibido;
		this.refePrenda = refePrenda;
		this.idPrenda = prenda;
		this.idConfeccionista = idConfeccionista;
		this.codigoOp = codigoOp;
		this.estado = estado;
	}
	
}