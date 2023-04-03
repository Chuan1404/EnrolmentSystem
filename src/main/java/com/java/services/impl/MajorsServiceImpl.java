/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Majors;
import com.java.repositories.MajorsRepository;
import com.java.repositories.PointsRepository;
import com.java.services.MajorsService;
import com.java.services.PointsService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class MajorsServiceImpl implements MajorsService {
    
    @Autowired
    private MajorsRepository majorsRepository;
    @Autowired
    private PointsService pointsService;

    @Override
    public List<Majors> getMajors(int facultyId) {
        return majorsRepository.getMajors(facultyId);
    }

    @Override
    public int countMajorsByFacultyId(int facultyId) {
        return majorsRepository.countMajorsByFacultyId(facultyId);
    }

    @Override
    public int getMaxYearByFacultyId(int facultyId) {
        List<Majors> majors = majorsRepository.getMajors(facultyId);
        return majors.stream().map(major -> pointsService.getMaxYearByMajorId(major.getId()))
                .collect(Collectors.toList())
                .stream().reduce(0, Integer::max);
       
    }
    
    
    
}
