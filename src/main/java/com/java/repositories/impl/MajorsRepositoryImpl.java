/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Majors;
import com.java.repositories.MajorsRepository;
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
public class MajorsRepositoryImpl implements MajorsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Majors> getMajors(int facultyId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Majors> query = builder.createQuery(Majors.class);
        Root root = query.from(Majors.class);
        query.select(root);
        Predicate p = builder.equal(root.get("faculty"), facultyId);
        query.where(p);
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public int countMajorsByFacultyId(int facultyId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root root = query.from(Majors.class);
        query.select(builder.count(root.get("id")).as(Integer.class));
        Predicate p = builder.equal(root.get("faculty"), facultyId);
        query.where(p);
        Query q = s.createQuery(query);
        return (int) q.getSingleResult();
    }
     
}
