/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.java.pojos.Banners;
import com.java.pojos.Images;
import com.java.repositories.BannersRepository;
import com.java.repositories.ImagesRepository;
import com.java.services.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class BannersServiceImpl implements BannersService{
    
    @Autowired
    private BannersRepository bannersRepository;
    
    @Autowired
    private ImagesRepository imagesRepository;
    

    @Override
    public boolean updateBanner(Banners banner) {
        for (Images img : banner.getImagesCollection()) {
            img.setBannerId(banner);
            System.out.println(img.getBannerId());
            if (!this.imagesRepository.updateImage(img))
                return false;
        }
        
        return this.bannersRepository.updateBanner(banner);
        
    }
    
}
