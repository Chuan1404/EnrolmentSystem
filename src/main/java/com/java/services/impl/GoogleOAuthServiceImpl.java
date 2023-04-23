/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.UserCredential;
import com.java.services.GoogleOAuthService;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
public class GoogleOAuthServiceImpl implements GoogleOAuthService {


    @Override
    public UserCredential getAccessToken(String code, String state) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://oauth2.googleapis.com/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("code", code);
        map.add("client_id", "128479845058-anu704t9t483ohtf7ok3p67t6iau78sf.apps.googleusercontent.com");
        map.add("client_secret", "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");
        map.add("redirect_uri", "http://localhost:8080/EnrolmentSystem/auth/login-google");
        map.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        UserCredential userCredential = new UserCredential();
        userCredential.setAccessToken((String) response.getBody().get("access_token"));
        userCredential.setRefreshToken((String) response.getBody().get("refresh_token"));

        Double d = (Double) response.getBody().get("expires_in");
        userCredential.setExpiresIn(d.longValue());
        return userCredential;
    }

}
