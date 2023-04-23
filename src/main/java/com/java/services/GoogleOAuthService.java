/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.pojos.UserCredential;

/**
 *
 * @author AnChuPC
 */
public interface GoogleOAuthService {
    public UserCredential getAccessToken(String code, String state);
}
