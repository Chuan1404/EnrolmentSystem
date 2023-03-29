/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.pojos.Images;
import com.java.repositories.ImagesRepository;
import com.java.services.ImagesService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class ImagesServiceImpl implements ImagesService{
    
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImagesRepository imagesRepository;
    
    @Override
    public List<Images> getImagesByBannerId(int id) {
        return imagesRepository.getImagesByBannerId(id);
    }

    @Override
    public boolean updateImages(Images img) {
       
        if (!img.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(img.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                img.setUrl(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ImagesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.imagesRepository.updateImage(img);
    }
    
}
