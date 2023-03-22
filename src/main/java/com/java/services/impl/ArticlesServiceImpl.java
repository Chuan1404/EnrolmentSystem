/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Articles;
import com.java.repositories.ArticlesRepository;
import com.java.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cuong0311
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;
    
    @Override
    public Articles getArticleById(String id) {
        return articlesRepository.getArticleById(id);
    }

    @Override
    public boolean saveOrUpdateArticles(Articles article) {
        return articlesRepository.saveOrUpdateArticles(article);
    }
    
}
