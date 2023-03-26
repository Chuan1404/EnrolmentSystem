/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.pojos.Users;
import com.java.services.ArticlesService;
import com.java.services.UsersService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticlesService articleService;
    
     @Autowired
    private UsersService usersService;

    @GetMapping(value = "/")
    public String index(Model model) {

        model.addAttribute("article", new Articles());

        model.addAttribute("articleType", ArticleType.values());
        return "admin-article";
    }

    @PostMapping(value = "/")
    public String addArticle(Model model, @ModelAttribute Articles article) {
        article.setCreatedDate(new Date());
        article.setUpdateDate(new Date());
        article.setUserId(usersService.getUserById("BxST2aBzsduwWLw1cxEQ"));
        article.setImage("https://oga.hcmiu.edu.vn/wp-content/uploads/2020/11/122042029_3431112680290873_3369717683792004619_n.png");
        articleService.saveOrUpdateArticles(article);

        return "index";
    }
}
