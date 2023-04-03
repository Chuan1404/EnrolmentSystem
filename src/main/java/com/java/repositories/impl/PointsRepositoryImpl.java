/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Points;
import com.java.repositories.PointsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class PointsRepositoryImpl implements PointsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Points> getRecentPoints(int majorId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Points> query = builder.createQuery(Points.class);
        Root root = query.from(Points.class);
        Predicate p = builder.equal(root.get("major"), majorId);
        query.where(p);
        query.orderBy(builder.desc(root.get("point")));
        Query q = s.createQuery(query);
        return q.setMaxResults(5).getResultList();
    }

    @Override
    public int getMaxYearByMajorId(int majorId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root root = query.from(Points.class);
        query.select(builder.max(root.get("year")));
        Predicate p = builder.equal(root.get("major"), majorId);
        query.where(p);
        Query q = s.createQuery(query);
        return (int) q.getSingleResult();
    }
    
}
