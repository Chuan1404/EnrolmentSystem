/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Faculties;
import com.java.services.FacultiesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jackc
 */
@Controller
@RequestMapping("/faculty")
public class FacultyController {
    
    @Autowired
    private FacultiesService facultiesService;
    
    @GetMapping("/")
    public String faculty(Model model) {
        List<Faculties> faculties = facultiesService.getFaculties();
        model.addAttribute("faculties", faculties);
        return "faculty";
    }
    
    @GetMapping("/{facultyId}")
    public String facultyDetail(Model model, @PathVariable("facultyId") int id) {
        Faculties faculty = facultiesService.getFacultyById(id);
        model.addAttribute("faculty", faculty);
        return "faculty-detail";
    }
}
