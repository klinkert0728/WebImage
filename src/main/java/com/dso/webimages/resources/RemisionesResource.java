package com.dso.webimages.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.webimages.entities.Procesos;
import com.dso.webimages.entities.Remisiones;
import com.dso.webimages.services.RemisionesService;


@Path("/remisiones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RemisionesResource {

	RemisionesService remisionesService = new RemisionesService();
	
	@GET
	@Path("/{numeroRemision}")
	public Remisiones getRemision (@PathParam("numeroRemision") int numeroRemision) {
		return remisionesService.getRemision(numeroRemision);
	}
	
	@GET
	@Path("getRefes/{numeroRefe}")
	public ArrayList<Remisiones> getRefes (@PathParam("numeroRefe") String numeroRefe) {
		return remisionesService.getRefes(numeroRefe);
	}
	
	@GET
	@Path("/procesos/{numeroRemision}")
	public ArrayList<Procesos> getProcesos (@PathParam("numeroRemision") String numeroRemision) {
		return remisionesService.getProcesos(numeroRemision);
	}
	
	@GET
	@Path("/pr/{numeroRemision}")
	public String getPr (@PathParam("numeroRemision") String numeroRemision) {
		return remisionesService.getPr(numeroRemision);
	}
	
	@POST
	@Path("/addRemision")
	public String addRemision (Remisiones newRemision) {
		String opResult = null;
		
		if (remisionesService.addRemision(newRemision) == -1) {
			opResult = "FALLO";
		} else opResult = "OK";
		
		return opResult;
		//return remisionesService.addRemision(newRemision);
	}
}
