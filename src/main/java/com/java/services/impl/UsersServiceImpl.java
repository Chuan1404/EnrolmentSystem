/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.pojos.Users;
import com.java.repositories.UsersRepository;
import com.java.services.UsersService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnChuPC
 */
@Service("userDetailsService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Cloudinary cloudinary;
    @Override
    public Users getUserById(String id) {
        return usersRepository.getUserById(id);
    }

    @Override
    public boolean addUser(Users u) {

        Map response = null;

                if (u.getFile() != null) {
                    try {
                        response = cloudinary.uploader().upload(u.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                
                if(response != null) {
                    u.setAvatar(response.get("secure_url").toString());
                }
        return usersRepository.addUser(u);
    }

    @Override
    public List<Users> getUsersByUsername(String name) {
        return usersRepository.getUsersByUsername(name);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = this.getUsersByUsername(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found !!");
        }

        Users user = users.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }
}

   
