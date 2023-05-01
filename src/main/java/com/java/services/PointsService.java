/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.services;

import com.java.pojos.Points;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface PointsService {
    List<Points> getRecentPoints(int majorId);
    int getMaxYearByMajorId(int majorId);
}
