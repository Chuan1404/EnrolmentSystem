/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repositories;

import com.java.pojos.Faculties;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface FacultiesRepository {
    List<Faculties> getFaculties();
    Faculties getFacultyById(int id);
    boolean saveOrUpdateFaculty(Faculties faculty);
}
