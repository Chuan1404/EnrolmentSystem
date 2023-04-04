/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.enums.ArticleType;
import com.java.pojos.Articles;
import com.java.repositories.ArticlesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
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
public class ArticlesRepositoryImpl implements ArticlesRepository {

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
            if(article.getId() != null) {
                s.update(article);
            }
            else {
                article.setId(UUID.randomUUID().toString());
                s.save(article);
            }
        } catch (HibernateException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Long getTotalRow(ArticleType type) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q;
        if (type != null) {
            q = s.createQuery("select count(*) from Articles a where a.articleType like '%" + type.toString() + "%'");
        }
        else {
            q = s.createQuery("select count(*) from Articles a");
        }

        return (Long) q.getSingleResult();
    }

    @Override
    public List<Articles> getArticles(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Articles> query = builder.createQuery(Articles.class);
        Root root = query.from(Articles.class);
        query.select(root);

        List<Predicate> predicateList = new ArrayList<>();

        int limit = 10;
        if (params != null) {

            // limit
            if (params.get("limit") != null) {
                limit = Integer.parseInt(params.get("limit"));
            }
            // article type
            if (params.get("articleType") != null) {
                String type = params.get("articleType");
                Predicate p = builder.equal(root.get("articleType").as(String.class), type);
                predicateList.add(p);
            }
        }

        query.where(predicateList.toArray(Predicate[]::new));

        // Query
        Query q = s.createQuery(query);
        q.setMaxResults(limit);

        if (params != null && params.get("page") != null) {
            int page = Integer.parseInt(params.get("page"));
            int startIndex = (page - 1) * limit;
            int totalArticles = Integer.parseInt(params.get("totalArticles"));

            if (startIndex < totalArticles) {
                q.setFirstResult(startIndex);
            }
        }

        return q.getResultList();
    }

    @Override
    public boolean deleteArticle(String id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Articles article = this.getArticleById(id);
        
        try {
            session.delete(article);
            return true;
        } catch(HibernateException err) {
            return false;
        }
    }

}
