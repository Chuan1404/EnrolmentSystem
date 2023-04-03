/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Points;
import com.java.repositories.PointsRepository;
import com.java.services.PointsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class PointsServiceImpl implements PointsService {
    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public List<Points> getRecentPoints(int majorId) {
        return pointsRepository.getRecentPoints(majorId);
    }

    @Override
    public int getMaxYearByMajorId(int majorId) {
        return pointsRepository.getMaxYearByMajorId(majorId);
    }
}
