// /*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.java.repositories.impl;
//
//import com.java.pojos.Users;
//import com.java.repositories.UsersRepository;
//import java.util.List;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author AnChuPC
// */
//@Repository
//@Transactional
//public class UsersRepositoryImpl implements UsersRepository {
//
//    @Autowired
//    LocalSessionFactoryBean sessionFactory;
//
//    @Override
//    public Users getUserById(String id) {
//        Session session = sessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Users> query = b.createQuery(Users.class);
//        Root<Users> root = query.from(Users.class);
//
//        query.select(root);
//        query.where(b.equal(root.get("id"), id));
//
//        Query q = session.createQuery(query);
//        return (Users) q.getSingleResult();
//    }
//
//    @Override
//    public boolean addUser(Users u) {
//        Session session = sessionFactory.getObject().getCurrentSession();
//        try {
//            session.save(u);
//            return true;
//
//        } catch (Exception err) {
//            return false;
//        }
//    }
//
//    @Override
//    public List<Users> getUsersByUsername(String name) {
//        Session session = sessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Users> query = b.createQuery(Users.class);
//        Root<Users> root = query.from(Users.class);
//
//        query.select(root);
//
//        if (!name.isEmpty()) {
//            query.where(b.equal(root.get("username"), name));
//        }
//
//        Query q = session.createQuery(query);
//        return q.getResultList();
//    }
//
//}
