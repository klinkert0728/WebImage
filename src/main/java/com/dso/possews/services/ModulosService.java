package com.dso.possews.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dso.possews.dao.DbConnection;
import com.dso.possews.entities.Modulos;
import com.dso.possews.entities.Usuarios;
import com.dso.possews.exception.POSseWSException;

public class ModulosService {
	
	public ArrayList<Modulos> getModulosUsuario(String idGrupo) {
		ArrayList<Modulos> lstModulos = new ArrayList<Modulos>();
		
		String query = "select * from modulos_usuario where id_grupo = ? order by id_modulo";
		
		try {
			Connection conexion = DbConnection.getConnection();
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, idGrupo);
				 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstModulos.add(new Modulos(rs.getString("id_modulo"), 
						                     rs.getString("modulo"),
						                     rs.getString("ident")
						                    ));
			}
			
			ps.close();
			conexion.close();
		} catch (SQLException sqlEx) {
			throw new POSseWSException(sqlEx.getMessage());
		} catch (Exception ex) {
			throw new POSseWSException(ex.getMessage());
		}
		
		return lstModulos;
	}

}
