/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import java.util.List;

/**
 *
 * @author Cuong0311
 */
public interface ArticlesService {

    Articles getArticleById(String id);

    boolean saveOrUpdateArticles(Articles article);

    public List<Articles> getListArticleNewest(ArticleType type, int amount);
}
