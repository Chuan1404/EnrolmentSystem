/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.handlers.LoginSuccessHandler;
import com.java.models.UserCredential;
import com.java.pojos.Users;
import com.java.services.GoogleOAuthService;
import com.java.services.UsersService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    GoogleOAuthService googleService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private LoginSuccessHandler loginHandler;

    @GetMapping("/login-google")
    public void loginGoogle(HttpSession session, HttpServletRequest request , HttpServletResponse response) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        // get token
        UserCredential userCredential = googleService.getAccessToken(code, state);
        session.setAttribute("userCredential", userCredential);
        // get user by token
        UserDetails userDetails = usersService.loadUsersByGoogle(userCredential.getAccessToken());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        try {
            loginHandler.onAuthenticationSuccess(request, response, authentication);
        } catch (IOException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GetMapping(value = "/login")
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("currentUser") != null) {
            return "redirect:/";
        }
        model.addAttribute("user", new Users());
        return "login";
    }


    @GetMapping(value = "/register")
    public String register(Model model) {

        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid Users u, BindingResult result) {

        // validate confirm password
        if (result.getFieldValue("password").toString().isEmpty()) {
            result.rejectValue("password", "user.error.passwordLength");
        }
        
        if (!result.getFieldValue("password").equals(result.getFieldValue("confirmPassword"))) {
            result.rejectValue("confirmPassword", "user.error.confirmPassword");
        }

        // validate empty file
        if (u.getFile().isEmpty()) {
            result.rejectValue("file", "form.error.null");
        }

        // check has error ? (pass id, avatar, userrole)
        if (result.getAllErrors().toArray().length - 3 > 0) {
            return "register";
        }

        // check email exist ?
//        boolean isValid = EmailValidator.getInstance().isValid(u.getEmail());
//        System.out.println(isValid);
//
//        if (!isValid) { 
//            model.addAttribute("errCode", "user.error.email");
//            return "register";
//        }
        // check has exist accout ?
        if (usersService.getUserByEmail(u.getEmail()) != null || usersService.getUsersByUsername(u.getUsername()) != null) {

            model.addAttribute("errCode", "user.error.existed");
            return "register";

        } else {
            usersService.addOrUpdateUser(u);
        }
        return "redirect:/";
    }
}
