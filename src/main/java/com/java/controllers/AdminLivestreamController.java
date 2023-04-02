/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Livestreams;
import com.java.services.LivestreamsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping(value = "/admin/livestream")
public class AdminLivestreamController {

    @Autowired
    private LivestreamsService livestreamsService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Livestreams> livestreams = livestreamsService.getLivestreams(null);

        model.addAttribute("livestream", new Livestreams());
        model.addAttribute("livestreams", livestreams);
        return "admin-livestream";
    }

    @PostMapping(value = "/")
    public String addLivestream(Model model, @ModelAttribute(value = "livestream") Livestreams livestream) {
        if (livestreamsService.addOrUpdateLivestream(livestream)) {
            return "redirect:/admin/livestream/";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/{id}")
    public String updateLivestream(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("livestream", livestreamsService.getLiveStreamById(id));
        return "admin-livestream";
    }
}
