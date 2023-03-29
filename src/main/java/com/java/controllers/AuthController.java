///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.java.controllers;
//
//import com.cloudinary.Cloudinary;
//import com.java.pojos.Users;
//import com.java.services.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author AnChuPC
// */
//@Controller
//@RequestMapping(value = "/auth")
//public class AuthController {
//
//    @Autowired
//    private UsersService usersService;
//    
//    
////    @GetMapping(value = "/login")
////    public String login() {
////        return "login";
////    }
//
//    @GetMapping(value = "/register")
//    public String register(Model model) {
//        
//        model.addAttribute("user", new Users());
//        return "register";
//    }
//    
//    @PostMapping(value = "/register")
//    public String register(Model model, @ModelAttribute(value = "user") Users u) {
//        
//        u.setId("sdjnfkldnsfksdfsn");
//        u.setUserRole("ADMIN");
//        usersService.addUser(u);
//        
//        return "index";
//    }
//}
