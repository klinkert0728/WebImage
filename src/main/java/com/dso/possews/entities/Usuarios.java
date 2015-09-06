package com.dso.possews.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuarios {
	
	// campos de la tabla usuarios
	
	private String username;
    private String idGrupo;
    private String idTercero;
    private String password;
    private String estado;
    
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	public String getIdTercero() {
		return idTercero;
	}

	public void setIdTercero(String idTercero) {
		this.idTercero = idTercero;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

		
	public Usuarios() {
    }
	
	public Usuarios(String username, String idGrupo, String idTercero, String password, String estado) {
	       this.username = username;
	       this.idGrupo = idGrupo;
	       this.idTercero = idTercero;
	       this.password = password;
	       this.estado = estado;
	}
	
}
