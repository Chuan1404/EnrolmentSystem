/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.services;

import com.java.pojos.Faculties;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface FacultiesService {
    List<Faculties> getFaculties();
    Faculties getFacultyById(int id);
}
