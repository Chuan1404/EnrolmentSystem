/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.api;

import com.java.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AnChuPC
 */
@RestController
public class ApiArticleController {
    
    @Autowired
    private ArticlesService articlesService;
    
    @DeleteMapping(value = "/api/article/{id}")
    private void deleteArticle(@PathVariable(value = "id") String id) {
        boolean res = articlesService.deleteArticle(id);
        
        System.out.println("DELETE");
    }
}
