/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.handlers.LoginSuccessHandler;
import com.java.pojos.Users;
import com.java.services.GoogleOAuthService;
import com.java.services.UsersService;
import javax.servlet.http.HttpServletRequest;
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
    public String googleCallback(HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        if (code != null) {
            String accessToken = googleService.getAccessToken(code, state).getAccessToken();
            if (accessToken != null) {
                // Lấy access token thành công, xử lý dữ liệu ở đây
                System.out.println("OK");
                return "redirect:/";
            }
        }
        // Xác thực không thành công, chuyển hướng về trang đăng nhập
        return "redirect:/login?error=true";
    }

    @GetMapping(value = "/login")
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("currentUser") != null) {
            return "redirect:/";
        }
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute Users user) {
        return "index";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {

        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid Users u, BindingResult result) {

        // validate confirm password
        if (!result.getFieldValue("password").equals(result.getFieldValue("confirmPassword"))) {
            result.rejectValue("confirmPassword", "user.error.confirmPassword");
        }

        // validate empty file
        if (u.getFile().isEmpty()) {
            result.rejectValue("file", "user.error.null");
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
