/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Articles;
import com.java.repositories.ArticlesRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cuong0311
 */
@Repository
@Transactional
public class ArticlesRepositoryImpl implements ArticlesRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Articles getArticleById(String id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Articles> query = builder.createQuery(Articles.class);
        Root root = query.from(Articles.class);
        Predicate p = builder.equal(root.get("id"), id);
        query.where(p);
        Query q = s.createQuery(query);
        Articles articles = (Articles) q.getSingleResult();
        return articles;
    }

    @Override
    public boolean saveOrUpdateArticles(Articles article) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(article);
        }
        catch (HibernateException ex) {
            return false;
        }
        return true;
    }
    
}
