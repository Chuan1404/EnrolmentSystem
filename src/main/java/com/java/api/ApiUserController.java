/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.api;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jackc
 */
@RestController
public class ApiUserController {
    @GetMapping("/api/curr-user")
    public boolean isAuthorized(Principal principal) {
        return principal != null;
    }
    
}
