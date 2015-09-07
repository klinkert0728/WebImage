/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dso.webimages.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dso.webimages.dao.DbConnection;
import com.dso.webimages.entities.Images;
import com.dso.webimages.entities.Usuarios;
import com.dso.webimages.exception.POSseWSException;

/**
 *
 * @author danielklinkert
 */
public class DownloadService {

    public Images getImagePath(String imageId) throws Exception {

        Images image = null;

        String query = "select * from images where image_id = ?";

        try {

            Connection conexion = DbConnection.getConnection();
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, imageId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                image = new Images(rs.getString("path"),
                                    0, 
                                    0,
                                    0,
                                    rs.getString("name"),
                                    rs.getShort("user_id"));   
            }

            ps.close();
            conexion.close();

            if (image == null) {
                throw new POSseWSException("La imagen fue borrada");
            }
        } catch (SQLException sqlEx) {
            throw new POSseWSException(sqlEx.getMessage());
        }

        return image;
    }

}
