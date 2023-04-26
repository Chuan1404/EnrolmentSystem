/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnChuPC
 */
@Service
public class GoogleOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        System.out.println("Here!!!!!!!1");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        
        return oAuth2User;
        
    }

//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest r) throws OAuth2AuthenticationException {
//        System.out.println("Here!!!!!!!1");
//        OAuth2User oAuth2User = super.loadUser(r);
//        String email = oAuth2User.getAttribute("email");
//        System.out.println("loadUser");
//        Users u = new Users(); 
//        u.setUsername(email);
//        u.setPassword("");
//        u.setUserRole("ROLE_USER");
//        return new DefaultOAuth2User(Collections.emptyList(),
//                oAuth2User.getAttributes(),
//                u.getUsername());
//
//    }
}
