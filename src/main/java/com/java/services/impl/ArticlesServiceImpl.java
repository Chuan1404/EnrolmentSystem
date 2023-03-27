/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.repositories.ArticlesRepository;
import com.java.services.ArticlesService;
import java.util.List;
import java.util.Map;
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

    @Override
    public Long getTotalRow(ArticleType type) {
        return articlesRepository.getTotalRow(type);
    }

    @Override
    public List<Articles> getArticles(Map<String, String> params) {
        return articlesRepository.getArticles(params);
    }

}
