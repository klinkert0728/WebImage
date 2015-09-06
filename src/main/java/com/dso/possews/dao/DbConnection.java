package com.dso.possews.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() {
		PropiedadesPOSse propiedades = new PropiedadesPOSse();
		
		try {
			propiedades.ParametrosPOSse();
			
			Connection connection = null;
			Class.forName(propiedades.ClassforName).newInstance();
			connection = DriverManager.getConnection(propiedades.connectionURL, propiedades.userDB, propiedades.passwordDB);
		    connection.setAutoCommit(false);
			return connection;
		} catch (RuntimeException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}