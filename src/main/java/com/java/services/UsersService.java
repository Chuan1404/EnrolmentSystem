/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.pojos.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author AnChuPC
 */
public interface UsersService extends UserDetailsService {

    public Users getUserById(String id);

    public boolean addOrUpdateUser(Users u);

    public Users getUsersByUsername(String name);

    public Users getUserByEmail(String email);

    public UserDetails loadUsersByGoogle(String accessToken);

}
