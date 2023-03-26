/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Homepage;
import com.java.pojos.Images;
import com.java.services.HomepageService;
import com.java.services.ImagesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
public class HomeController {
    
    @Autowired
    private HomepageService homepageService;
    
    @Autowired
    private ImagesService imagesService;
    
    @RequestMapping(path = "/")
    public String index(Model model) {
        Homepage home = homepageService.getHomepage();
        model.addAttribute("home", home);
        List<Images> images = imagesService.getImagesByBannerId(home.getBannerId().getId());
        model.addAttribute("images", images);
        return "index";
    }
}
