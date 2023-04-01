/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Livestreams;
import com.java.repositories.LivestreamsRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AnChuPC
 */
@Repository
@Transactional
public class LivestreamsRepositoryImpl implements LivestreamsRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Livestreams> getLivestreams(Map<String, String> params) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Livestreams> query = builder.createQuery(Livestreams.class);
        Root root = query.from(Livestreams.class);
        query.select(root);
        
        if(params != null) {
            
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Livestreams getLiveStreamById(String id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Livestreams> query = builder.createQuery(Livestreams.class);
        Root root = query.from(Livestreams.class);
        query.select(root);
        
        query.where(builder.equal(root.get("id"), id));
        
        Query q = session.createQuery(query);
        return (Livestreams) q.getSingleResult();
    }

    @Override
    public boolean addOrUpdateLivestream(Livestreams livestream) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        try {
             session.save(livestream);
             return true;
        } catch(HibernateError err) {
            return false;
        }
    }
    
}
