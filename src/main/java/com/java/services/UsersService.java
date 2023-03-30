/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.pojos.Users;
import java.util.List;

/**
 *
 * @author AnChuPC
 */
public interface UsersService {

    public Users getUserById(String id);

    public boolean addUser(Users u);

    public List<Users> getUsersByUsername(String name);
}
