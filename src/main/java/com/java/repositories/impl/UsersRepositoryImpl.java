/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.java.enums.UserRole;
import com.java.pojos.Users;
import com.java.repositories.UsersRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
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
 * @author AnChuPC
 */
@Repository
@Transactional
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;
    

    @Override
    public Users getUserById(String id) {
        Session session = sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = b.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);

        query.select(root);
        query.where(b.equal(root.get("id"), id));

        Query q = session.createQuery(query);
        return (Users) q.getSingleResult();
    }

    @Override
    public boolean addOrUpdateUser(Users u) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {

            if (u.getId() != null) {
                session.update(u);
            } else {
                u.setId(UUID.randomUUID().toString());
                u.setUserRole(UserRole.ROLE_USER.name());
                session.save(u);
            }
            return true;

        } catch (Exception err) {
            return false;
        }
    }

    @Override
    public Users getUsersByUsername(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = b.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);

        query.select(root);

        if (!name.isEmpty()) {
            query.where(b.equal(root.get("username"), name));
        }

        try {
            Query q = session.createQuery(query);
            return (Users) q.getSingleResult();
        } catch (NoResultException err) {
            return null;
        }
    }

    @Override
    public Users getUserByEmail(String email) {
        Session session = sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = b.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);

        query.select(root);

        if (!email.isEmpty()) {
            query.where(b.equal(root.get("email"), email));
        }

        try {
            Query q = session.createQuery(query);
            return (Users) q.getSingleResult();
        } catch (NoResultException err) {
            return null;
        }
    }
    @Override
    public List<Users> getUsersByUserRole(UserRole userRole) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root root = query.from(Users.class);
        Predicate p = builder.equal(root.get("userRole"), userRole.toString());
        query.where(p);
        Query q = session.createQuery(query);
        return q.getResultList();
    } 

}
