/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Homepage;
import com.java.repositories.HomepageRepository;
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
    
    @Override
    public Homepage getHomepage() {
        return homepageRepository.getHomepage();
    }
    
}
