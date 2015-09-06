package com.dso.possews.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.possews.dao.DbConnection;
import com.dso.possews.entities.Clients;
import com.dso.possews.entities.Remisiones;
import com.dso.possews.entities.Usuarios;
import com.dso.possews.entities.Procesos;
import com.dso.possews.exception.POSseWSException;

public class RemisionesService {

	public Remisiones getRemision(int numeroRemision) {
		Remisiones remision = null;
		
		String query = "select * from remisiones where numero_remision = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, numeroRemision);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				remision = new Remisiones(rs.getInt("numero_remision"), 
						               rs.getDate("fecha"), 
						               rs.getString("id_cliente"),
						               rs.getString("id_marca"), 
						               rs.getInt("total_recibido"),
						               rs.getString("refe_prenda"),
						               rs.getString("id_prenda"),
						               rs.getString("id_confeccionista"),
						               rs.getString("codigo_op"),
						               rs.getString("estado")
						              );
			}
			
			ps.close();
			conexion.close();
			
			if (remision == null) {
				throw new POSseWSException("Remision no Existe");
			}
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} 
		
		return remision;
	}
	
	public ArrayList<Remisiones> getRefes(String numeroRefe) {
		ArrayList<Remisiones> lstRemisiones = new ArrayList<Remisiones>();
		
		String query = "select * from remisiones where refe_prenda = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, numeroRefe);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstRemisiones.add(new Remisiones(rs.getInt("numero_remision"), 
						                     rs.getDate("fecha"),
						                     rs.getInt("total_recibido"),
						                     rs.getString("codigo_op")
						                    ));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstRemisiones;
	}
	
	public ArrayList<Procesos> getProcesos(String numeroRemision) {
		ArrayList<Procesos> lstProcesos = new ArrayList<Procesos>();
		
		String query = "select * from remision_detalle where numero_remision = ? and estado = 'A'";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, numeroRemision);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstProcesos.add(new Procesos(rs.getInt("numero_remision"),
											 rs.getString("id_proceso"), 
											 rs.getString("id_tipo"), 
											 rs.getString("id_tipo2"),
											 rs.getString("descripcion")
											 ));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstProcesos;
	}
	
	public String getPr(String numeroRefe) {
		String respuesta = "";
		
		String query = "select codigo_pr from remisiones where numero_remision = ?";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, numeroRefe);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				respuesta = rs.getString("codigo_pr");
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return respuesta;
	}
	
	public int addRemision(Remisiones newRemision) {
		int Ok = -1;
		
		String query = "insert into remisiones (numero_remision, fecha, id_cliente, total_recibido, id_marca, id_confeccionista, refe_prenda, id_prenda, codigo_op, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, newRemision.getNumeroRemision());
			ps.setDate(2, newRemision.getFecha());
			ps.setString(3, newRemision.getIdCliente());
			ps.setInt(4, newRemision.getTotalRecibido());
			ps.setString(5, newRemision.getIdMarca());
			ps.setString(6, newRemision.getIdConfeccionista());
			ps.setString(7, newRemision.getRefePrenda());
			ps.setString(8, newRemision.getIdPrenda());
			ps.setString(9, newRemision.getCodigoOp());
			ps.setString(10, "A");
		
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
