/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.api;

import com.java.services.LivestreamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AnChuPC
 */
@RestController
@RequestMapping(value = "/api/livestream")
public class ApiLivestreamController {
    
    @Autowired
    private LivestreamsService livestreamService;
    
    @DeleteMapping(value = "/{id}")
    public void deleteLivestream(@PathVariable(value = "id") String id) {
        livestreamService.deleteLivestream(id);
    }
}
