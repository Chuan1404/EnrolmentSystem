/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Articles;
import com.java.pojos.Comments;
import com.java.repositories.CommentRepository;
import java.util.List;
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
 * @author jackc
 */
@Transactional
@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Comments> getComments(Articles articles) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comments> query = builder.createQuery(Comments.class);
        Root root = query.from(Comments.class);
        Predicate p1 = builder.isNull(root.get("baseCommentId").as(Comments.class));
        Predicate p2 = builder.equal(root.get("articleId").as(Articles.class), articles);
        query.where(builder.and(p1, p2));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Comments addComment(Comments comment) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(comment);
            return comment;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comments> getReplies(Comments comment) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comments> query = builder.createQuery(Comments.class);
        Root root = query.from(Comments.class);
        Predicate p1 = builder.isNotNull(root.get("baseCommentId").as(Comments.class));
        Predicate p2 = builder.equal(root.get("baseCommentId").as(Comments.class), comment);
        query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
