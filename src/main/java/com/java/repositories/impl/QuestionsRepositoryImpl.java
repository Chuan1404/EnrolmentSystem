/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Livestreams;
import com.java.pojos.Questions;
import com.java.repositories.QuestionsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class QuestionsRepositoryImpl implements QuestionsRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addQuestion(Questions question) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(question);
            return true;
        } catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Questions> getQuestionsByLivestream(Livestreams livestream) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
        Root root = query.from(Questions.class);
        Predicate p = builder.equal(root.get("livestreamId").as(Livestreams.class), livestream);
        query.where(p);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Questions getQuestionById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
        Root root = query.from(Questions.class);
        Predicate p = builder.equal(root.get("id"), id);
        query.where(p);
        Query q = session.createQuery(query);
        return (Questions) q.getSingleResult();
    }
    
}
