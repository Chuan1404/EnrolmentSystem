/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories;

import com.java.pojos.Livestreams;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
public interface LivestreamsRepository {
    public List<Livestreams> getLivestreams(Map<String, String> params);
    public Livestreams getLiveStreamById(String id);
}
