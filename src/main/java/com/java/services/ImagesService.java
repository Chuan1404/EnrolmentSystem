package com.java.services;


import com.java.pojos.Images;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jackc
 */
public interface ImagesService {
    List<Images> getImagesByBannerId(int id);
    boolean updateImages(Images img);
}
