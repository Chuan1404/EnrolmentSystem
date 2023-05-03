/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.models.UserCredential;
import com.java.services.FacebookOAuthService;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AnChuPC
 */
@Service
public class FacebookOAuthServiceImpl implements FacebookOAuthService {

    @Override
    public UserCredential getAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String accessTokenUri = "https://graph.facebook.com/v12.0/oauth/access_token";
        String redirectUri = "http://localhost:8080/EnrolmentSystem/auth/login-facebook";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("253581830402126", "1c125971e376eb85c88fc4b12ce14f7d");

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("code", code);
        formData.add("redirect_uri", redirectUri);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(accessTokenUri, entity, Map.class);

        UserCredential userCredential = new UserCredential();
        userCredential.setAccessToken((String) response.getBody().get("access_token"));
        Double d = Double.valueOf(response.getBody().get("expires_in").toString());
        userCredential.setExpiresIn(d.longValue());
        
        return userCredential;
    }

}
