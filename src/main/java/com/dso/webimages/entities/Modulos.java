package com.dso.webimages.entities;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Modulos {

	//private String idGrupo;
    private String idModulo;
    private String modulo;
    private String ident;
    

	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	
	public Modulos() {
	}
	
	public Modulos(String idModulo, String modulo, String ident) {
		this.idModulo = idModulo;
		this.modulo = modulo;
		this.ident = ident;
	}
}
