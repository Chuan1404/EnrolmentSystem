/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Homepage;
import com.java.repositories.HomepageRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
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
@Repository
@Transactional
public class HomepageRepositoryImpl implements HomepageRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Homepage getHomepage() {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaQuery<Homepage> q = s.getCriteriaBuilder().createQuery(Homepage.class);
        q.from(Homepage.class);
        Query query = s.createQuery(q);
        return (Homepage) query.getSingleResult();
    }

    @Override
    public boolean updateHomepage(Homepage home) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(home);
            return true;
        } catch(HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
