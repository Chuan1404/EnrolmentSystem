/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Questions;
import com.java.repositories.QuestionsRepository;
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
    
}
