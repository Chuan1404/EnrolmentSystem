/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Images;
import com.java.repositories.ImagesRepository;
import com.java.services.ImagesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class ImagesServiceImpl implements ImagesService{

    @Autowired
    private ImagesRepository imagesRepository;
    
    @Override
    public List<Images> getImagesByBannerId(int id) {
        return imagesRepository.getImagesByBannerId(id);
    }
    
}
