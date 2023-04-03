/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.services;

import com.java.pojos.Majors;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface MajorsService {
    public List<Majors> getMajors(int facultyId);
    int countMajorsByFacultyId(int facultyId);
    int getMaxYearByFacultyId(int facultyId);
}
