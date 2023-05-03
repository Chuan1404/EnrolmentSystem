/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.models;

/**
 *
 * @author AnChuPC
 */
public class FacebookResponse {
    private String id;
    private String name;
    private String pictureUrl;
    private String email;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return pictureUrl;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.pictureUrl = picture;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", id, name, pictureUrl, email);
    }
    
    
}
