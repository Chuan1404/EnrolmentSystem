/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.pojos.Livestreams;
import com.java.repositories.LivestreamsRepository;
import com.java.services.LivestreamsService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnChuPC
 */
@Service
public class LivestreamsServiceImpl implements LivestreamsService {

    @Autowired
    private LivestreamsRepository livestreamsRepository;

    @Autowired
    private Cloudinary cloudinary;

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
<<<<<<< HEAD
        if (!livestream.getFile().isEmpty()) {
=======
        if (livestream.getFile() != null) {
>>>>>>> e26311bdbe29f65489905e2505d475a8f8f4b660
            try {
                Map res = cloudinary.uploader().upload(livestream.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                livestream.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(LivestreamsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return livestreamsRepository.addOrUpdateLivestream(livestream);
    }

    @Override
    public boolean deleteLivestream(String id) {
        return livestreamsRepository.deleteLivestream(id);
    }

}
