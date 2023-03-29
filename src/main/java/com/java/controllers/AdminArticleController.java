/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.cloudinary.Cloudinary;
import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.pojos.Users;
import com.java.services.ArticlesService;
//import com.java.services.UsersService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private Cloudinary cloudinary;

//    @Autowired
//    private UsersService usersService;

    @GetMapping(value = "/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {
        Long totalArticle = articleService.getTotalRow(null);

        params.put("limit", "10");
        params.put("totalArticles", totalArticle.toString());
        if (params.get("page") == null) {
            params.put("page", "1");
        }

        List<Articles> articles = articleService.getArticles(params);
        System.out.println(totalArticle);
        model.addAttribute("article", new Articles());
        model.addAttribute("articles", articles);
        model.addAttribute("articleType", ArticleType.values());
        model.addAttribute("totalPage", Math.ceil((double) totalArticle / Integer.parseInt(params.get("limit"))));
        model.addAttribute("currentPage", Integer.parseInt(params.get("page")));
        return "admin-article";
    }

    @PostMapping(value = "/")
    public String addArticle(Model model, @ModelAttribute Articles article) {

        article.setCreatedDate(new Date());
        article.setUpdateDate(new Date());
//        article.setUserId(usersService.getUserById("BxST2aBzsduwWLw1cxEQ"));
        article.setImage("https://oga.hcmiu.edu.vn/wp-content/uploads/2020/11/122042029_3431112680290873_3369717683792004619_n.png");
        articleService.saveOrUpdateArticles(article);

        return "admin-article";
    }

    @GetMapping(value = "/{id}")
    public String updateArticle(Model model, @PathVariable(value = "id") String id) {
        Articles article = articleService.getArticleById(id);

        model.addAttribute("article", article);
        model.addAttribute("articleType", ArticleType.values());
        return "admin-article";
    }
}
