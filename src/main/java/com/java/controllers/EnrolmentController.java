/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.services.ArticlesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping(value = "/enrolment")
public class EnrolmentController {
    
    @Autowired
    private ArticlesService articlesService;
    
    @GetMapping(value = "/")
    public String index(Model model) {
        List<Articles> listArticles = articlesService.getListArticleNewest(ArticleType.CHINH_QUY, 5);
        System.out.println(listArticles);
        
        model.addAttribute("articles", listArticles);
        return "enrolment";
    }
}
