/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.formatter;

import com.java.pojos.Articles;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author jackc
 */
public class ArticlesFormatter implements Formatter<Articles>{

    @Override
    public String print(Articles article, Locale locale) {
        return String.valueOf(article.getId());
    }

    @Override
    public Articles parse(String id, Locale locale) throws ParseException {
        Articles article = new Articles();
        article.setId(id);
        return article;
    }
    
}
