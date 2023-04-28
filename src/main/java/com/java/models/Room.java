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
    private Users counselor;

    public Room() {
        
    }
    public Room(Users user, Users counselor) {
        this.id = UUID.randomUUID().toString();
        this.counselor = counselor;
        this.user = user;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s - %s", id, user.getId(), counselor.getId());
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
     * @return the counselor
     */
    public Users getCounselor() {
        return counselor;
    }

    /**
     * @param counselor the counselor to set
     */
    public void setCounselor(Users counselor) {
        this.counselor = counselor;
    }
}
