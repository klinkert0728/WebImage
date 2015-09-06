package com.dso.possews.dao;

import java.io.InputStream;
import java.util.Properties;

public class PropiedadesPOSse {
	
	public String connectionURL;
	public String ClassforName;
	public String userDB;
	public String passwordDB;
	
	public void ParametrosPOSse() throws Exception {
		Properties propiedades = new Properties();
	    
		InputStream entrada = getClass().getClassLoader().getResourceAsStream("posse.properties");
	    if (entrada != null) {
	    	propiedades.load(entrada);
	    	entrada.close();
	    } else {
	    	System.out.println("Archivo de propiedades posse.properties no existe");
	    	throw new RuntimeException("Archivo de propiedades posse.properties no existe");
	    }
	    
	    connectionURL = propiedades.getProperty("connectionURL");
        ClassforName = propiedades.getProperty("ClassforName");
        userDB = propiedades.getProperty("userDB");
        passwordDB = propiedades.getProperty("passwordDB");
	}
}
