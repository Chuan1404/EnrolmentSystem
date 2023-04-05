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
import java.util.ArrayList;
import java.util.List;
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
        List<Faculties> faculties = facultiesService.getFaculties();
        model.addAttribute("faculty", new Faculties());
        model.addAttribute("faculties", faculties);
        return "admin-faculties";
    }
    
    @PostMapping("/")
    public String addFaculty(@ModelAttribute("faculty") Faculties faculty) {
        
        facultiesService.saveOrUpdateFaculty(faculty);
        return "redirect:/admin/faculties/";
    }
    
    @GetMapping("/{id}")
    public String updateFaculty(Model model, @ModelAttribute("id") int id) {
        model.addAttribute("faculty", facultiesService.getFacultyById(id));
        return "admin-faculties";
    }
}
