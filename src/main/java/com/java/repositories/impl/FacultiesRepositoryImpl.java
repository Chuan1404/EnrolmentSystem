/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.pojos.Faculties;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.java.repositories.FacultiesRepository;
import javax.persistence.criteria.Predicate;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jackc
 */
@Repository
@Transactional
public class FacultiesRepositoryImpl implements FacultiesRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Faculties> getFaculties() {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Faculties> query = builder.createQuery(Faculties.class);
        query.from(Faculties.class);
        Query q = s.createQuery(query);
        return q.getResultList();
       
    }

    @Override
    public Faculties getFacultyById(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Faculties> query = builder.createQuery(Faculties.class);
        Root root = query.from(Faculties.class);
        Predicate p = builder.equal(root.get("id"), id);
        query.where(p);
        Query q = s.createQuery(query);
        return (Faculties) q.getSingleResult();
    }

    @Override
    public boolean saveOrUpdateFaculty(Faculties faculty) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            if (faculty.getId() == null)
                s.save(faculty);
            else
                s.update(faculty);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
