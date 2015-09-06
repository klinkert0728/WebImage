package com.dso.possews.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.possews.dao.DbConnection;
import com.dso.possews.entities.Usuarios;
import com.dso.possews.exception.POSseWSException;

public class UsuariosService {

	public Usuarios getUsuario(String username) {
		Usuarios usuario = null;
		
		String query = "select * from usuarios where username = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, username);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usuario = new Usuarios(rs.getString("username"), 
						               rs.getString("id_grupo"), 
						               rs.getString("id_tercero"), 
						               rs.getString("password"), 
						               rs.getString("estado")
						              );
			}
			
			ps.close();
			conexion.close();
			
			if (usuario == null) {
				throw new POSseWSException("Usuario no Existe");
			}
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return usuario;
	}
	
	public ArrayList<Usuarios> getUsuarios() {
		ArrayList<Usuarios> lstUsuarios = new ArrayList<Usuarios>();
		
		String query = "select * from usuarios";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstUsuarios.add(new Usuarios(rs.getString("username"), 
						                     rs.getString("id_grupo"), 
						                     rs.getString("id_tercero"), 
						                     rs.getString("password"), 
						                     rs.getString("estado")
						                    ));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstUsuarios;
	}
	
	public int addUsuario(Usuarios newUsuario) {
		int Ok = -1;
		
		String query = "insert into usuarios (username, id_grupo, id_tercero, password, estado) values (?, ?, ?, ?, ?)";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, newUsuario.getUsername());
			ps.setString(2, newUsuario.getIdGrupo());
			ps.setString(3, newUsuario.getIdTercero());
			ps.setString(4, newUsuario.getPassword());
			ps.setString(5, newUsuario.getEstado());
		
			Ok = ps.executeUpdate();
			try {
				conexion.commit();
			} catch (SQLException sqlEx) {
				conexion.rollback();
				throw new POSseWSException(sqlEx.getMessage());
			}
			
			ps.close();
			conexion.close();	
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return Ok;
	}
}
