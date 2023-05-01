/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repositories;

import com.java.pojos.Majors;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface MajorsRepository {
    List<Majors> getMajors(int facultyId);
    int countMajorsByFacultyId(int facultyId);
}
