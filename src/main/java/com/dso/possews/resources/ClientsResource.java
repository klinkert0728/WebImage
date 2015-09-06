package com.dso.possews.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dso.possews.entities.Clients;
import com.dso.possews.services.ClientsService;

@Path("/clientes")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientsResource {

ClientsService clientsService = new ClientsService();
	
	@GET
	public ArrayList<Clients> getClients () {
		ArrayList<Clients> lst = new ArrayList<Clients>();
		lst = clientsService.getClients();
		return lst;
	}
	
	
}
