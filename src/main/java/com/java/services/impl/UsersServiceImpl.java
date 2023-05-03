/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.enums.UserRole;
import com.java.models.FacebookResponse;
import com.java.models.GoogleResponse;
import com.java.pojos.Users;
import com.java.repositories.UsersRepository;
import com.java.services.UsersService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Users getUserById(String id) {
        return usersRepository.getUserById(id);
    }

    @Override
    public boolean addOrUpdateUser(Users u) {

        // set password and role
        u.setPassword(encoder.encode((u.getPassword())));
        u.setUserRole(UserRole.ROLE_USER.name());

        Map response = null;

        if (u.getFile() != null) {
            try {
                response = cloudinary.uploader().upload(u.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (response != null) {
            u.setAvatar(response.get("secure_url").toString());
        }
        return usersRepository.addOrUpdateUser(u);
    }

    @Override
    public Users getUsersByUsername(String name) {
        return usersRepository.getUsersByUsername(name);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.getUsersByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        }

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepository.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUsersByGoogle(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        String url = "https://www.googleapis.com/oauth2/v3/userinfo";

        ResponseEntity<GoogleResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, GoogleResponse.class);
        GoogleResponse responseData = response.getBody();

        Users user = getUserByEmail(responseData.getEmail());
        // email khong ton tai tren database
        if (user == null) {

            user = new Users();
            user.setAvatar(responseData.getPicture());
            user.setUsername(responseData.getEmail());
            user.setName(responseData.getName());
            user.setEmail(responseData.getEmail());
            user.setPassword("");

            boolean isSuccess = usersRepository.addOrUpdateUser(user);
            if (isSuccess) {
                user = getUserByEmail(responseData.getEmail());
            } else {
                return null;
            }
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
    }

    @Override
    public List<Users> getUsersByUserRole(UserRole userRole) {
        return usersRepository.getUsersByUserRole(userRole);
    }

    @Override
    public UserDetails loadUsersByFacebook(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(headers);

        String url = "https://graph.facebook.com/v12.0/me?fields=id,name,phone,email,picture&access_token=" + accessToken;

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
        Map responseBody = response.getBody();

        System.out.println(responseBody);
        return null;
    }
}
