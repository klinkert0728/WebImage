/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dso.webimages.resources;

import com.dso.webimages.entities.Images;
import com.dso.webimages.entities.Usuarios;
import com.dso.webimages.services.DownloadService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danielklinkert
 */
    @Path("/download")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
public class DownloadResource {
        
        DownloadService downloadService = new DownloadService();
        
        @GET
	@Path("/{imageId}")
	public Images getImagePath (@PathParam("imageId") String imageId) throws Exception {
            
            return downloadService.getImagePath(imageId);
		//return downloadService.getImage();
	}
        
   
}
