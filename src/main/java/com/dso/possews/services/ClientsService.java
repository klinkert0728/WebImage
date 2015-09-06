package com.dso.possews.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.possews.dao.DbConnection;
import com.dso.possews.entities.Clients;
import com.dso.possews.exception.POSseWSException;

public class ClientsService {
	
	public ArrayList<Clients> getClients() {
		ArrayList<Clients> lstClients = new ArrayList<Clients>();
		
		String query = "select * from clientes";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstClients.add(new Clients(rs.getString("id_tercero"), 
						                     rs.getString("cliente"),
						                     rs.getString("marca")
						                    ));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstClients;
	}
}
