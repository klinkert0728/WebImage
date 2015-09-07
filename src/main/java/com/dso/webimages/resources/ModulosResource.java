package com.dso.webimages.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.webimages.entities.Modulos;
import com.dso.webimages.services.ModulosService;

@Path("/modulos")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModulosResource {

	ModulosService modulosService = new ModulosService();
	
	@GET
	@Path("/getModulosUsuario/{idGrupo}")
	public ArrayList<Modulos> getModulosUsuario (@PathParam("idGrupo") String idGrupo) {
		ArrayList<Modulos> lst = new ArrayList<Modulos>();
		lst = modulosService.getModulosUsuario(idGrupo);
		return lst;
	}
	
	

}
