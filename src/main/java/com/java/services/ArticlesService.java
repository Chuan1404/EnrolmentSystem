/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cuong0311
 */
public interface ArticlesService {

    public Articles getArticleById(String id);

    public boolean saveOrUpdateArticles(Articles article);
    
    public boolean deleteArticle(String id);

    public Long getTotalRow(ArticleType type);
    
    public List<Articles> getArticles(Map<String, String> params);
}
