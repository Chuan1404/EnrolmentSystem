/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping(value = "/enrolment")
public class EnrolmentController {
    @GetMapping(value = "/")
    public String index() {
        return "enrolment";
    }
}
