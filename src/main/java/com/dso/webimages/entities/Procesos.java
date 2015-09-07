package com.dso.webimages.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Procesos {
	
	private int numeroRemision;
	private String idProceso;
	private String idTipo;
	private String idTipo2;
	private String dscp;
	
	public int getNumeroRemision() {
		return numeroRemision;
	}
	public void setNumeroRemision(int numeroRemision) {
		this.numeroRemision = numeroRemision;
	}
	public String getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public String getIdTipo2() {
		return idTipo2;
	}
	public void setIdTipo2(String idTipo2) {
		this.idTipo2 = idTipo2;
	}
	public String getDscp() {
		return dscp;
	}
	public void setDscp(String dscp) {
		this.dscp = dscp;
	}
	
	public Procesos(){
		
	}
	public Procesos(int numeroRemision, String idProceso, String idTipo, String idTipo2,
			String dscp) {
		super();
		this.numeroRemision = numeroRemision;
		this.idProceso = idProceso;
		this.idTipo = idTipo;
		this.idTipo2 = idTipo2;
		this.dscp = dscp;
	}
	

}
