///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.java.controllers;
//
//import com.java.enums.ArticleType;
//import com.java.pojos.Articles;
//import com.java.services.ArticlesService;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// *
// * @author AnChuPC
// */
//@Controller
//@RequestMapping(value = "/enrolment")
//public class EnrolmentController {
//
//    @Autowired
//    private ArticlesService articlesService;
//
//    @GetMapping(value = "/")
//    public String index(Model model) {
//        List<Map<String, Object>> articleList = new ArrayList<>();
//
//        // Params
//        Map<String, String> params = new HashMap<>();
//        params.put("limit", "5");
//        
//        for (ArticleType type : ArticleType.values()) {
//            Map<String, Object> map = new HashMap<>();
//            
//            params.put("articleType", type.toString());
//            map.put("title", ArticleType.convertToString(type));
//            map.put("data", articlesService.getArticles(params));
//            articleList.add(map);
//        }
//        model.addAttribute("articleList", articleList);
//        return "enrolment";
//    }
//
//    @GetMapping(value = "/type/{type}")
//    public String type(Model model, @PathVariable(value = "type") String type, @RequestParam(value = "page", required = false) String page) {
//
//        Map<String, String> params = new HashMap<>();
//        params.put("articleType", type);
//
//        // Tổng số lượng Article thuộc type = type
//        Long totalArticles = articlesService.getTotalRow(ArticleType.valueOf(type));
//        params.put("totalArticles", totalArticles.toString());
//
//        // Set limit
//        params.put("limit", "10");
//
//        // Mặc định page = 1
//        if (page != null) {
//            params.put("page", page);
//        } else {
//            params.put("page", "1");
//        }
//
//        // Danh sách arcicles theo params
//        List articleList = articlesService.getArticles(params);
//
//        model.addAttribute("articleList", articleList);
//        model.addAttribute("totalPage", Math.ceil((double) totalArticles / Integer.parseInt(params.get("limit"))));
//        model.addAttribute("currentPage", Integer.parseInt(params.get("page")));
//
//        return "enrolment-list";
//    }
//
//    @GetMapping(value = "/{id}")
//    public String detail(Model model, @PathVariable(value = "id") String id) {
//        Articles article = articlesService.getArticleById(id);
//
//        model.addAttribute("article", article);
//
//        return "enrolment-detail";
//    }
//
//}
