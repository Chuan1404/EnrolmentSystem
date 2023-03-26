/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Images;
import com.java.repositories.ImagesRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
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
public class ImagesRepositoryImpl implements ImagesRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Images> getImagesByBannerId(int bannerId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaQuery<Images> q = s.getCriteriaBuilder().createQuery(Images.class);
        q.from(Images.class);
        Query query = s.createQuery(q);
        return query.getResultList();
    }
    
}
