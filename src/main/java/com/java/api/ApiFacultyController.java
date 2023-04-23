/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.api;

import com.java.pojos.Faculties;
import com.java.services.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jackc
 */
@RestController
@RequestMapping(value = "/api/faculties")
public class ApiFacultyController {
    @Autowired
    private FacultiesService facultiesService;
    
    @DeleteMapping(value = "/{id}")
    public void deleteFaculties(@PathVariable(value="id") String id) {
        Faculties faculty = facultiesService.getFacultyById(Integer.parseInt(id));
        facultiesService.deleteFaculty(faculty);
    }
}
