/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Livestreams;
import com.java.repositories.LivestreamsRepository;
import com.java.services.LivestreamsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnChuPC
 */
@Service
public class LivestreamsServiceImpl implements LivestreamsService{

    @Autowired
    private LivestreamsRepository livestreamsRepository;
    
    @Override
    public List<Livestreams> getLivestreams(Map<String, String> params) {
        return livestreamsRepository.getLivestreams(params);
    }

    @Override
    public Livestreams getLiveStreamById(String id) {
        return livestreamsRepository.getLiveStreamById(id);
    }

    @Override
    public boolean addOrUpdateLivestream(Livestreams livestream) {
        return false;
    }
    
}
