/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.pojos.Faculties;
import com.java.repositories.ArticlesRepository;
import com.java.repositories.FacultiesRepository;
import com.java.services.ArticlesService;
import com.java.services.FacultiesService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class FacultiesServiceImpl implements FacultiesService {

    @Autowired
    private FacultiesRepository facultiesRepository;
    
    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public List<Faculties> getFaculties() {
        return facultiesRepository.getFaculties();
    }

    @Override
    public Faculties getFacultyById(int id) {
        return facultiesRepository.getFacultyById(id);
    }

    @Override
    public boolean addFaculty(Faculties faculty) {
        Articles article = new Articles();
        article.setTitle("Thông tin khoa " + faculty.getName());
        article.setArticleType(ArticleType.KHOA.name());
        article.setCreatedDate(new Date());
        article.setUpdateDate(new Date());
        articlesRepository.saveOrUpdateArticles(article);
        faculty.setArticleId(article);
        return facultiesRepository.addFaculty(faculty);
    }

}
