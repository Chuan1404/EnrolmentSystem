/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Faculties;
import com.java.pojos.Majors;
import com.java.pojos.Points;
import com.java.services.FacultiesService;
import com.java.services.MajorsService;
import com.java.services.PointsService;
import java.util.ArrayList;
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
    @Autowired
    private MajorsService majorsService;
    @Autowired
    private PointsService pointsService;
    
    @GetMapping("/")
    public String faculty(Model model) {
        List<Faculties> faculties = facultiesService.getFaculties();
        model.addAttribute("faculties", faculties);
        return "faculty";
    }
    
    @GetMapping("/{facultyId}")
    public String facultyDetail(Model model, @PathVariable("facultyId") int id) {
        Faculties faculty = facultiesService.getFacultyById(id);
        List<Majors> majors = majorsService.getMajors(faculty.getId());
        List<List<Points>> points = new ArrayList<>();
        int numberOfMajors = majorsService.countMajorsByFacultyId(faculty.getId());
        for (int i = 0; i < numberOfMajors; i++) {
            points.add(pointsService.getRecentPoints(majors.get(i).getId()));
        }
        int maxYear = majorsService.getMaxYearByFacultyId(faculty.getId());
        model.addAttribute("faculty", faculty);
        model.addAttribute("majors", majors);
        model.addAttribute("pointList", points);
        model.addAttribute("maxYear", maxYear);
        return "faculty-detail";
    }
    
    
}
