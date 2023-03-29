/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Banners;
import com.java.pojos.Homepage;
import com.java.pojos.Images;
import com.java.services.HomepageService;
import com.java.services.ImagesService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jackc
 */
@Controller
@RequestMapping("/admin/homepage")
public class AdminHomepageController {
    @Autowired
    private HomepageService homepageService;
    @Autowired
    private ImagesService imagesService;
    
    @GetMapping("/")
    public String adminHomepage(Model model) {
        Homepage home = homepageService.getHomepage();
       
        model.addAttribute("homepage", home);
        List<Images> images = home.getBannerId().getImagesCollection();

//        System.out.println(home.getBannerId().getImagesCollection().toString());
        return "admin-homepage";
    }
    
    @PostMapping("/update")
    public String updateHomepage(Model model, @ModelAttribute("homepage") Homepage home) {
        
        if (this.homepageService.updateHomepage(home))
            return "redirect:/admin/homepage";
        else model.addAttribute("errMsg", "SOMETHING WENT WRONG!");

        return "admin-homepage";
    }
}
