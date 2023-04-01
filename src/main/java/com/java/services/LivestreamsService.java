/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.pojos.Livestreams;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AnChuPC
 */
public interface LivestreamsService {
    public List<Livestreams> getLivestreams(Map<String, String> params);
    public Livestreams getLiveStreamById(String id);
    public boolean addOrUpdateLivestream(Livestreams livestream);
}
