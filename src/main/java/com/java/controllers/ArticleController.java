/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Articles;
import com.java.services.ArticlesService;
import javax.ejb.TransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Cuong0311
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticlesService articlesService;
    
    @GetMapping(value = "/")
    public String article(Model model) {
//        model.addAttribute("articles", new Articles());
        Articles article = articlesService.getArticleById("cMgQIwJuYNX6A6G1HfFu");
        model.addAttribute("article", article);
        return "article";
    }
}
