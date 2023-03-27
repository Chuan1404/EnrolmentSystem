/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cuong0311
 */
public interface ArticlesRepository {

    Articles getArticleById(String id);
    
    boolean saveOrUpdateArticles(Articles article);

    public List<Articles> getListArticleNewest(ArticleType type, int amount);
    
    public Long getTotalRow(ArticleType type);
    
    public List<Articles> getArticles(Map<String, String> params);
    
}
