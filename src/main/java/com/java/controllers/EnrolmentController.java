/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.services.ArticlesService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Map<String, Object>> articleList = new ArrayList<>();
        for (ArticleType type : ArticleType.values()) {
            if (type != ArticleType.HOME) {
                Map<String, Object> map = new HashMap<>();
                map.put("title", ArticleType.convertToString(type));
                map.put("data", articlesService.getListArticleNewest(type, 5));

                articleList.add(map);
            }
        }
        model.addAttribute("articleList", articleList);
        return "enrolment";
    }
    
    @GetMapping(value = "/{id}")
    public String detail(Model model, @PathVariable(value = "id") String id) {
        Articles article = articlesService.getArticleById(id);
        
        model.addAttribute("article", article);
        
        return "enrolment-detail";
    }
}
