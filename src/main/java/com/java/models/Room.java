/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.models;

import com.java.pojos.Users;
import java.util.UUID;

/**
 *
 * @author AnChuPC
 */
public class Room {
    private String id;
    private Users user;
    private Users advisor;

    public Room() {
        
    }
    public Room(Users user, Users advisor) {
        this.id = UUID.randomUUID().toString();
        this.advisor = advisor;
        this.user = user;
    }
    
    public Room(String id, Users user, Users advisor) {
        this.id = id;
        this.advisor = advisor;
        this.user = user;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s - %s", id, user.getId(), advisor.getId());
    }
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
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the advisor
     */
    public Users getCounselor() {
        return advisor;
    }

    /**
     * @param advisor the advisor to set
     */
    public void setCounselor(Users advisor) {
        this.advisor = advisor;
    }
}
