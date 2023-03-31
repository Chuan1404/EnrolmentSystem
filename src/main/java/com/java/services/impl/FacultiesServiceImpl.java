/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Faculties;
import com.java.repositories.FacultiesRepository;
import com.java.services.FacultiesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class FacultiesServiceImpl implements FacultiesService {

    @Autowired
    private FacultiesRepository facultiesRepository;
    
    @Override
    public List<Faculties> getFaculties() {
        return facultiesRepository.getFaculties();
    }

    @Override
    public Faculties getFacultyById(int id) {
        return facultiesRepository.getFacultyById(id);
    }
    
}
