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
import com.java.services.ImagesService;
import java.util.List;
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
    private ImagesService imagesService;
    

    @Override
    public boolean updateBanner(Banners banner) {
//        List<Images> images = banner.getImagesCollection();
        List<Images> images = (List<Images>) banner.getImagesCollection();
        System.out.println(images);
        for (Images img : images) {
            img.setBannerId(banner);
            System.out.println(img.getFile());
            if (!this.imagesService.updateImages(img))
                return false;
        }
        
        return this.bannersRepository.updateBanner(banner);
        
    }
    
}
