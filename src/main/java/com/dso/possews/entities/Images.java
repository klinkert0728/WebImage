/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dso.possews.entities;

/**
 *
 * @author danielklinkert
 */
public class Images {
    
    private String path;
    private int size;
    private int width;
    private int height;
    private String name;
    private int userId;
    
    public Images (){
        
    }
    public Images(String path, int size, int width, int height, String name, int userId) {
        
        this.path = path;
        this.size = size;
        this.width = width;
        this.height = height;
        this.name = name;
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public int getSize() {
        return size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

   
    
}
