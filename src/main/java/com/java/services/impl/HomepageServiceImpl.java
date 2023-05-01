/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.java.pojos.Banners;
import com.java.pojos.Homepage;
import com.java.repositories.BannersRepository;
import com.java.repositories.HomepageRepository;
import com.java.services.BannersService;
import com.java.services.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class HomepageServiceImpl implements HomepageService{

    @Autowired
    private HomepageRepository homepageRepository;
    
    @Autowired
    private BannersService bannerService;
    
    @Override
    public Homepage getHomepage() {
        return homepageRepository.getHomepage();
    }

    @Override
    public boolean updateHomepage(Homepage home) {
        Banners banner = home.getBannerId();
        if (!bannerService.updateBanner(banner)) {
            return false;
        }
        return homepageRepository.updateHomepage(home);
    }
    
}
