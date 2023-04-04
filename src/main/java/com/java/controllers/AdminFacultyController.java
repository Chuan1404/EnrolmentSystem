/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.pojos.Faculties;
import com.java.services.ArticlesService;
import com.java.services.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jackc
 */
@Controller
@RequestMapping("/admin/faculties")
public class AdminFacultyController {
    
    @Autowired
    private FacultiesService facultiesService;
    
    @Autowired
    private ArticlesService articlesService;
    
    @GetMapping("/") 
    public String faculty(Model model) {
        model.addAttribute("faculty", new Faculties());
        model.addAttribute("facultyArticle", new Articles());
         Articles article2 = new Articles();
        System.out.println(article2.getId());

        return "admin-faculties";
    }
    
    @PostMapping("/")
    public String addFaculty(@ModelAttribute("faculty") Faculties faculty) {
        
        
        
       
        facultiesService.addFaculty(faculty);
        return "redirect:/admin/faculties/";
    }
}
